package placeholder.game.item.equipment.weaponequipment.range;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class JungleWoodBow extends RangeWeapon {
    
    public static final String ICON_NAME = "jungle_wood_bow_icon.png";
    public static final String ANIMATION_NAME = "jungle_wood_bow.png";
    
    public JungleWoodBow(Point2D position) {
        super(position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME));
        this.rangeStrength = 7;
        this.displayName = "Jungle Wood Bow";
        ammoTimeToLive = 40;
    }


}
