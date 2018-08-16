package placeholder.game.screen.animation;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class RightArmAnimation extends DirectionAnimation<Player> {

    public RightArmAnimation(Player player, Image image, Dimension dimension) {
        super(player, player, image, dimension);
    }

    @Override
    public int calculateColumn() {
        if (this.data.getAttackManager().isAttacking()) {
            if (this.data.getAttackManager().getUsedWeapon() != null) {
                WeaponEquipment usedWeapon = this.data.getAttackManager().getUsedWeapon();
                if (usedWeapon.getRightArmAnimationColumns() != null) {
                    if (usedWeapon.getStartUpTime() > 0) {
                        return usedWeapon.getRightArmAnimationColumns()[0][0];
                    } else if (usedWeapon.getDuration() > usedWeapon.getDefaultDuration() / 2) {
                        return usedWeapon.getRightArmAnimationColumns()[1][0];
                    } else if (usedWeapon.getDuration() > 0) {
                        return usedWeapon.getRightArmAnimationColumns()[1][1];
                    }
                }
            }
        }
        return 0;
    }
    
    
    
    
    
}
