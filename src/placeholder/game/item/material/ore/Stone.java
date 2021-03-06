package placeholder.game.item.material.ore;

import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class Stone extends Item {
    
    public static final String ICON_NAME = "stone_ore.png";
    
    public Stone(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
        this.displayName = "Stone";
    }
    
}
