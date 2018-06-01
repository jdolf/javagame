package placeholder.sprite.entity.attack;

import java.awt.Dimension;

/**
 *
 * @author jdolf
 */
public class MagicAttack extends Attack {

    public MagicAttack(AttackClient attacker, Dimension hitbox, int spellStrength, int duration, int invincibilityStun) {
        super(AttackType.MAGIC, attacker, hitbox, attacker.getMagicStrength() + spellStrength, duration, invincibilityStun);
    }
    
}
