package placeholder.game.item.material.ore;

import java.awt.geom.Point2D;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class CoalOre extends Item {
    
    public static final String ICON_NAME = "coal_ore.png";
    
    public CoalOre(Point2D position) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1);
        this.displayName = "Coal Ore";
    }
    
}
