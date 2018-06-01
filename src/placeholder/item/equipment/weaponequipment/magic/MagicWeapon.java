package placeholder.item.equipment.weaponequipment.magic;

import java.awt.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.screen.animation.weapon.MagicWeaponAnimation;

/**
 *
 * @author jdolf
 */
public class MagicWeapon extends WeaponEquipment {

    public MagicWeapon(Point position, Image icon, Image animationImage) {
        super(position, icon, animationImage, new MagicWeaponAnimation());
    }

    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
