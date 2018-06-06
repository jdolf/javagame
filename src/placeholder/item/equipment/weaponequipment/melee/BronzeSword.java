package placeholder.item.equipment.weaponequipment.melee;

import java.awt.Dimension;
import java.awt.Point;
import java.util.EnumMap;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeSword extends MeleeWeapon {
    
    public static final String ICON_NAME = "bronze_sword_icon.png";
    public static final String ANIMATION_NAME = "bronze_sword.png";
    public static final Dimension HITBOX = new Dimension(50, 50);
    
    public BronzeSword(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX
        );
        this.cooldown = 50;
        this.meleeStrength = 6;
    }
    
}