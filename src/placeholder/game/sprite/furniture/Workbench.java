package placeholder.game.sprite.furniture;

import java.awt.Dimension;
import java.awt.geom.Point2D;
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

    public Workbench(Point2D location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
        this.craftingStation = true;
    }
    
}
