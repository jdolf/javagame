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
public class Anvil extends ImageSprite {
    
    public static final String IMAGE_NAME = "anvil.png";
    public static final Dimension DIMENSION = new Dimension(34, 18);
    
    public Anvil(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        this.craftingStation = true;
    }
    
}
