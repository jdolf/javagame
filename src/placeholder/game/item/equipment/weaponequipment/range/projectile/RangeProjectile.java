package placeholder.game.item.equipment.weaponequipment.range.projectile;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.game.input.Direction;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.animation.DirectionAnimation;
import placeholder.game.sprite.entity.attack.AttackClient;
import placeholder.game.sprite.entity.attack.Projectile;
import placeholder.game.sprite.entity.attack.RangeAttack;

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
