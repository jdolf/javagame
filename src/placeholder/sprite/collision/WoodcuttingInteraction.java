package placeholder.sprite.collision;

import java.util.Collection;
import placeholder.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.sprite.Sprite;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.resource.woodcutting.WoodcuttingResource;

/**
 *
 * @author jdolf
 */
public class WoodcuttingInteraction extends ResourceInteraction {

    public WoodcuttingInteraction(Player player, Tool tool, Collection<Object> exceptions) {
        super(player, tool, exceptions);
    }

    @Override
    protected boolean isHarvestable(Sprite collisionPartner) {
        return collisionPartner instanceof WoodcuttingResource;
    }
    
}
