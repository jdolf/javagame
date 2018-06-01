package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.Point;
import placeholder.input.Direction;
import placeholder.sprite.SpriteReceiver;

/**
 * A close combat attack. Depends on the attack source's stats "MeleeAccuracy",
 * "Melee Strength" and on the target's "MeleeDefense".
 * @author jdolf
 */
public class MeleeAttack extends Attack {
    
    public MeleeAttack(AttackClient attacker, Dimension hitboxDown, int duration, int invincibilityStun) {
        super(AttackType.MELEE,
                attacker,
                calculateInitPosition(hitboxDown, attacker),
                calculateInitHitbox(new Dimension(hitboxDown), attacker.getDirection()),
                attacker.getMeleeStrength(),
                duration,
                invincibilityStun
        );
        attacker.setMeleeAttack(this);
    }
    
    private static Point calculateInitPosition(Dimension hitboxDown, AttackClient attacker) {
        Point newPosition = new Point(attacker.getPosition());
        if (null != attacker.getDirection()) switch (attacker.getDirection()) {
            case UP:
                newPosition.y = attacker.getPosition().y - hitboxDown.height + attacker.getDimension().height;
                newPosition.x = attacker.getPosition().x - (hitboxDown.width - attacker.getDimension().width) / 2;
                break;
            case LEFT:
                if (hitboxDown.width > attacker.getDimension().height) {
                    newPosition.y = attacker.getPosition().y - (hitboxDown.height - attacker.getDimension().height) / 2;
                    newPosition.x = attacker.getPosition().x + attacker.getDimension().width - hitboxDown.width;
                } else {
                    newPosition.x = attacker.getPosition().x - hitboxDown.width;
                }
                break;
            case DOWN:
                newPosition.x = attacker.getPosition().x - (hitboxDown.width - attacker.getDimension().width) / 2;
                break;
            case RIGHT:
                if (hitboxDown.width > attacker.getDimension().height) {
                    newPosition.y = attacker.getPosition().y - (hitboxDown.height - attacker.getDimension().height) / 2;
                }
                break;
            default:
                break;
        }
        return newPosition;
    }
    
    private static Dimension calculateInitHitbox(Dimension hitboxDown, Direction direction) {
        Dimension hitbox = new Dimension(hitboxDown);
        if (null != direction) switch (direction) {
            case LEFT:
                hitbox.width = hitboxDown.height;
                hitbox.height = hitboxDown.width;
                break;
            case RIGHT:
                hitbox.width = hitboxDown.height;
                hitbox.height = hitboxDown.width;
                break;
            default:
                break;
        }
        return hitbox;
    }
    
}
