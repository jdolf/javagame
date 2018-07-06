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
public abstract class ResourceInteraction extends CollisionalPlane {
    
    private boolean success;
    
    public ResourceInteraction(Player player, Tool tool, Collection<Object> exceptions) {
        super(player, tool.getHitbox(), exceptions);
        
        super.tickUpdate();
        
        if (collisionCheck.hasCollisionOccurrence()) {
            collisionCheck.getCollisionPartners().forEach((collisionPartner) -> {
                if (isHarvestable(collisionPartner)) {
                    ((Resource) collisionPartner).mine(player);
                    success = true;
                }
            });
        }
    }
    
    protected abstract boolean isHarvestable(Sprite collisionPartner);

    public boolean hasSuccess() {
        return success;
    }
    
    
    
}
