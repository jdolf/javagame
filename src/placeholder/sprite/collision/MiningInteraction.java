package placeholder.sprite.collision;

import java.awt.Dimension;
import java.util.Collection;
import placeholder.input.Direction;
import placeholder.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.screen.overlay.ScreenItem;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.resource.mining.Mineable;

/**
 *
 * @author jdolf
 */
public class MiningInteraction extends CollisionalPlane {
    
    private Player player;
    private MiningTool miningTool;
    private boolean success;
    
    public MiningInteraction(Player player, MiningTool miningTool, Collection<Object> exceptions) {
        super(player, miningTool.getHitbox(), exceptions, player.getMap());
        this.player = player;
        this.miningTool = miningTool;
        
        super.tickUpdate();
        
        if (collisionCheck.hasCollisionOccurrence()) {
            collisionCheck.getCollisionPartners().forEach((collisionPartner) -> {
                if (collisionPartner instanceof Mineable) {
                    ((Mineable) collisionPartner).mine(player, miningTool);
                    success = true;
                }
            });
        }
    }

    public boolean hasSuccess() {
        return success;
    }
    
    
    
}
