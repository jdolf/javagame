package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class MagicAttack extends Attack {

    public MagicAttack(AttackClient attacker, Dimension hitbox, int spellStrength, int duration, int invincibilityStun) {
        super(AttackType.MAGIC, attacker, hitbox, attacker.getMagicStrength() + spellStrength, duration, invincibilityStun);
    }

    @Override
    protected void supplyXp(Player player) {
        super.supplyXp(player);
        player.getSkillManager().getRange().addExperience(damage * 6);
    }

    @Override
    protected int calculateDamageImpl(Hittable hittable) {
        return this.baseDamage - (hittable.getMagicDefense()/ 4);
    }
    
    
    
}
