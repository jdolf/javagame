package placeholder.game.sprite.resource.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.game.map.Map;
import placeholder.game.screen.particle.LeafParticle;
import placeholder.game.screen.particle.Particle;
import placeholder.game.screen.particle.StoneParticle;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.resource.Resource;

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
