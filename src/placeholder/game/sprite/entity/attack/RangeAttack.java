package placeholder.game.sprite.entity.attack;

import placeholder.game.util.Dimension;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class RangeAttack extends Attack {

    public RangeAttack(AttackClient attacker, Dimension hitbox, int ammoStrength, int duration, int invincibilityStun) {
        super(AttackType.RANGE, attacker, hitbox, attacker.getRangeStrength() + ammoStrength, duration, invincibilityStun);
        this.duration = duration;
    }

    @Override
    protected void supplyXp(Player player) {
        super.supplyXp(player);
        player.getSkillManager().getRange().addExperience(damage * 6);
    }

    @Override
    protected int calculateDamageImpl(Hittable hittable) {
        return 1 + this.baseDamage - (hittable.getRangeDefense() / 2);
    }
    
    
    
    
    
    
    
}
