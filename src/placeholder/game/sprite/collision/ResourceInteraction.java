package placeholder.game.sprite.collision;

import java.awt.Dimension;
import java.util.Collection;
import placeholder.game.input.Direction;
import placeholder.game.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.game.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public abstract class ResourceInteraction extends Interaction {
    
    private Player player;
    
    public ResourceInteraction(Player player, Tool tool, Collection<Object> exceptions) {
        super(player, tool.getHitbox(), exceptions);
        this.player = player;
        
        super.tickUpdate();
    }
    
    protected abstract boolean isHarvestable(Sprite collisionPartner);

    @Override
    protected boolean requirementsMet(Sprite collisionPartner) {
        return isHarvestable(collisionPartner);
    }

    @Override
    protected void onRequirementsMet(Sprite collisionPartner) {
        ((Resource) collisionPartner).mine(player);
    }
    
    
    
}
