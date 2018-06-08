/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item.equipment;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.animation.Animation;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.screen.overlay.contextmenu.entry.EquipEntry;
import placeholder.screen.render.Renderer;
import placeholder.item.Item;
import placeholder.screen.TickUpdatable;
import placeholder.screen.animation.EquipmentAnimation;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.bodypart.BodyPart;
import placeholder.sprite.entity.player.Player;

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
    protected int meleeDefense = 0;
    protected int rangeDefense = 0;
    protected int magicDefense = 0;
    protected int meleeStrength = 0;
    protected int rangeStrength = 0;
    protected int magicStrength = 0;
    
    public Equipment(Point2D position, Image icon, Image animationImage, EquipmentAnimation animation) {
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
                new Point2D.Double(
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

    

}
