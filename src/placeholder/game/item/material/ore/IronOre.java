package placeholder.game.item.material.ore;

import placeholder.game.util.Point;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class IronOre extends Item {
    
    public static final String ICON_NAME = "iron_ore.png";
    
    public IronOre(Point position) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1);
        this.displayName = "Iron Ore";
    }
    
}
