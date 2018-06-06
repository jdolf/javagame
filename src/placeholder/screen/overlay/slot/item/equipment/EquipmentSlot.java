/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item.equipment;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.item.equipment.Equipment;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.contextmenu.ContextMenu;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.contextmenu.StandardContextMenu;
import placeholder.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.screen.overlay.contextmenu.entry.UnequipEntry;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 * @param <T>
 */
public abstract class EquipmentSlot<T extends Equipment> extends ItemSlot<T> implements TickUpdatable {
    
    private ContextMenuManager manager;
    protected Class equipmentClass;
    protected Player player;

    public EquipmentSlot(ContextMenuManager manager, Class equipmentClass, Player player) {
        this.equipmentClass = equipmentClass;
        this.player = player;
        this.manager = manager;
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
    public void choose() {
        if (!this.isEmpty()) executeCommand();
    }

    @Override
    public void tickUpdate() {
        getItem().tickUpdate();
    }
    
    public Class getRequiredEquipmentClass() {
        return this.equipmentClass;
    }

    @Override
    protected ContextMenu createContextMenu() {
        Equipment item = getItem();
        List<ContextMenuEntry> contextMenuEntries = new ArrayList();
        contextMenuEntries.add(new UnequipEntry(player, item));
        
        if (item != null) {
            return new StandardContextMenu(manager, contextMenuEntries, this.getPosition());
        } else {
            return null;
        }
    }
    
    
    
}
