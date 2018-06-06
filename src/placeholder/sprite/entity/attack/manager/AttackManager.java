package placeholder.sprite.entity.attack.manager;

import java.util.Map;
import placeholder.item.equipment.weaponequipment.Hitbox;
import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.screen.TickUpdatable;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.sprite.entity.attack.Attack;
import placeholder.sprite.entity.attack.AttackType;
import placeholder.sprite.entity.attack.MeleeAttack;
import static placeholder.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_COOLDOWN;
import static placeholder.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_DURATION;
import static placeholder.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_HITBOX;
import static placeholder.sprite.entity.attack.manager.PlayerAttackManager.DEFAULT_ATTACK_INVINCIBILITYSTUN;

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

    public void registerAttackCooldown(int attackCooldown) {
        this.attackCooldown = attackCooldown;
    }
    
    @Override
    public void render(Renderer renderer) {
        if (meleeAttack != null) {
            meleeAttack.render(renderer);
        }
    }
    
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
    
    
    
    
    
}
