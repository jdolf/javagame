package placeholder.game.item.equipment.weaponequipment.range;

import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.ProjectileCreator;
import placeholder.game.item.equipment.weaponequipment.range.RangeWeapon;
import placeholder.game.item.equipment.weaponequipment.range.projectile.ThrowingRockProjectile;
import placeholder.game.item.equipment.weaponequipment.range.projectile.WoodArrowProjectile;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.entity.attack.AttackClient;

/**
 *
 * @author jdolf
 */
public class ThrowingRocks extends RangeWeapon implements ProjectileCreator {
    
    public static final String ICON_NAME = "throwing_rocks_icon.png";
    public static final String ANIMATION_NAME = "throwing_rocks.png";
    
    public ThrowingRocks(Point position, int amount) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.rangeStrength = 3;
        this.defaultDuration = 1;
        this.defaultStartUpTime = 5;
        this.cooldown = 20;
        this.setMaxStack(64);
        this.setAmount(amount);
        rightArmAnimationColumns = null;
        this.displayName = "Throwing Rock";
        ammoTimeToLive = 40;
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
        new ThrowingRockProjectile(attackClient, ammoTimeToLive, invincibilityStun);
    }
    
}
