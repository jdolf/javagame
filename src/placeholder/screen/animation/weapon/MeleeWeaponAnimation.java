package placeholder.screen.animation.weapon;

/**
 *
 * @author jdolf
 */
public class MeleeWeaponAnimation extends WeaponAnimation {
    
    @Override
    public int calculateColumn() {
        if (this.equipment.getStartUpTime() > 0) {
            return 1;
        } else if (this.equipment.getDuration() > this.equipment.getDefaultDuration() / 2) {
            return 2;
        } else if (this.equipment.getDuration() > 0) {
            return 3;
        }
        return 0;
    }
    
}
