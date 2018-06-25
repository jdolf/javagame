package placeholder.game.item.equipment.legsequipment;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class SteelPlatelegs extends LegsEquipment {
    
    public static final String ICON_NAME = "steel_platelegs_icon.png";
    public static final String ANIMATION_NAME = "steel_platelegs.png";
    
    public SteelPlatelegs(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 9;
        this.magicStrength = -2;
        this.magicDefense = -3;
        this.rangeDefense = 11;
        this.displayName = "Steel Platelegs";
    }
    
}
