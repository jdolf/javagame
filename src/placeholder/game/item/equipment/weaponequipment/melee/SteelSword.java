package placeholder.game.item.equipment.weaponequipment.melee;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.EnumMap;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class SteelSword extends MeleeWeapon {
    
    public static final String ICON_NAME = "steel_sword_icon.png";
    public static final String ANIMATION_NAME = "steel_sword.png";
    public static final Dimension HITBOX = new Dimension(35, 35);
    
    public SteelSword(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX
        );
        this.cooldown = 40;
        this.meleeStrength = 12;
        this.speedPercentage = 5;
        this.displayName = "Steel Sword";
    }
    
}
