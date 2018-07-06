package placeholder.game.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javafx.scene.paint.Color;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.collision.CollisionCheck;
import placeholder.game.sprite.collision.CollisionDetector;
import placeholder.game.sprite.collision.CollisionalPlane;
import placeholder.game.sprite.collision.DefaultCollisionDetector;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;

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
    private boolean attackSwitch = false;
    private Random random = new Random();
    private int defaultDuration = 15;
    /**
     * How long the attack should stay active for. Mainly used by animation.
     */
    protected int duration = 30;
    /**
     * How long the attack cant hit the same enemy after it hit the enemy.
     * Piercing effect is possible with low values.
     */
    protected int invincibilityStun = 15;
    /**
     * Time it takes for this attack to start making damage.
     */
    protected AttackClient attacker;

    public Attack(AttackType type,
            AttackClient attacker,
            Dimension hitbox,
            int baseDamage,
            int duration,
            int invincibilityStun) {
        super(
                attacker,
                hitbox,
                Arrays.asList(attacker)
        );
        init(type, attacker, baseDamage, duration, invincibilityStun);
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
                Arrays.asList(attacker)
        );
        init(type, attacker, baseDamage, duration, invincibilityStun);
    }

    private void init(AttackType type1, AttackClient attacker1, int baseDamage1, int duration1, int invincibilityStun1) {
        this.type = type1;
        this.attacker = attacker1;
        this.baseDamage = baseDamage1;
        this.defaultDuration = duration1;
        this.invincibilityStun = invincibilityStun1;
    }
    
    public void attack() {
        attackSwitch = true;
        duration = defaultDuration;
        attacker.getMap().addAttack(this);
    }
    
    protected void supplyXp(Player player) {
        player.getSkillManager().getHitpoints().addExperience(damage * 2);
    }

    @Override
    public final void tickUpdate() {
        super.tickUpdate();
        
        if (initialized && attackSwitch) {
            if (collisionCheck != null && collisionCheck.hasCollisionOccurrence()) {
                for (Sprite sprite : collisionCheck.getCollisionPartners()) {
                    if (sprite instanceof Hittable) {
                        if (!attackInvincibilities.keySet().contains(sprite)) {
                            this.hitVictim((Hittable) sprite);
                            attackSwitch = false;
                        }
                    }
                }
            }
        }
        
        if (duration > 0) this.duration -= 1;
        
        for (Map.Entry<Hittable, Integer> set : attackInvincibilities.entrySet()) {
            set.setValue(set.getValue() - 1);
        }
        
        attackInvincibilities.entrySet().removeIf((set) -> {
            return set.getValue() == 0;
        });
        
        if (duration <= 0) attacker.getMap().removeAttack(this);
        
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

    public void setAttacker(AttackClient attackClient) {
        this.attacker = attackClient;
        calculateScreenItem(attacker, hitboxDown, Arrays.asList(attacker));
        this.cd.setMap(attackClient.getMap());
    }

    public int getDefaultDuration() {
        return defaultDuration;
    }
    
    
    
}
