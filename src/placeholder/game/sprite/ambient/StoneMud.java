package placeholder.game.sprite.ambient;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.ImageSprite;

/**
 *
 * @author jdolf
 */
public class StoneMud extends ImageSprite {
    
    public static final String IMAGE_NAME = "stone_mud.png";
    public static final Dimension DIMENSION = new Dimension(32, 32);
    
    public StoneMud(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        solid = false;
    }
    
}
