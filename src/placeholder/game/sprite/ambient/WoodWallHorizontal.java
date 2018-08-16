package placeholder.game.sprite.ambient;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.ImageSprite;

/**
 *
 * @author jdolf
 */
public class WoodWallHorizontal extends ImageSprite {
    
    public static final String IMAGE_NAME = "wood_wall_horizontal.png";
    public static final Dimension DIMENSION = new Dimension(128, 64);
    
    public WoodWallHorizontal(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
    }
    
}
