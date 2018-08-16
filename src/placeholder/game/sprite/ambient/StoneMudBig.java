package placeholder.game.sprite.ambient;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.ImageSprite;

/**
 *
 * @author jdolf
 */
public class StoneMudBig extends ImageSprite {
    
    public static final String IMAGE_NAME = "stone_mud_big.png";
    public static final Dimension DIMENSION = new Dimension(1024, 1024);
    
    public StoneMudBig(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        solid = false;
    }
    
}
