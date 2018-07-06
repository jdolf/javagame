package placeholder.game.sprite.entity.attack.manager;

import java.awt.Dimension;
import java.util.Collection;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.sprite.entity.attack.Attack;
import placeholder.game.sprite.entity.attack.MeleeAttack;
import placeholder.game.sprite.entity.mob.Mob;

/**
 *
 * @author jdolf
 */
public class SimpleAttackManager<T extends Mob> extends AttackManager<T> {
    
    private Attack attack;
    private int cooldown;

    public SimpleAttackManager(Attack attack, int cooldown, int startUpTime) {
        this.attack = attack;
        this.cooldown = cooldown;
        this.defaultStartUpTime = startUpTime;
    }

    @Override
    protected int attackImpl() {
        return cooldown;
    }

    @Override
    public void registerSource(T source) {
        super.registerSource(source);
        attack.setAttacker(source);
    }
    
    public Attack getAttack() {
        return this.attack;
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        if (isGoingToAttack && startUpTime <= 0) {
            attack.attack();
            isGoingToAttack = false;
        }
    }
    
    
    
    
    
}
