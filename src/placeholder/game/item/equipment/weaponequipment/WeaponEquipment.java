/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.weaponequipment;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.input.Direction;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.screen.animation.weapon.WeaponAnimation;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.overlay.slot.item.equipment.WeaponEquipmentSlot;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.bodypart.BodyPart;
import placeholder.game.sprite.entity.bodypart.LeftArmBodyPart;

/**
 *
 * @author jdolf
 */
public abstract class WeaponEquipment extends Equipment {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(32, 32);
    public static final Map<Direction, Dimension> WEAPON_OFFSETS = new HashMap();
    
    static {
        WEAPON_OFFSETS.put(Direction.DOWN, new Dimension(-DEFAULT_DIMENSION.width / 2 + 5, -DEFAULT_DIMENSION.height / 2 + 5));
        WEAPON_OFFSETS.put(Direction.UP, new Dimension(-2, -DEFAULT_DIMENSION.height / 2 + 5));
        WEAPON_OFFSETS.put(Direction.LEFT, new Dimension(-10, -DEFAULT_DIMENSION.height / 2 + 5));
        WEAPON_OFFSETS.put(Direction.RIGHT, new Dimension(0, -DEFAULT_DIMENSION.height / 2 + 5));
    }
    
    private boolean used;
    protected int cooldown = 60;
    protected int invincibilityStun = 15;
    protected int defaultStartUpTime = 30;
    protected int defaultDuration = 15;
    private int startUpTime;
    private int duration;
    protected Integer[][] leftArmAnimationColumns;
    protected Integer[][] rightArmAnimationColumns;

    public WeaponEquipment(
            Point position,
            Image icon,
            Image animationImage,
            WeaponAnimation weaponAnimation) {
        super(position, icon, animationImage, weaponAnimation);
        
    }
    
    public void attackInit() {
        used = true;
        startUpTime = defaultStartUpTime;
        duration = defaultDuration;
    }
    
    protected abstract void attack();

    @Override
    public void render(Renderer renderer, BodyPart bodyPart) {
        Dimension offset = WEAPON_OFFSETS.get(player.getDirection());
        renderer.renderAnimation(animation, new ScreenItem(
                new Point(
                    player.getPosition().getX() + bodyPart.getOffsetCoordinates().getX() + offset.width,
                    player.getPosition().getY() + bodyPart.getOffsetCoordinates().getY() + offset.height
                ),
                new Dimension(
                    DEFAULT_DIMENSION.width,
                    DEFAULT_DIMENSION.height
                )
        ));
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        if (used) {
            if (startUpTime == 0 && duration == defaultDuration) {
                attack();
            }
            
            if (startUpTime == 0 && duration > 0) duration -= 1;
            if (startUpTime > 0) startUpTime -= 1;
            
            if (startUpTime == 0 && duration == 0) {
                used = false;
            }
        }
    }
    
    @Override
    protected Dimension calculateDimension() {
        return DEFAULT_DIMENSION;
    }

    @Override
    protected Class getBodyPartClass() {
        return LeftArmBodyPart.class;
    }

    @Override
    protected Class getRequiredEquipmentClass() {
        return WeaponEquipment.class;
    }

    public int getAttackSpeed() {
        return cooldown;
    }

    public int getStartUpTime() {
        return startUpTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getInvincibilityStun() {
        return invincibilityStun;
    }

    public int getDefaultStartUpTime() {
        return defaultStartUpTime;
    }

    public int getDefaultDuration() {
        return defaultDuration;
    }

    public Integer[][] getLeftArmAnimationColumns() {
        return leftArmAnimationColumns;
    }

    public Integer[][] getRightArmAnimationColumns() {
        return rightArmAnimationColumns;
    }
    
    /**
     * Tests if this is a throwing weapon and removes this from the equipment if theres no ammo left.
     */
    @Override
    protected void onAmountChanged() {
        super.onAmountChanged();
        if (player != null) {
            if (this.isStackable()) {
                if (this.getAmount() <= 0) {
                    WeaponEquipmentSlot target = player.getPlayerEquipmentManager().getWeaponEquipmentSlot();
                    
                    if (!target.isEmpty()) {
                        player.getPlayerEquipmentManager().getWeaponEquipmentSlot().removeItem();
                    }
                }
            }
        }
    }
    
    
    
}
