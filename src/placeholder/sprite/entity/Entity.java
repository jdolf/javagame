/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.entity;

import placeholder.sprite.entity.attack.manager.AttackManager;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import placeholder.input.Direction;
import placeholder.item.equipment.weaponequipment.Hitbox;
import placeholder.screen.animation.Animation;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderer;
import placeholder.sprite.collision.CollisionDetector;
import placeholder.sprite.collision.DefaultCollisionDetector;
import placeholder.sprite.DirectionDependent;
import placeholder.sprite.Sprite;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.entity.attack.Attack;
import placeholder.sprite.entity.attack.AttackClient;
import placeholder.sprite.entity.attack.AttackType;
import placeholder.sprite.entity.attack.Hittable;
import placeholder.sprite.entity.attack.MeleeAttack;
import placeholder.util.Amount;

/**
 *
 * @author jdolf
 */
public abstract class Entity extends Sprite implements AttackClient, Hittable, DirectionDependent {
    
    protected placeholder.map.Map map;
    protected boolean moving = false;
    protected AttackManager attackManager;
    protected CollisionDetector cd;
    protected Direction direction = Direction.DOWN;
    protected Health health;
    protected HealthBar healthbar;
    private boolean initialized = false;
    protected int walkSpeed = 1;
    protected int initHealth = 30;
    protected int meleeStrength = 0;
    protected int meleeDefense = 0;
    protected int rangeStrength = 0;
    protected int rangeDefense = 0;
    protected int magicStrength = 0;
    protected int magicDefense = 0;
    protected int attackSpeed = 60;
    
    public Entity(
            Dimension dimension,
            Point location,
            AttackManager attackManager) {
        super(dimension, location);
        this.attackManager = attackManager;
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
    }

    @Override
    public void tickUpdate() {
        if (!initialized) {
            initialized = true;
            attackManager.registerSource(this);
            health = new Health(initHealth);
            this.healthbar = new HealthBar(health, this);
        } else {
            attackManager.tickUpdate();
            this.moving = false;
        }
    }

    @Override
    public void setMeleeAttack(MeleeAttack meleeAttack) {
        attackManager.setMeleeAttack(meleeAttack);
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
        }
        attackManager.render(renderer);
    }

    public void tryMove(Direction direction) {
        setDirection(direction);
        Point offset = direction.calculateOffsetChanges(walkSpeed);
        Point testLocation = ScreenItem.mergePoints(offset, this.getPosition());
        
        if (!cd.collidesAt(testLocation).hasCollisionOccurrence()) {
            this.move(testLocation);
        }
    }
    
    public void move(Point target) {
        moving = true;
        this.setPosition(target);
    }
    
    public boolean isMoving() {
        return this.moving;
    }
    
    public void setCollisionDetector(CollisionDetector cd) {
        this.cd = cd;
    }
    
    public void setMap(placeholder.map.Map map) {
        this.map = map;
    }
    
    public placeholder.map.Map getMap() {
        return this.map;
    }
    
    public AttackManager getAttackManager() {
        return this.attackManager;
    }

    public int getWalkSpeed() {
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
    
    
    
}
