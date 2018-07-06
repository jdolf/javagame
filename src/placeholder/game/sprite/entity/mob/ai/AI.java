package placeholder.game.sprite.entity.mob.ai;

import java.awt.Dimension;
import placeholder.game.input.Direction;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.entity.attack.manager.AttackManager;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;
import placeholder.game.sprite.entity.mob.Mob;

/**
 *
 * @author jdolf
 */
public abstract class AI<T extends Mob, T2 extends AttackManager> implements TickUpdatable {
    
    protected T owner;
    protected T2 attackManager;
    
    public AI(T owner, T2 attackManager) {
        this.owner = owner;
        this.attackManager = attackManager;
    }
    
    public static Dimension distanceFromMobToTarget(ScreenItem owner, ScreenItem target) {
        Dimension distanceFromMobToPlayer;
            distanceFromMobToPlayer = new Dimension(
                    (int) (target.getMiddlePosition().getX() - owner.getMiddlePosition().getX()),
                    (int) (target.getMiddlePosition().getY() - owner.getMiddlePosition().getY())
            );
       return distanceFromMobToPlayer;
    }
    
    
}
