/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.resource;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import placeholder.game.item.equipment.weaponequipment.melee.tool.Tool;
import placeholder.game.loot.LootTable;
import placeholder.game.map.Map;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.animation.ResourceAnimation;
import placeholder.game.screen.particle.Particle;
import placeholder.game.screen.particle.StoneParticle;
import placeholder.game.sprite.AnimatedSprite;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public abstract class Resource extends AnimatedSprite {
    
    protected LootTable lootTable = new LootTable();
    protected List<Class<? extends Particle>> particleClasses = new ArrayList();
    protected int minAmountOfParticles = 5;
    protected int maxAmountOfParticles = 10;
    protected int requiredLevel = 1;
    protected boolean depleted = false;
    protected int defaultStability = 0;
    private int brokenness = 0;
    protected int defaultReplenishTime = 0;
    private double replenishTime = 0;
    protected int experience = 0;
    private Random random = new Random();
    
    public Resource(
            Image animationImage,
            Point location,
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
                if (particleClasses.size() > 0) createParticles(player.getMap());
                
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
        lootTable.roll().forEach((item) -> {
            player.getInventory().insertItem(item);
        });
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
    
    private void createParticles(Map map) {
        
        int amountOfParticles = minAmountOfParticles + random.nextInt(maxAmountOfParticles - minAmountOfParticles + 1);
        
        for (int i = 0; i < amountOfParticles; i++) {
            Class<? extends Particle> particleClass = particleClasses.get(random.nextInt(particleClasses.size()));
            
            try {
                map.addParticle(particleClass.getDeclaredConstructor(Point.class, Map.class)
                        .newInstance(new Point(
                                getPosition().getX() + dimension.getWidth() / 2,
                                getPosition().getY() + dimension.getHeight() / 2
                        ), map)
                );
            } catch (Exception ex) {
                Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isDepleted() {
        return this.depleted;
    }
    
}
