package placeholder.game.sprite.collision;

import java.util.Collection;
import placeholder.game.sprite.Sprite;

/**
 *
 * @author jdolf
 */
public class CollisionCheck {
    
    private boolean collisionOccurrence = false;
    private Collection<Sprite> collisionPartners;
    
    public CollisionCheck(Collection<Sprite> collisionPartners) {
        this.collisionPartners = collisionPartners;
        
        if (collisionPartners != null && !collisionPartners.isEmpty()) {
            collisionOccurrence = true;
        }
    }

    public boolean hasCollisionOccurrence() {
        return collisionOccurrence;
    }

    public Collection<Sprite> getCollisionPartners() {
        return collisionPartners;
    }
    
    
}
