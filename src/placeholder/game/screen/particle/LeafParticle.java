package placeholder.game.screen.particle;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.map.Map;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class LeafParticle extends Particle {
    
    public static final String IMAGE_NAME = "leaf_particle.png";
    public static final Dimension DIMENSION = new Dimension(16, 16);
    
    public LeafParticle(Point2D initLocation, Map map) {
        super(initLocation, DIMENSION, ImageContainer.getInstance().getImage(IMAGE_NAME), map);
    }
    
}
