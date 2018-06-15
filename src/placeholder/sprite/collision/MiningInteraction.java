package placeholder.sprite.collision;

import java.util.Collection;
import placeholder.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.sprite.Sprite;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.resource.mining.MiningResource;

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
