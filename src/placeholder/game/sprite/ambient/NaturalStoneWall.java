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
public class NaturalStoneWall extends ImageSprite {
    
    public static final String IMAGE_NAME = "natural_stone_wall.png";
    public static final Dimension DIMENSION = new Dimension(512, 128);
    
    public NaturalStoneWall(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
    }
    
}
