package placeholder.game.item.equipment.shieldequipment;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class SteelShield extends ShieldEquipment {
    
    public static final String ICON_NAME = "steel_shield_icon.png";
    public static final String ANIMATION_NAME = "steel_shield.png";
    
    public SteelShield(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 8;
        this.magicStrength = -2;
        this.magicDefense = -3;
        this.rangeDefense = 10;
        this.displayName = "Steel Shield";
    }
    
}
