package placeholder.game.item.equipment.shieldequipment;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeShield extends ShieldEquipment {
    
    public static final String ICON_NAME = "bronze_shield_icon.png";
    public static final String ANIMATION_NAME = "bronze_shield.png";
    
    public BronzeShield(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 3;
        this.magicStrength = -2;
        this.magicDefense = -3;
        this.rangeDefense = 4;
        this.displayName = "Bronze Shield";
    }
    
}
