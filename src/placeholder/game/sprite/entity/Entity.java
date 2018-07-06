/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.entity;

import placeholder.game.sprite.entity.attack.manager.AttackManager;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import placeholder.game.input.Direction;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.loot.LootTable;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.collision.CollisionDetector;
import placeholder.game.sprite.collision.DefaultCollisionDetector;
import placeholder.game.sprite.DirectionDependent;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.collision.CollisionalPlaneCreator;
import placeholder.game.sprite.entity.attack.Attack;
import placeholder.game.sprite.entity.attack.AttackClient;
import placeholder.game.sprite.entity.attack.AttackType;
import placeholder.game.sprite.entity.attack.Hittable;
import placeholder.game.sprite.entity.attack.MeleeAttack;
import placeholder.game.sprite.entity.hitsplat.HitsplatDisplayer;
import placeholder.game.util.Amount;

/**
 *
 * @author jdolf
 */
public abstract class Entity<T extends AttackManager> extends Sprite implements AttackClient, Hittable, DirectionDependent, CollisionalPlaneCreator {
    
    protected LootTable lootTable = new LootTable();
    protected boolean emitsXp = true;
    protected boolean dead = false;
    protected int deathDuration = 60;
    protected placeholder.game.map.Map map;
    protected boolean moving = false;
    protected T attackManager;
    protected CollisionDetector cd;
    protected Direction direction = Direction.DOWN;
    protected Health health;
    protected HealthBar healthbar;
    protected HitsplatDisplayer hitsplatDisplayer;
    private boolean initialized = false;
    protected double walkSpeed = 1.0;
    protected int initHealth = 1;
    protected int meleeStrength = 0;
    protected int meleeDefense = 0;
    protected int rangeStrength = 0;
    protected int rangeDefense = 0;
    protected int magicStrength = 0;
    protected int magicDefense = 0;
    
    public Entity(
            Dimension dimension,
            Point2D location) {
        super(dimension, location);
        lootTable.setStartPosition(location);
    }

    @Override
    public void attack() {
        if (attackManager.canAttack()) {
            attackManager.attack();
        }
    }

    @Override
    public void hit(Attack attack) {
        this.health.remove(attack.getDamage());
        if (this.health.getAmount() <= 0) dead = true;
    }
    
    public void die() {
        lootTable.roll().forEach((item) -> {
            map.addItem(item);
        });
        map.removeSprite(this);
    }

    @Override
    public boolean isEmittingXp() {
        return this.emitsXp;
    }

    @Override
    public void tickUpdate() {
        if (!initialized) {
            initialized = true;
            attackManager.registerSource(this);
            health = new Health(initHealth);
            this.healthbar = new HealthBar(health, this);
            hitsplatDisplayer = new HitsplatDisplayer(health, this);
        } else {
            attackManager.tickUpdate();
            hitsplatDisplayer.tickUpdate();
            this.moving = false;
            if (this.dead && deathDuration > 0) deathDuration -= 1;
            if (deathDuration == 0) die();
        }
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void render(Renderer renderer) {
        if (initialized) {
            healthbar.render(renderer);
            hitsplatDisplayer.render(renderer);
        }
        attackManager.render(renderer);
    }

    public void tryMove(Direction direction) {
        setDirection(direction);
        Point2D offset = direction.calculateOffsetChanges(walkSpeed);
        Point2D testLocation = ScreenItem.mergePoints(offset, this.getPosition());
        
        if (!cd.collidesAt(testLocation).hasCollisionOccurrence()) {
            this.move(testLocation);
        }
    }
    
    public void move(Point2D target) {
        moving = true;
        this.setPosition(target);
    }
    
    public boolean isMoving() {
        return this.moving;
    }
    
    public void setCollisionDetector(CollisionDetector cd) {
        this.cd = cd;
    }
    
    public void setMap(placeholder.game.map.Map map) {
        this.map = map;
        this.cd = new DefaultCollisionDetector(this, map);
    }
    
    public placeholder.game.map.Map getMap() {
        return this.map;
    }
    
    public T getAttackManager() {
        return this.attackManager;
    }

    public double getWalkSpeed() {
        return walkSpeed;
    }

    public int getMeleeStrength() {
        return meleeStrength;
    }

    public int getMeleeDefense() {
        return meleeDefense;
    }

    public int getRangeStrength() {
        return rangeStrength;
    }

    public int getRangeDefense() {
        return rangeDefense;
    }

    public int getMagicStrength() {
        return magicStrength;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public boolean isDead() {
        return dead;
    }
    
}
