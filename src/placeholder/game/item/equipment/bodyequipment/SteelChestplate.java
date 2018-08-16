package placeholder.game.item.equipment.bodyequipment;

import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.animation.EquipmentAnimation;

/**
 *
 * @author jdolf
 */
public class SteelChestplate extends BodyEquipment {
    
    public static final String ICON_NAME = "steel_chestplate_icon.png";
    public static final String ANIMATION_NAME = "steel_chestplate.png";
    
    public SteelChestplate(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 12;
        this.magicStrength = -3;
        this.magicDefense = -5;
        this.rangeDefense = 14;
        this.displayName = "Steel Chestplate";
    }
    
}
