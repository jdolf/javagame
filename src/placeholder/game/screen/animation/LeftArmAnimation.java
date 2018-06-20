package placeholder.game.screen.animation;

import java.awt.Dimension;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.sprite.entity.attack.MeleeAttack;
import placeholder.game.sprite.entity.attack.manager.PlayerAttackManager;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class LeftArmAnimation extends DirectionAnimation<Player> {
    
    public LeftArmAnimation(Player player, Image image, Dimension dimension) {
        super(player, player, image, dimension);
    }

    @Override
    public int calculateColumn() {
        if (this.data.getAttackManager().isInitAttack()) {
            return 1;
        } else if (this.data.getAttackManager().isAttacking()) {
            if (this.data.getAttackManager().getUsedWeapon() != null) {
                WeaponEquipment usedWeapon = this.data.getAttackManager().getUsedWeapon();
                
                if (usedWeapon.getLeftArmAnimationColumns() != null) {
                
                    if (usedWeapon.getStartUpTime() > 0) {
                        return usedWeapon.getLeftArmAnimationColumns()[0][0];
                    } else if (usedWeapon.getDuration() > usedWeapon.getDefaultDuration() / 2) {
                        return usedWeapon.getLeftArmAnimationColumns()[1][0];
                    } else if (usedWeapon.getDuration() > 0) {
                        return usedWeapon.getLeftArmAnimationColumns()[1][1];
                    }
                    
                }
            } else if (this.data.getAttackManager().getMeleeAttack() != null) {
                // If boxing
                MeleeAttack meleeAttack = this.data.getAttackManager().getMeleeAttack();
                if (meleeAttack.getDuration() > PlayerAttackManager.DEFAULT_ATTACK_DURATION / 2) {
                    return 2;
                } else if (meleeAttack.getDuration() > 0) {
                    return 3;
                }
            }
        }
        return 0;
    }
}
