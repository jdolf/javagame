package placeholder.game.sprite.entity.npc;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;
import static placeholder.game.sprite.furniture.Anvil.IMAGE_NAME;

/**
 *
 * @author jdolf
 */
public class PabloNPC extends NPC {
    
    public static final Dimension DIMENSION = new Dimension(21, 32);
    public static final String IMAGE_NAME = "pablo.png";
    
    public PabloNPC(Point2D location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
    }
    
}
