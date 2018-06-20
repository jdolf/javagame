package placeholder.game.item.equipment.weaponequipment.range.projectile;

import java.awt.Dimension;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.entity.attack.AttackClient;

/**
 *
 * @author jdolf
 */
public class ThrowingRockProjectile extends RangeProjectile {

    public static final int STRENGTH = 0;
    public static final Dimension DIMENSION = new Dimension(16, 16);
    public static final String ANIMATION_NAME = "throwing_rock.png";

    public ThrowingRockProjectile(AttackClient attacker, int duration, int invincibilityStun) {
        super(
                attacker,
                DIMENSION,
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                STRENGTH,
                duration,
                invincibilityStun
        );
        this.velocity = 3;
    }

}
