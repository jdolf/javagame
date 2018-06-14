package placeholder.item.equipment.weaponequipment.range;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.ProjectileCreator;
import placeholder.item.equipment.weaponequipment.range.RangeWeapon;
import placeholder.item.equipment.weaponequipment.range.projectile.ThrowingRockProjectile;
import placeholder.item.equipment.weaponequipment.range.projectile.WoodArrowProjectile;
import placeholder.screen.ImageContainer;
import placeholder.sprite.entity.attack.AttackClient;

/**
 *
 * @author jdolf
 */
public class ThrowingRocks extends RangeWeapon implements ProjectileCreator {
    
    public static final String ICON_NAME = "throwing_rocks_icon.png";
    public static final String ANIMATION_NAME = "throwing_rocks.png";
    
    public ThrowingRocks(Point2D position, int amount) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.defaultDuration = 1;
        this.defaultStartUpTime = 5;
        this.cooldown = 20;
        this.setMaxStack(64);
        this.setAmount(amount);
        rightArmAnimationColumns = null;
    }

    @Override
    public void attack() {
        if (this.getAmount() > 0) {
            createProjectile(player, defaultDuration, invincibilityStun);
            this.removeAmount(1);
        }
    }

    @Override
    public void createProjectile(AttackClient attackClient, int duration, int invincibilityStun) {
        new ThrowingRockProjectile(attackClient, 40, invincibilityStun);
    }
    
    
    
}
