package placeholder.game.item.equipment.weaponequipment.melee.tool.woodcutting;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.Arrays;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.game.sprite.collision.ResourceInteraction;
import placeholder.game.sprite.collision.WoodcuttingInteraction;

/**
 *
 * @author jdolf
 */
public class WoodcuttingTool extends Tool {
    
    public WoodcuttingTool(Point position, Image icon, Image animationImage, Dimension hitbox) {
        super(position, icon, animationImage, hitbox);
    }

    @Override
    protected ResourceInteraction createResourceInteraction() {
        return new WoodcuttingInteraction(player, this, Arrays.asList(player));
    }
    
}
