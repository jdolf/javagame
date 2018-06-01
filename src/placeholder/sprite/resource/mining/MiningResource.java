/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource.mining;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.melee.tool.mining.MiningTool;
import placeholder.sprite.entity.player.inventory.Inventory;
import placeholder.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public abstract class MiningResource extends Resource implements Mineable {
    
    public MiningResource(
            Image animationImage,
            Point location,
            Dimension dimension,
            int replenishTime,
            int stability,
            int requiredLevel) {
        super(animationImage, location, dimension, replenishTime, stability, requiredLevel);
    }

    @Override
    public void mine(int playerLevel, MiningTool md, Inventory inventory) {
        if (playerLevel >= requiredLevel) {

            if (this.depleted) {
                // TODO: Send message, depleted rock
            } else {
                md.mine(playerLevel, this, inventory);

                if (this.stability <= 0) {
                    harvest(inventory);
                }
            }

        } else {
            // TODO: Send message, level not high enough
        }
    }
    
}
