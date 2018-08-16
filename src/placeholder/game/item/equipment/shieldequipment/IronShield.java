package placeholder.game.item.equipment.shieldequipment;

import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class IronShield extends ShieldEquipment {
    
    public static final String ICON_NAME = "iron_shield_icon.png";
    public static final String ANIMATION_NAME = "iron_shield.png";
    
    public IronShield(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 5;
        this.magicStrength = -2;
        this.magicDefense = -3;
        this.rangeDefense = 7;
        this.displayName = "Iron Shield";
    }
    
}
