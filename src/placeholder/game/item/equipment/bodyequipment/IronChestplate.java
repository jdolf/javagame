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
public class IronChestplate extends BodyEquipment {
    
    public static final String ICON_NAME = "iron_chestplate_icon.png";
    public static final String ANIMATION_NAME = "iron_chestplate.png";
    
    public IronChestplate(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 8;
        this.magicStrength = -3;
        this.magicDefense = -5;
        this.rangeDefense = 9;
        this.displayName = "Iron Chestplate";
    }
    
}
