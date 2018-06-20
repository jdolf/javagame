package placeholder.game.sprite.collision;

import java.util.Collection;
import placeholder.game.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.resource.woodcutting.WoodcuttingResource;

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
