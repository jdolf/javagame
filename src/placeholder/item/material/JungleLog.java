package placeholder.item.material;

import java.awt.geom.Point2D;
import placeholder.item.Item;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class JungleLog extends Item {
    
    public static final String ICON_NAME = "jungle_log_icon.png";
    
    public JungleLog(Point2D position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
    }
    
}
