package placeholder.game.item.material;

import java.awt.geom.Point2D;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeArrowTips extends Item {
    
    public static final String ICON_NAME = "bronze_arrow_tips.png";
    
    public BronzeArrowTips(Point2D position) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1);
        this.displayName = "Bronze Arrow Tips";
    }
    
}