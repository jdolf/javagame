package placeholder.game.item.equipment.bodyequipment;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.animation.EquipmentAnimation;

/**
 *
 * @author jdolf
 */
public class BronzeChestplate extends BodyEquipment {
    
    public static final String ICON_NAME = "bronze_chestplate_icon.png";
    public static final String ANIMATION_NAME = "bronze_chestplate.png";
    
    public BronzeChestplate(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 4;
        this.magicStrength = -2;
        this.magicDefense = -4;
        this.rangeDefense = 6;
        this.displayName = "Bronze Chestplate";
    }
    
}
