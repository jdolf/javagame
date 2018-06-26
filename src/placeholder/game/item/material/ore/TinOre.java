package placeholder.game.item.material.ore;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class TinOre extends Item {
    
    public static final String ICON_NAME = "tin_ore.png";
    
    public TinOre(Point2D position) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1);
        this.displayName = "Tin Ore";
    }
    
}
