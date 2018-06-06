package placeholder.item.equipment.weaponequipment.range;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.ammo.Ammo;
import placeholder.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.item.equipment.weaponequipment.melee.MeleeWeapon;
import placeholder.screen.animation.weapon.RangeWeaponAnimation;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class RangeWeapon extends WeaponEquipment {
    
    // {{startUp},{duration1, duration2}}
    public static final Integer[][] BOWPULL_LEFT_ARM_COLUMNS = {
        {4}, {1, 1}
    };
    public static final Integer[][] BOWPULL_RIGHT_ARM_COLUMNS = {
        {1}, {0, 0}
    };

    public RangeWeapon(Point position, Image icon, Image animationImage) {
        super(position, icon, animationImage, new RangeWeaponAnimation());
        leftArmAnimationColumns = BOWPULL_LEFT_ARM_COLUMNS;
        rightArmAnimationColumns = BOWPULL_RIGHT_ARM_COLUMNS;
        this.cooldown = 45;
        this.defaultStartUpTime = 24;
        this.defaultDuration = 1;
    }

    @Override
    public void attack() {
        Inventory inventory = this.player.getInventory();
        if (inventory.hasItemClass(Ammo.class)) {
            Ammo ammo = inventory.getFirstItem(Ammo.class);
            ammo.createProjectile(player, defaultDuration, invincibilityStun);
        }
        
    }
    
}
