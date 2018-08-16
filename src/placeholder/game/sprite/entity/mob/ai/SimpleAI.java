package placeholder.game.sprite.entity.mob.ai;

import placeholder.game.util.Dimension;
import placeholder.game.input.Direction;
import placeholder.game.sprite.entity.attack.manager.AttackManager;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;
import placeholder.game.sprite.entity.mob.Mob;
import static placeholder.game.sprite.entity.mob.ai.AI.distanceFromMobToTarget;

/**
 *
 * @author jdolf
 */
public class SimpleAI<T extends Mob, T2 extends SimpleAttackManager> extends AI<T, T2> {
    
    public SimpleAI(T owner, T2 attackManager) {
        super(owner, attackManager);
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        
        Dimension distanceFromMobToPlayer; 
        if (target != null && !target.isDead()) {
            distanceFromMobToPlayer = distanceFromMobToTarget(owner, target);
            if (distanceFromMobToPlayer.getWidth() > 0) {
                owner.tryMove(Direction.RIGHT);
            } else if (distanceFromMobToPlayer.getWidth() < 0) {
                owner.tryMove(Direction.LEFT);
            }
            if (distanceFromMobToPlayer.getHeight() > 0) {
                owner.tryMove(Direction.DOWN);
            } else if (distanceFromMobToPlayer.getHeight() < 0) {
                owner.tryMove(Direction.UP);
            }
            
            if (!target.isDead()
                    && distanceFromMobToPlayer.getWidth() <= attackRadius.getWidth()
                    && distanceFromMobToPlayer.getHeight() <= attackRadius.getHeight()) {
                if (owner.getAttackManager().canAttack()) {
                    attackManager.attack();
                }
                
            }
        }
    }
    
    
    
}
