package placeholder.game.sprite.entity.mob.ai;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.List;
import placeholder.game.input.Direction;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.attack.MeleeAttack;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;
import placeholder.game.sprite.entity.mob.Mob;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class FighterAI extends AI<Mob, SimpleAttackManager> {
    
    public static final Dimension PLAYER_SEARCH_DIMENSION = new Dimension(300, 300);
    public static final double PLAYER_ATTACK_RADIUS = 100;
    public static final int REACTION_TIME = 10;
    private int reactionTimer = 0;
    private Player target = null;
    private Dimension attackRadius;

    public FighterAI(Mob owner, SimpleAttackManager manager) {
        super(owner, manager);
        attackRadius = new Dimension(
                (int) owner.getDimension().getWidth() + 20,
                (int) owner.getDimension().getHeight() + 20
        );
    }

    @Override
    public void tickUpdate() {
        Dimension distanceFromMobToPlayer;
        
        if (reactionTimer == REACTION_TIME) {
            reactionTimer = 0;
            target = null;
            if (owner.getMap() != null) {
                List<Sprite> sprites = owner.getMap().getSpriteReceiver().getAt(
                        ScreenItem.shiftBackByHalfOfDimension(PLAYER_SEARCH_DIMENSION, owner.getPosition()), PLAYER_SEARCH_DIMENSION
                );
                sprites.forEach((sprite) -> {
                   if (sprite instanceof Player) {
                       target = (Player) sprite;
                   }
                });
            }
            
        }
        
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
        
        reactionTimer += 1;
    }
    
}
