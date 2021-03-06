/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.List;
import java.util.Map;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.game.screen.overlay.contextmenu.entry.EquipEntry;
import placeholder.game.screen.render.Renderer;
import placeholder.game.item.Item;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.animation.EquipmentAnimation;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.bodypart.BodyPart;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class Equipment extends Item implements TickUpdatable {
    
    public static final int MAX_STACK = 1;

    protected Player player;
    protected EquipmentAnimation animation;
    /**
     * The speed percentage bonus. Ratio: 1 = 1%
     */
    protected int speedPercentage = 0;
    protected int cooldownPercentage = 0;
    protected int meleeDefense = 0;
    protected int rangeDefense = 0;
    protected int magicDefense = 0;
    protected int meleeStrength = 0;
    protected int rangeStrength = 0;
    protected int magicStrength = 0;
    protected int miningEfficiency = 0;
    protected int woodcuttingEfficiency = 0;
    
    public Equipment(Point position, Image icon, Image animationImage, EquipmentAnimation animation) {
        super(position, icon, MAX_STACK);
        animation.setEquipment(this);
        animation.setImage(animationImage);
        animation.setDimension(calculateDimension());
        this.animation = animation;
    }

    public boolean isMadeFor(Class bodyPart) {
        if (this.getBodyPartClass().equals(bodyPart)) {
            return true;
        } else {
            return false;
        }
    }

    public void render(Renderer renderer, BodyPart bodyPart) {
        renderer.renderAnimation(animation, new ScreenItem(
                new Point(
                    player.getPosition().getX() + bodyPart.getOffsetCoordinates().getX(),
                    player.getPosition().getY() + bodyPart.getOffsetCoordinates().getY()
                ),
                new Dimension(
                    bodyPart.getDimension().width,
                    bodyPart.getDimension().height
                )
        ));
    }

    @Override
    public void tickUpdate() {
        this.animation.update();
    }

    public void attachToPlayer(Player player) {
        this.player = player;
        this.animation.setData(player);
    }
    
    public void disattachFromPlayer(Player player) {
        this.player = null;
    }

    @Override
    public List<ContextMenuEntry> createContextMenuEntries() {
        List<ContextMenuEntry> entries = super.createContextMenuEntries();
        entries.add(new EquipEntry(this.inventory.getPlayer(), this));
        return entries;
    }

    protected abstract Class getBodyPartClass();

    protected abstract Dimension calculateDimension();
    
    protected abstract Class getRequiredEquipmentClass();

    public int getMeleeDefense() {
        return meleeDefense;
    }

    public int getRangeDefense() {
        return rangeDefense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public int getMeleeStrength() {
        return meleeStrength;
    }

    public int getRangeStrength() {
        return rangeStrength;
    }

    public int getMagicStrength() {
        return magicStrength;
    }
    
    public int getSpeedPercentage() {
        return speedPercentage;
    }
    
    public int getCooldownPercentage() {
        return cooldownPercentage;
    }

    public int getMiningEfficiency() {
        return miningEfficiency;
    }

    public int getWoodcuttingEfficiency() {
        return woodcuttingEfficiency;
    }
    

}
