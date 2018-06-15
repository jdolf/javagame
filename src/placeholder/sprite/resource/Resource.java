/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.ResourceAnimation;
import placeholder.sprite.AnimatedSprite;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public abstract class Resource extends AnimatedSprite {
    
    protected int requiredLevel = 1;
    protected boolean depleted = false;
    protected int defaultStability = 0;
    protected int brokenness = 0;
    protected int defaultReplenishTime = 0;
    protected double replenishTime = 0;
    protected int experience = 0;
    
    public Resource(
            Image animationImage,
            Point2D location,
            Dimension dimension) {
        super(new ResourceAnimation(animationImage, dimension), dimension, location);
        this.animation.setData(this);
    }
    
    public void mine(Player player) {
        if (player.getSkillManager().getMining().getLevel() >= requiredLevel) {

            if (this.depleted) {
                System.out.println("This resource is depleted and can't be harvested.");
            } else {
                this.brokenness += getPlayerEfficiency(player);
                if (this.brokenness >= this.defaultStability) {
                    harvest(player);
                }
            }

        } else {
            System.out.println("A level of at least " + this.requiredLevel + " is required to harvest this.");
        }
    }
    
    protected abstract int getPlayerEfficiency(Player player);

    public void drain(int efficiency) {
        this.brokenness -= efficiency;
    }

    public void harvest(Player player) {
        this.depleted = true;
        // TODO: add to inventory from loottable; maybe in subclass?
    }

    public void replenish() {
        this.depleted = false;
        replenishTime = 0;
        brokenness = 0;
    }
    
    public void tickUpdate() {
        if (depleted) {
            replenishTime += 1;
            if (replenishTime >= defaultReplenishTime) {
                replenish();
            }
        }
        
        this.animation.update();
    }

    public boolean isDepleted() {
        return this.depleted;
    }
    
}
