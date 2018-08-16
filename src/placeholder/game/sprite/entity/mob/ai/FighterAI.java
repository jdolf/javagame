package placeholder.game.sprite.entity.mob.ai;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.List;
import placeholder.game.input.Direction;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.attack.MeleeAttack;
import placeholder.game.sprite.entity.attack.manager.AttackManager;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;
import placeholder.game.sprite.entity.mob.Mob;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class FighterAI extends SimpleAI {
    
    public static final Dimension PLAYER_SEARCH_DIMENSION = new Dimension(300, 300);

    public FighterAI(Mob owner, SimpleAttackManager manager) {
        super(owner, manager);
        attackRadius = new Dimension(
                (int) owner.getDimension().getWidth() + 20,
                (int) owner.getDimension().getHeight() + 20
        );
        this.playerSearchRadius = PLAYER_SEARCH_DIMENSION;
    }

    
}
