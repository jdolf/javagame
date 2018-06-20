/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot.item.equipment;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;
import placeholder.game.screen.overlay.slot.item.ItemSlot;
import placeholder.game.item.equipment.Equipment;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.contextmenu.ContextMenu;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.contextmenu.StandardContextMenu;
import placeholder.game.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.game.screen.overlay.contextmenu.entry.UnequipEntry;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 * @param <T>
 */
public abstract class EquipmentSlot<T extends Equipment> extends ItemSlot<T> implements TickUpdatable {
    
    protected Class equipmentClass;
    protected Player player;

    public EquipmentSlot(ContextMenuManager manager, Class equipmentClass, Player player) {
        super(manager);
        this.equipmentClass = equipmentClass;
        this.player = player;
    }

    @Override
    public void setItem(T t) {
        t.attachToPlayer(player);
        super.setItem(t);
        player.getPlayerEquipmentManager().notifyEquipmentChangedListeners();
    }

    @Override
    public T getItem() {
        return super.getItem();
    }

    @Override
    public void removeItem() {
        getItem().disattachFromPlayer(player);
        super.removeItem();
        player.getPlayerEquipmentManager().notifyEquipmentChangedListeners();
    }

    @Override
    public void choose() {
        if (!this.isEmpty()) {
            super.choose();
        }
    }

    @Override
    public void tickUpdate() {
        getItem().tickUpdate();
    }
    
    public Class getRequiredEquipmentClass() {
        return this.equipmentClass;
    }

    @Override
    protected List<ContextMenuEntry> createContextMenuEntries() {
        Equipment item = getItem();
        List<ContextMenuEntry> contextMenuEntries = new ArrayList();
        
        if (item != null) {
            contextMenuEntries.add(new UnequipEntry(player, item));
        }
        
        return contextMenuEntries;
    }
    
    
    
    
    
}
