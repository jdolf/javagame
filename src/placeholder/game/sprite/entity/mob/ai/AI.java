package placeholder.game.sprite.entity.mob.ai;

import java.awt.Dimension;
import java.util.List;
import placeholder.game.input.Direction;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.attack.manager.AttackManager;
import placeholder.game.sprite.entity.mob.Mob;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class AI<T extends Mob, T2 extends AttackManager> implements TickUpdatable {
    
    protected T owner;
    protected T2 attackManager;
    protected int reactionTimer;
    protected Player target;
    protected Dimension attackRadius;
    protected Dimension playerSearchRadius = new Dimension(1, 1);
    protected int reactionTime = 10;
    
    public AI(T owner, T2 attackManager) {
        this.owner = owner;
        this.attackManager = attackManager;
    }

    @Override
    public void tickUpdate() {
        if (reactionTimer == reactionTime) {
            reactionTimer = 0;
            target = null;
            if (owner.getMap() != null) {
                List<Sprite> sprites = owner.getMap().getSpriteReceiver().getAt(
                        ScreenItem.shiftBackByHalfOfDimension(playerSearchRadius, owner.getPosition()), playerSearchRadius
                );
                sprites.forEach((sprite) -> {
                   if (sprite instanceof Player) {
                       target = (Player) sprite;
                   }
                });
            }
            
        }
        
        reactionTimer++;
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
