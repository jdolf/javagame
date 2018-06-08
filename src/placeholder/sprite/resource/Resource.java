/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.ResourceAnimation;
import placeholder.sprite.AnimatedSprite;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public abstract class Resource extends AnimatedSprite {
    
    protected boolean depleted = true;
    protected int replenishTime;
    protected int stability;
    protected int requiredLevel;
    protected double currentReplenishTime = 0;
    
    public Resource(
            Image animationImage,
            Point2D location,
            Dimension dimension,
            int replenishTime,
            int stability,
            int requiredLevel) {
        super(new ResourceAnimation(animationImage, dimension), dimension, location);
        this.replenishTime = replenishTime;
        this.stability = stability;
        this.requiredLevel = requiredLevel;
        this.animation.setData(this);
    }

    public void drain(int efficiency) {
        this.stability -= efficiency;
    }

    public void harvest(Inventory inventory) {
        this.depleted = true;
        
        // TODO: add to inventory
    }

    public void replenish() {
        this.depleted = false;
        currentReplenishTime = 0;
    }
    
    public void tickUpdate() {
        currentReplenishTime += 1;

        if (currentReplenishTime >= replenishTime) {
            replenish();
        }
        
        this.animation.update();
    }

    public boolean isDepleted() {
        return this.depleted;
    }
    
}
