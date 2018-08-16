package placeholder.game.item.material.bar;

import placeholder.game.util.Point;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeBar extends Item {
    
    public static final String ICON_NAME = "bronze_bar.png";
    
    public BronzeBar(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
        this.displayName = "Bronze Bar";
    }
    
}
