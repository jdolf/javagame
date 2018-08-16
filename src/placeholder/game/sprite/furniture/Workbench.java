package placeholder.game.sprite.furniture;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.ImageSprite;

/**
 *
 * @author jdolf
 */
public class Workbench extends ImageSprite {
    
    public static final String IMAGE_NAME = "workbench.png";
    public static final Dimension DIMENSION = new Dimension(43, 23);

    public Workbench(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        this.craftingStation = true;
    }
    
}
