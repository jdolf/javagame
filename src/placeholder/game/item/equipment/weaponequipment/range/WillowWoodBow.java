package placeholder.game.item.equipment.weaponequipment.range;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class WillowWoodBow extends RangeWeapon {
    
    public static final String ICON_NAME = "willow_wood_bow_icon.png";
    public static final String ANIMATION_NAME = "willow_wood_bow.png";
    
    public WillowWoodBow(Point2D position) {
        super(position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME));
        this.rangeStrength = 13;
        this.displayName = "Willow Wood Bow";
        ammoTimeToLive = 45;
        cooldown = 40;
    }


}
