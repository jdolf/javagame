package placeholder.item.equipment.weaponequipment.range;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class WoodBow extends RangeWeapon {
    
    public static final String ICON_NAME = "wood_bow_icon.png";
    public static final String ANIMATION_NAME = "wood_bow.png";
    
    public WoodBow(Point2D position) {
        super(position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME));
        this.rangeStrength = 3;
        this.displayName = "Wooden Bow";
        ammoTimeToLive = 40;
    }


}
