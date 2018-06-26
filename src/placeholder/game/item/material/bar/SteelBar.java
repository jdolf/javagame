package placeholder.game.item.material.bar;

import java.awt.geom.Point2D;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class SteelBar extends Item {
    
    public static final String ICON_NAME = "steel_bar.png";
    
    public SteelBar(Point2D position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
        this.displayName = "Steel Bar";
    }
    
}
