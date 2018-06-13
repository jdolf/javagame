/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource.mining;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.entity.player.inventory.Inventory;
import placeholder.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public abstract class MiningResource extends Resource implements Mineable {
    
    public MiningResource(
            Image animationImage,
            Point2D location,
            Dimension dimension) {
        super(animationImage, location, dimension);
    }

    @Override
    public void mine(Player player, MiningTool md) {
        if (player.getSkillManager().getMining().getLevel() >= requiredLevel) {

            if (this.depleted) {
                System.out.println("This mining resource is depleted and can't be mined.");
            } else {
                this.brokenness += player.getMiningEfficiency();
                if (this.brokenness >= this.defaultStability) {
                    harvest(player);
                }
            }

        } else {
            System.out.println("A mining level of at least " + this.requiredLevel + " is required to mine this.");
        }
    }

    @Override
    public void harvest(Player player) {
        super.harvest(player);
        player.getSkillManager().getMining().addExperience(experience);
    }
    
    
    
}
