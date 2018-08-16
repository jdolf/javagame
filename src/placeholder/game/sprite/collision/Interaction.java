package placeholder.game.sprite.collision;

import placeholder.game.util.Dimension;
import java.util.Collection;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class Interaction extends CollisionalPlane {
    
    private boolean success;
    
    public Interaction(Player player, Dimension hitboxDown, Collection<Object> exceptions) {
        super(player, hitboxDown, exceptions);
        
        super.tickUpdate();
        
        if (collisionCheck.hasCollisionOccurrence()) {
            collisionCheck.getCollisionPartners().forEach((collisionPartner) -> {
                if (requirementsMet(collisionPartner)) {
                    onRequirementsMet(collisionPartner);
                    success = true;
                }
            });
        }
    }
    
    protected abstract boolean requirementsMet(Sprite collisionPartner);
    
    protected abstract void onRequirementsMet(Sprite collisionPartner);

    public boolean hasSuccess() {
        return success;
    }
    
}
