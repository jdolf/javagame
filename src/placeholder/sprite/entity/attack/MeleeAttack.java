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
                hitboxDown,
                attacker.getMeleeStrength(),
                duration,
                invincibilityStun
        );
        attacker.setMeleeAttack(this);
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
