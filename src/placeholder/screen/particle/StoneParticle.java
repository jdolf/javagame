package placeholder.screen.particle;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.map.Map;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class StoneParticle extends Particle {
    
    public static final String IMAGE_NAME = "stone_particle.png";
    public static final Dimension DIMENSION = new Dimension(16, 16);
    
    public StoneParticle(Point2D initLocation, Map map) {
        super(initLocation, DIMENSION, ImageContainer.getInstance().getImage(IMAGE_NAME), map);
    }
    
}
