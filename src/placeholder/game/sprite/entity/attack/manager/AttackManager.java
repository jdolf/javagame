package placeholder.game.sprite.entity.attack.manager;

import java.util.Map;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.attack.Attack;
import placeholder.game.sprite.entity.attack.AttackType;
import placeholder.game.sprite.entity.attack.MeleeAttack;
import static placeholder.game.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_COOLDOWN;
import static placeholder.game.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_DURATION;
import static placeholder.game.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_HITBOX;
import static placeholder.game.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_INVINCIBILITYSTUN;

/**
 *
 * @author jdolf
 */
public abstract class AttackManager<T> implements TickUpdatable, Renderable {
    
    /**
     * The target this attack manager belongs to
     */
    protected T source;
    protected boolean attacking = false;
    private int attackCooldown = 0;
    protected MeleeAttack meleeAttack;
    protected WeaponEquipment usedWeapon = null;
    protected int attackStartUpTime = 0;
    protected int startUpTime = 0;
    protected boolean initAttack = false;
    protected int cooldownReductionPercent = 0;

    public abstract void attack();
    protected void initializedAttack() {}

    @Override
    public void tickUpdate() {
        if (meleeAttack != null) {
            meleeAttack.tickUpdate();
            if (meleeAttack.getDuration() == 0) {
                meleeAttack = null;
            }
        }
            
        if (attackCooldown > 0) {
            attackCooldown -= 1;
        }
        
        if (attackCooldown <= 0) {
            attacking = false;
            usedWeapon = null;
        }
        
        if (startUpTime > 0) startUpTime -= 1;
        
        if (initAttack && startUpTime == 0) {
            initAttack = false;
            initializedAttack();
        }
        
    }
    
    public boolean canAttack() {
        return !attacking;
    }
    
    public void registerSource(T t) {
        this.source = t;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public int getAttackCooldown() {
        return attackCooldown;
    }

    protected void registerAttackCooldown(int attackCooldown) {
        this.attackCooldown = attackCooldown - attackCooldown * cooldownReductionPercent / 100;
    }
    
    @Override
    public void render(Renderer renderer) {}
    
    public void setMeleeAttack(MeleeAttack meleeAttack) {
        this.meleeAttack = meleeAttack;
    }

    public MeleeAttack getMeleeAttack() {
        return meleeAttack;
    }

    public WeaponEquipment getUsedWeapon() {
        return usedWeapon;
    }

    public boolean isInitAttack() {
        return initAttack;
    }
    
    public void setCooldownReductionPercent(int cooldownReductionPercent) {
        this.cooldownReductionPercent = cooldownReductionPercent;
    }
    
    
    
    
    
}
