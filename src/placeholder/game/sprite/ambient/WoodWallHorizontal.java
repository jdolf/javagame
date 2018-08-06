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
public class WoodWallHorizontal extends ImageSprite {
    
    public static final String IMAGE_NAME = "wood_wall_horizontal.png";
    public static final Dimension DIMENSION = new Dimension(128, 64);
    
    public WoodWallHorizontal(Point2D location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
    }
    
}
