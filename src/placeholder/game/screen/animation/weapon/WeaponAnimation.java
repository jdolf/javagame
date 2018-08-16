package placeholder.game.screen.animation.weapon;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.screen.animation.EquipmentAnimation;
import placeholder.game.sprite.entity.Entity;

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
