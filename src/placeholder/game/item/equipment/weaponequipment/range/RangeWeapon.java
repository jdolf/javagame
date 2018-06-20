package placeholder.game.item.equipment.weaponequipment.range;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.ammo.Ammo;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.item.equipment.weaponequipment.melee.MeleeWeapon;
import placeholder.game.screen.animation.weapon.RangeWeaponAnimation;
import placeholder.game.sprite.entity.player.inventory.Inventory;

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
    
    protected int ammoTimeToLive = 1;

    public RangeWeapon(Point2D position, Image icon, Image animationImage) {
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
            if (ammo != null) {
                ammo.createProjectile(player, ammoTimeToLive, invincibilityStun);
            }
        }
        
    }
    
}
