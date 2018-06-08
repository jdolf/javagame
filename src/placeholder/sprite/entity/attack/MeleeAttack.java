package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.input.Direction;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.entity.player.Player;

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
    
    private static Point2D calculateInitPosition(Dimension hitboxDown, AttackClient attacker) {
        double x = attacker.getPosition().getX();
        double y = attacker.getPosition().getY();
        if (null != attacker.getDirection()) switch (attacker.getDirection()) {
            case UP:
                y = attacker.getPosition().getY() - hitboxDown.height + attacker.getDimension().height;
                x = attacker.getPosition().getX() - (hitboxDown.width - attacker.getDimension().width) / 2;
                break;
            case LEFT:
                if (hitboxDown.width > attacker.getDimension().height) {
                    y = attacker.getPosition().getY() - (hitboxDown.height - attacker.getDimension().height) / 2;
                    x = attacker.getPosition().getX() + attacker.getDimension().width - hitboxDown.width;
                } else {
                    x = attacker.getPosition().getX() - hitboxDown.width;
                }
                break;
            case DOWN:
                x = attacker.getPosition().getX() - (hitboxDown.width - attacker.getDimension().width) / 2;
                break;
            case RIGHT:
                if (hitboxDown.width > attacker.getDimension().height) {
                    y = attacker.getPosition().getY() - (hitboxDown.height - attacker.getDimension().height) / 2;
                }
                break;
            default:
                break;
        }
        return new Point2D.Double(x, y);
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

    @Override
    protected void supplyXp(Player player) {
        super.supplyXp(player);
        player.getSkillManager().getMelee().addExperience(damage * 6);
    }

    @Override
    protected int calculateDamageImpl(Hittable hittable) {
        return 3 + this.baseDamage - (hittable.getMeleeDefense() / 4);
    }
    
    
    
    
    
    
    
}
