package placeholder.game.item.equipment.weaponequipment.range;

import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class PineWoodBow extends RangeWeapon {
    
    public static final String ICON_NAME = "pine_wood_bow_icon.png";
    public static final String ANIMATION_NAME = "pine_wood_bow.png";
    
    public PineWoodBow(Point position) {
        super(position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME));
        this.rangeStrength = 19;
        this.displayName = "Pine Wood Bow";
        ammoTimeToLive = 45;
        cooldown = 37;
    }


}
