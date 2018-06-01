package placeholder.screen.animation.weapon;

import java.awt.Dimension;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.screen.animation.EquipmentAnimation;
import placeholder.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class WeaponAnimation extends EquipmentAnimation<WeaponEquipment> {
    
    public WeaponAnimation() {}
    
    public WeaponAnimation(Entity Entity, Image image, Dimension dimension, WeaponEquipment weapon) {
        super(Entity, image, dimension, weapon);
    }
    
}
