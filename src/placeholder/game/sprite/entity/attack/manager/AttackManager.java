package placeholder.game.sprite.entity.attack.manager;

import java.util.Map;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.attack.Attack;
import placeholder.game.sprite.entity.attack.AttackType;
import placeholder.game.sprite.entity.attack.MeleeAttack;

/**
 *
 * @author jdolf
 */
public abstract class AttackManager<T extends Entity> implements TickUpdatable, Renderable {
    
    /**
     * The target this attack manager belongs to
     */
    protected T source;
    protected boolean attacking = false;
    protected int attackCooldown = 0;
    protected int defaultStartUpTime = 0;
    protected int startUpTime = 0;
    protected int cooldownReductionPercent = 0;
    protected boolean isGoingToAttack = false;
    
    /**
     * The implementation of attack.
     * @return The attack cooldown.
     */
    protected abstract int attackImpl();

    public void attack() {
        isGoingToAttack = true;
        attacking = true;
        startUpTime = defaultStartUpTime;
    }

    @Override
    public void tickUpdate() {
        
        if (source.isDead()) {
            attacking = false;
            isGoingToAttack = false;
        }
        
        if (isGoingToAttack && attackCooldown <= 0) {
            registerAttackCooldown(attackImpl());
        }
        
        if (startUpTime > 0) {
            startUpTime -= 1;
        } else if (attacking) {
            if (attackCooldown <= 0) {
                attacking = false;
            }
            if (attackCooldown > 0) {
                attackCooldown -= 1;
            }
        }
        
    }
    
    public boolean canAttack() {
        return !attacking && !isGoingToAttack;
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
    
    public void setCooldownReductionPercent(int cooldownReductionPercent) {
        this.cooldownReductionPercent = cooldownReductionPercent;
    }

    public int getStartUpTime() {
        return startUpTime;
    }
    
    
    
    
    
}
