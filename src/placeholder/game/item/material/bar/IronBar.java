package placeholder.game.item.material.bar;

import placeholder.game.util.Point;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class IronBar extends Item {
    
    public static final String ICON_NAME = "iron_bar.png";
    
    public IronBar(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
        this.displayName = "Iron Bar";
    }
    
}
