package placeholder.sprite.furniture;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;
import placeholder.sprite.ImageSprite;

/**
 *
 * @author jdolf
 */
public class Furnace extends ImageSprite {
    
    public static final String IMAGE_NAME = "furnace.png";
    public static final Dimension DIMENSION = new Dimension(48, 48);
    
    public Furnace(Point2D location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        this.craftingStation = true;
    }
    
}
