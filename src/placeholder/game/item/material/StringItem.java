package placeholder.game.item.material;

import placeholder.game.util.Point;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class StringItem extends Item {
    
    public static final String ICON_NAME = "string.png";
    
    public StringItem(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 999, amount);
        this.displayName = "String";
    }
    
}
