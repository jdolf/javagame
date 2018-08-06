package placeholder.game.sprite.entity.npc;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.game.screen.animation.EntityAnimation;
import placeholder.game.sprite.entity.AnimatedEntity;

/**
 *
 * @author jdolf
 */
public abstract class NPC extends AnimatedEntity {
    
    protected String name = "Unknown";
    
    public NPC(EntityAnimation animation, Dimension dimension, Point2D location) {
        super(animation, dimension, location);
    }
    
    
    
}
