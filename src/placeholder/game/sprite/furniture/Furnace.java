package placeholder.game.sprite.furniture;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.ImageSprite;

/**
 *
 * @author jdolf
 */
public class Furnace extends ImageSprite {
    
    public static final String IMAGE_NAME = "furnace.png";
    public static final Dimension DIMENSION = new Dimension(48, 48);
    
    public Furnace(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        this.craftingStation = true;
    }
    
}
