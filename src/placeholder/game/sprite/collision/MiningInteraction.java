package placeholder.game.sprite.collision;

import java.util.Collection;
import placeholder.game.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.resource.mining.MiningResource;

/**
 *
 * @author jdolf
 */
public class MiningInteraction extends ResourceInteraction {

    public MiningInteraction(Player player, Tool tool, Collection<Object> exceptions) {
        super(player, tool, exceptions);
    }

    @Override
    protected boolean isHarvestable(Sprite collisionPartner) {
        return collisionPartner instanceof MiningResource;
    }
    
}
