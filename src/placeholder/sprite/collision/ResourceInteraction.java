package placeholder.sprite.collision;

import java.awt.Dimension;
import java.util.Collection;
import placeholder.input.Direction;
import placeholder.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.screen.overlay.ScreenItem;
import placeholder.sprite.Sprite;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public abstract class ResourceInteraction extends CollisionalPlane {
    
    private boolean success;
    
    public ResourceInteraction(Player player, Tool tool, Collection<Object> exceptions) {
        super(player, tool.getHitbox(), exceptions, player.getMap());
        
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
