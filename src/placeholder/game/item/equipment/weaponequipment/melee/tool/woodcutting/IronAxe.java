package placeholder.game.item.equipment.weaponequipment.melee.tool.woodcutting;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class IronAxe extends WoodcuttingTool {
    
    public static final Dimension HITBOX = new Dimension(22, 22);
    public static final String ICON_NAME = "iron_axe_icon.png";
    public static final String ANIMATION_NAME = "iron_axe.png";
    
    public IronAxe(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX
        );
        this.meleeStrength = 4;
        this.cooldown = 55;
        this.woodcuttingEfficiency = 8;
        this.displayName = "Iron Axe";
    }
    
}
