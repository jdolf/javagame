package placeholder.item.equipment.weaponequipment;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.screen.overlay.ScreenItem;
import placeholder.sprite.DirectionDependent;

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
