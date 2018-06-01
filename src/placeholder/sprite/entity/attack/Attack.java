package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.Point;
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
import placeholder.sprite.collision.DefaultCollisionDetector;
import placeholder.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public abstract class Attack extends ScreenItem implements TickUpdatable, Renderable {
    
    private Map<Hittable, Integer> attackInvincibilities = new HashMap();
    private boolean initialized = false;
    private AttackType type;
    protected int baseDamage;
    private int damage;
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
    private CollisionDetector cd;
    private CollisionCheck collisionCheck;

    public Attack(AttackType type,
            AttackClient attacker,
            Dimension hitbox,
            int baseDamage,
            int duration,
            int invincibilityStun) {
        super(attacker.getPosition(), hitbox);
        this.type = type;
        this.attacker = attacker;
        this.baseDamage = baseDamage;
        this.duration = duration;
        this.invincibilityStun = invincibilityStun;
        cd = new DefaultCollisionDetector(this, attacker.getMap().getSpriteReceiver());
    }
    
    public Attack(AttackType type,
            AttackClient attacker,
            Point position,
            Dimension hitbox,
            int baseDamage,
            int duration,
            int invincibilityStun) {
        super(position, hitbox);
        this.type = type;
        this.attacker = attacker;
        this.baseDamage = baseDamage;
        this.duration = duration;
        this.invincibilityStun = invincibilityStun;
        cd = new DefaultCollisionDetector(this, attacker.getMap().getSpriteReceiver());
    }

    @Override
    public final void tickUpdate() {
        collisionCheck = this.cd.collidesAt(this.getPosition(), Arrays.asList(attacker));

        if (initialized) {
            if (startUpTime == 0) {
                if (collisionCheck.hasCollisionOccurrence()) {
                    for (Sprite sprite : collisionCheck.getCollisionPartners()) {

                        if (sprite instanceof Hittable) {
                            this.hitVictim((Hittable) sprite);
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

    @Override
    public void render(Renderer renderer) {
        if (startUpTime == 0) {
            renderer.renderRect(Color.RED, this);
        } else {
            renderer.renderRect(Color.BLACK, this);
        }
    }
    
    public void hitVictim(Hittable hittable) {
        if (!attackInvincibilities.keySet().contains(hittable)) {
            calculateDamage();
            hittable.hit(this);
            this.attackInvincibilities.put(hittable, invincibilityStun);
        }
    }
    
    private void calculateDamage() {
        this.damage = baseDamage;
    }
    
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
