package placeholder.game.item.material;

import placeholder.game.util.Point;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class ArrowShaft extends Item {
    
    public static final String ICON_NAME = "arrow_shaft.png";
    
    public ArrowShaft(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 999, amount);
        this.displayName = "Arrow Shaft";
    }
    
}
