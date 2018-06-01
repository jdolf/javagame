package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.Point;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.input.Direction;
import placeholder.item.equipment.weaponequipment.Hitbox;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.DirectionAnimation;

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
