package placeholder.game.item.equipment.weaponequipment.melee;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.EnumMap;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeSword extends MeleeWeapon {
    
    public static final String ICON_NAME = "bronze_sword_icon.png";
    public static final String ANIMATION_NAME = "bronze_sword.png";
    public static final Dimension HITBOX = new Dimension(30, 30);
    
    public BronzeSword(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX
        );
        this.cooldown = 50;
        this.meleeStrength = 6;
        this.speedPercentage = 5;
        this.displayName = "Bronze Sword";
    }
    
}
