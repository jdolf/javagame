package placeholder.game.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import placeholder.game.input.Direction;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.entity.player.Player;

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
    }

    @Override
    protected void supplyXp(Player player) {
        super.supplyXp(player);
        player.getSkillManager().getMelee().addExperience(damage * 6);
    }

    @Override
    protected int calculateDamageImpl(Hittable hittable) {
        return 1 + this.baseDamage - (hittable.getMeleeDefense() / 2);
    }

    @Override
    public void attack() {
        super.attack();
        calculateScreenItem(attacker, hitboxDown, Arrays.asList(attacker));
    }
    
    
    
    
    
    
    
    
    
}
