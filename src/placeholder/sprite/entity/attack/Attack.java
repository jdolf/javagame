package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javafx.scene.paint.Color;
import placeholder.item.equipment.weaponequipment.Hitbox;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.PositionChangeListener;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.sprite.Sprite;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.collision.CollisionCheck;
import placeholder.sprite.collision.CollisionDetector;
import placeholder.sprite.collision.CollisionalPlane;
import placeholder.sprite.collision.DefaultCollisionDetector;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class Attack extends CollisionalPlane {
    
    private Map<Hittable, Integer> attackInvincibilities = new HashMap();
    private boolean initialized = false;
    private AttackType type;
    protected int baseDamage;
    protected int damage;
    Random random = new Random();
    /**
     * How long the attack should stay active for. Mainly used by animation.
     */
    protected int duration = 15;
    /**
     * How long the attack cant hit the same enemy after it hit the enemy.
     * Piercing effect is possible with low values.
     */
    protected int invincibilityStun = 15;
    /**
     * Time it takes for this attack to start making damage.
     */
    protected int startUpTime = 0;
    private AttackClient attacker;

    public Attack(AttackType type,
            AttackClient attacker,
            Dimension hitbox,
            int baseDamage,
            int duration,
            int invincibilityStun) {
        super(
                attacker,
                hitbox,
                Arrays.asList(attacker),
                attacker.getMap()
        );
        this.type = type;
        this.attacker = attacker;
        this.baseDamage = baseDamage;
        this.duration = duration;
        this.invincibilityStun = invincibilityStun;
    }
    
    public Attack(AttackType type,
            AttackClient attacker,
            Point2D position,
            Dimension hitbox,
            int baseDamage,
            int duration,
            int invincibilityStun) {
        super(
                attacker,
                hitbox,
                Arrays.asList(attacker),
                attacker.getMap()
        );
        this.type = type;
        this.attacker = attacker;
        this.baseDamage = baseDamage;
        this.duration = duration;
        this.invincibilityStun = invincibilityStun;
    }
    
    protected void supplyXp(Player player) {
        player.getSkillManager().getHitpoints().addExperience(damage * 2);
    }

    @Override
    public final void tickUpdate() {
        super.tickUpdate();
        if (initialized) {
            if (startUpTime == 0) {
                if (collisionCheck.hasCollisionOccurrence()) {
                    for (Sprite sprite : collisionCheck.getCollisionPartners()) {
                        if (sprite instanceof Hittable) {
                            if (!attackInvincibilities.keySet().contains(sprite)) {
                                this.hitVictim((Hittable) sprite);
                            }
                        }
                    }
                }
            }
        }
        
        if (startUpTime > 0) this.startUpTime -= 1;
        if (startUpTime == 0 && duration > 0) this.duration -= 1;
        
        for (Map.Entry<Hittable, Integer> set : attackInvincibilities.entrySet()) {
            set.setValue(set.getValue() - 1);
        }

        attackInvincibilities.entrySet().removeIf((set) -> {
            return set.getValue() == 0;
        });
        
        initialized = true;
    }
    
    public void hitVictim(Hittable hittable) {
        calculateDamage(hittable);
        hittable.hit(this);
        if (hittable.isEmittingXp() && attacker instanceof Player) {
            this.supplyXp((Player) attacker);
        }
        this.attackInvincibilities.put(hittable, invincibilityStun);
    }
    
    private final void calculateDamage(Hittable hittable) {
        // Calculate damage from defense
        int damage = calculateDamageImpl(hittable);
        // Make it random, at least half of max hit
        damage = damage - random.nextInt(damage / 2 + 1);
        if (damage < 1) damage = 1;
        this.damage = damage;
    }
    
    protected abstract int calculateDamageImpl(Hittable hittable);
    
    public AttackType getType() {
        return type;
    }

    public void setType(AttackType type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }
    
    public AttackClient getAttackClient() {
        return this.attacker;
    }
    
    public CollisionCheck getCollisionCheck() {
        return this.collisionCheck;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void addBaseDamage(int baseDamage) {
        this.baseDamage += baseDamage;
    }

    public int getDuration() {
        return duration;
    }

    public int getInvincibilityStun() {
        return invincibilityStun;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setInvincibilityStun(int invincibilityStun) {
        this.invincibilityStun = invincibilityStun;
    }

    public void setStartUpTime(int startUpTime) {
        this.startUpTime = startUpTime;
    }

    public int getStartUpTime() {
        return startUpTime;
    }

    
    
    
    
    
    
}
