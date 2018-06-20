package placeholder.game.item.equipment.weaponequipment.melee;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.screen.animation.weapon.MeleeWeaponAnimation;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.collision.CollisionCheck;
import placeholder.game.sprite.entity.attack.Hittable;
import placeholder.game.sprite.entity.attack.MeleeAttack;

/**
 *
 * @author jdolf
 */
public class MeleeWeapon extends WeaponEquipment {
    
    // {{startUp},{duration1, duration2}}
    public static final Integer[][] SWING_LEFT_ARM_COLUMNS = {
        {1}, {2, 3}
    };
    
    /**
     * The hitbox of the weapon while the player is facing down.
     */
    private Dimension hitbox;

    public MeleeWeapon(Point2D position, Image icon, Image animationImage, Dimension hitbox) {
        super(position, icon, animationImage, new MeleeWeaponAnimation());
        this.hitbox = hitbox;
        leftArmAnimationColumns = SWING_LEFT_ARM_COLUMNS;
    }

    @Override
    public void attack() {
        new MeleeAttack(player, hitbox, defaultDuration, invincibilityStun);
    }
    
    public Dimension getHitbox() {
        return this.hitbox;
    }
    
}
