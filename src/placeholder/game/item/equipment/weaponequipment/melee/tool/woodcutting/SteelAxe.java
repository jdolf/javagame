package placeholder.game.item.equipment.weaponequipment.melee.tool.woodcutting;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class SteelAxe extends WoodcuttingTool {
    
    public static final Dimension HITBOX = new Dimension(24, 24);
    public static final String ICON_NAME = "steel_axe_icon.png";
    public static final String ANIMATION_NAME = "steel_axe.png";
    
    public SteelAxe(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX
        );
        this.meleeStrength = 6;
        this.cooldown = 53;
        this.woodcuttingEfficiency = 11;
        this.displayName = "Steel Axe";
    }
    
}
