/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.resource.mining;

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
import placeholder.game.sprite.entity.player.inventory.Inventory;
import placeholder.game.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public abstract class MiningResource extends Resource {
    
    public MiningResource(
            Image animationImage,
            Point2D location,
            Dimension dimension) {
        super(animationImage, location, dimension);
        this.particleClasses.add(StoneParticle.class);
    }

    @Override
    protected int getPlayerEfficiency(Player player) {
        return player.getMiningEfficiency();
    }

    @Override
    public void harvest(Player player) {
        super.harvest(player);
        player.getSkillManager().getMining().addExperience(experience);
    }
    
    
    
    
    
}
