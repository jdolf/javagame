package placeholder.game.sprite.ambient;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.ImageSprite;

/**
 *
 * @author jdolf
 */
public class Grass extends ImageSprite {
    
    public static final String IMAGE_NAME = "grass.png";
    public static final Dimension DIMENSION = new Dimension(128, 128);
    
    public Grass(Point2D location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        solid = false;
    }
    
}
