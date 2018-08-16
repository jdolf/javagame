package placeholder.game.item.equipment.weaponequipment;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.DirectionDependent;

/**
 *
 * @author jdolf
 */
public class Hitbox {
    
    private Dimension dimension;
    private DirectionDependent directionDependent;
    
    public Hitbox(Dimension dimension, DirectionDependent directionDependent) {
        this.dimension = dimension;
        this.directionDependent = directionDependent;
    }
    
    public Dimension getDimension() {
        return this.dimension;
    }
}
