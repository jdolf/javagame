package placeholder.game.sprite.entity.attack;

import placeholder.game.util.Dimension;
import placeholder.game.sprite.entity.player.Player;

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
        return 1 + this.baseDamage - (hittable.getMagicDefense()/ 2);
    }
    
    
    
}
