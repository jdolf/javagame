package placeholder.game.item.material.log;

import placeholder.game.util.Point;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class WillowLog extends Item {
    
    public static final String ICON_NAME = "willow_log_icon.png";
    
    public WillowLog(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
        this.displayName = "Willow Log";
    }
    
}
