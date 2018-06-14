package placeholder.item.equipment.weaponequipment.range.projectile;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.input.Direction;
import placeholder.item.equipment.weaponequipment.Hitbox;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.DirectionAnimation;
import placeholder.sprite.entity.attack.AttackClient;
import placeholder.sprite.entity.attack.Projectile;
import placeholder.sprite.entity.attack.RangeAttack;

/**
 *
 * @author jdolf
 */
public class RangeProjectile extends Projectile {
    
    public RangeProjectile(
            AttackClient attacker,
            Dimension dimension,
            Image animationImage,
            int strength,
            int duration,
            int invincibilityStun
    ) {
        super(
                new DirectionAnimation(animationImage, dimension),
                new RangeAttack(attacker, dimension, strength, duration, invincibilityStun),
                dimension,
                attacker.getPosition(),
                attacker,
                strength
        );
    }
    
    
    
}
