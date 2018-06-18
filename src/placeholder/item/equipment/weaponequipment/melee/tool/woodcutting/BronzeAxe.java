package placeholder.item.equipment.weaponequipment.melee.tool.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class BronzeAxe extends WoodcuttingTool {
    
    public static final Dimension HITBOX = new Dimension(20, 20);
    public static final String ICON_NAME = "bronze_axe_icon.png";
    public static final String ANIMATION_NAME = "bronze_axe.png";
    
    public BronzeAxe(Point2D position) {
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
