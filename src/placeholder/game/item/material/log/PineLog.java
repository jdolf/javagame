package placeholder.game.item.material.log;

import java.awt.geom.Point2D;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class PineLog extends Item {
    
    public static final String ICON_NAME = "pine_log_icon.png";
    
    public PineLog(Point2D position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
        this.displayName = "Pine Log";
    }
    
}
