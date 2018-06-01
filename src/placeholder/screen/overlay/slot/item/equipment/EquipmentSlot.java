/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item.equipment;

import java.awt.Dimension;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.item.equipment.Equipment;
import placeholder.screen.TickUpdatable;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 * @param <T>
 */
public abstract class EquipmentSlot<T extends Equipment> extends ItemSlot<T> implements TickUpdatable {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(32, 32);
    
    protected Class equipmentClass;
    protected Player player;

    public EquipmentSlot(Class equipmentClass, Player player) {
        super(DEFAULT_DIMENSION);
        this.equipmentClass = equipmentClass;
        this.player = player;
    }

    @Override
    public void setItem(T t) {
        t.attachToPlayer(player);
        super.setItem(t);
    }

    @Override
    public T getItem() {
        return super.getItem();
    }

    @Override
    public void removeItem() {
        getItem().disattachFromPlayer(player);
        super.removeItem();
    }

    @Override
    public void executeCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void choose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tickUpdate() {
        getItem().tickUpdate();
    }
    
    public Class getRequiredEquipmentClass() {
        return this.equipmentClass;
    }
    
    
    
}
