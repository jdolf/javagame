package placeholder.item.equipment.weaponequipment.melee.tool.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.sprite.collision.ResourceInteraction;
import placeholder.sprite.collision.WoodcuttingInteraction;

/**
 *
 * @author jdolf
 */
public class WoodcuttingTool extends Tool {
    
    public WoodcuttingTool(Point2D position, Image icon, Image animationImage, Dimension hitbox) {
        super(position, icon, animationImage, hitbox);
    }

    @Override
    protected ResourceInteraction createResourceInteraction() {
        return new WoodcuttingInteraction(player, this, Arrays.asList(player));
    }
    
}
