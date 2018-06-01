package placeholder.screen.animation.weapon;

/**
 *
 * @author jdolf
 */
public class RangeWeaponAnimation extends WeaponAnimation {

    @Override
    public int calculateColumn() {
        if (this.equipment.getStartUpTime() > 0) {
            return 1;
        }
        return 0;
    }
    
}
