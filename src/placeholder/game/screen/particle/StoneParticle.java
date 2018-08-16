package placeholder.game.screen.particle;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.map.Map;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class StoneParticle extends Particle {
    
    public static final String IMAGE_NAME = "stone_particle.png";
    public static final Dimension DIMENSION = new Dimension(16, 16);
    
    public StoneParticle(Point initLocation, Map map) {
        super(initLocation, DIMENSION, ImageContainer.getInstance().getImage(IMAGE_NAME), map);
    }
    
}
