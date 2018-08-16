package placeholder.game.item.equipment.legsequipment;

import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzePlatelegs extends LegsEquipment {
    
    public static final String ICON_NAME = "bronze_platelegs_icon.png";
    public static final String ANIMATION_NAME = "bronze_platelegs.png";
    
    public BronzePlatelegs(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 3;
        this.magicStrength = -2;
        this.magicDefense = -3;
        this.rangeDefense = 4;
        this.displayName = "Bronze Platelegs";
    }
    
}
