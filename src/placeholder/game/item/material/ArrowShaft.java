package placeholder.game.item.material;

import java.awt.geom.Point2D;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class ArrowShaft extends Item {
    
    public static final String ICON_NAME = "arrow_shaft.png";
    
    public ArrowShaft(Point2D position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 999, amount);
        this.displayName = "Arrow Shaft";
    }
    
}
