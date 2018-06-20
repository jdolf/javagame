package placeholder.game.item.material;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class Log extends Item {
    
    public static final String ICON_NAME = "log_icon.png";
    
    public Log(Point2D position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), 1, amount);
    }
    
}
