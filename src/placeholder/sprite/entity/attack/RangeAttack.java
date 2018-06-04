package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class RangeAttack extends Attack {

    public RangeAttack(AttackClient attacker, Dimension hitbox, int ammoStrength, int duration, int invincibilityStun) {
        super(AttackType.RANGE, attacker, hitbox, attacker.getRangeStrength() + ammoStrength, duration, invincibilityStun);
        this.duration = 100;
    }

    @Override
    protected void supplyXp(Player player) {
        super.supplyXp(player);
        player.getSkillManager().getRange().addExperience(damage * 6);
    }

    @Override
    protected int calculateDamageImpl(Hittable hittable) {
        return this.baseDamage - (hittable.getRangeDefense() / 4);
    }
    
    
    
    
    
    
    
}
