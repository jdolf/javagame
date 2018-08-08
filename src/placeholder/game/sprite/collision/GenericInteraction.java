package placeholder.game.sprite.collision;

import java.awt.Dimension;
import java.util.Collection;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class GenericInteraction extends Interaction {
    
    private Player player;

    public GenericInteraction(Player player, Collection<Object> exceptions) {
        super(player, player.getAttackManager().getPunchAttack().getDimension(), exceptions);
        this.player = player;
    }

    @Override
    protected boolean requirementsMet(Sprite collisionPartner) {
        return collisionPartner instanceof Interactable;
    }

    @Override
    protected void onRequirementsMet(Sprite collisionPartner) {
        ((Interactable) collisionPartner).onInteraction(player);
    }
    
}
