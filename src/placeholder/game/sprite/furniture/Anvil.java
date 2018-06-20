package placeholder.game.sprite.furniture;

import java.awt.Dimension;
import java.awt.geom.Point2D;
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
    
    public Anvil(Point2D location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        this.craftingStation = true;
    }
    
}
