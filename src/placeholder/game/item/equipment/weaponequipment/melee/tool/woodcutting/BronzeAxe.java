package placeholder.game.item.equipment.weaponequipment.melee.tool.woodcutting;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeAxe extends WoodcuttingTool {
    
    public static final Dimension HITBOX = new Dimension(20, 20);
    public static final String ICON_NAME = "bronze_axe_icon.png";
    public static final String ANIMATION_NAME = "bronze_axe.png";
    
    public BronzeAxe(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                HITBOX
        );
        this.meleeStrength = 2;
        this.cooldown = 60;
        this.woodcuttingEfficiency = 5;
        this.displayName = "Bronze Axe";
    }
    
}
