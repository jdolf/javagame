package placeholder.game.item.material;

import placeholder.game.util.Point;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeArrowTips extends Item {
    
    public static final String ICON_NAME = "bronze_arrow_tips.png";
    
    public BronzeArrowTips(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 999, amount);
        this.displayName = "Bronze Arrow Tips";
    }
    
}
