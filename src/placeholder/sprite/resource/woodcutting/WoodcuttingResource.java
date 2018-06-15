package placeholder.sprite.resource.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public class WoodcuttingResource extends Resource {
    
    public WoodcuttingResource(Image animationImage, Point2D location, Dimension dimension) {
        super(animationImage, location, dimension);
    }

    @Override
    protected int getPlayerEfficiency(Player player) {
        return player.getWoodcuttingEfficiency();
    }
    
    
    
}
