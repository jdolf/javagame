package placeholder.sprite.resource.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.map.Map;
import placeholder.screen.particle.LeafParticle;
import placeholder.screen.particle.Particle;
import placeholder.screen.particle.StoneParticle;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public class WoodcuttingResource extends Resource {
    
    public WoodcuttingResource(Image animationImage, Point2D location, Dimension dimension) {
        super(animationImage, location, dimension);
        this.particleClasses.add(LeafParticle.class);
    }

    @Override
    protected int getPlayerEfficiency(Player player) {
        return player.getWoodcuttingEfficiency();
    }

    @Override
    public void harvest(Player player) {
        super.harvest(player);
        player.getSkillManager().getWoodcutting().addExperience(experience);
    }
    
    
    
    
}
