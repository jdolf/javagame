package placeholder.sprite.entity.attack;

import java.awt.Dimension;

/**
 *
 * @author jdolf
 */
public class RangeAttack extends Attack {

    public RangeAttack(AttackClient attacker, Dimension hitbox, int ammoStrength, int duration, int invincibilityStun) {
        super(AttackType.RANGE, attacker, hitbox, attacker.getRangeStrength() + ammoStrength, duration, invincibilityStun);
        this.duration = 100;
    }
    
    
    
}
