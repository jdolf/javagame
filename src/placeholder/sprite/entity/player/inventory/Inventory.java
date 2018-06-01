/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.entity.player.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.item.Item;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.screen.overlay.slot.item.inventory.InventorySlot;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class Inventory implements InventoryChangedSubject {
    
    public static final int DEFAULT_SLOTS = 21;
    protected List<InventorySlot> slots = new ArrayList();
    protected List<InventoryChangedListener> registeredListener = new ArrayList();
    protected Player player;
    
    public Inventory(ContextMenuManager manager, Player player) {
        this.player = player;
        for (int i = 0; i < DEFAULT_SLOTS; i ++) {
            slots.add(new InventorySlot(manager, this));
        }
    }
    
    public boolean hasItemClass(Class itemClass) {
        boolean success = false;
        
        for (InventorySlot slot : slots) {
            if (!slots.isEmpty()) {
                success = itemClass.isAssignableFrom(slot.getItem().getClass());
                
                if (success) break;
            }
        }
        
        return success;
    }
    
    public <T extends Item> List<T> getItems(Class<T> itemClass) {
        List<T> items = new ArrayList();
        
        for (InventorySlot slot : slots) {
            if (!slots.isEmpty()) {
                if (itemClass.isAssignableFrom(slot.getItem().getClass())) {
                    T item = itemClass.cast(slot.getItem());
                    items.add(item);
                }
            }
        }
        
        return items;
    }
    
    public <T extends Item> T getFirstItem(Class<T> itemClass) {
        
        for (InventorySlot slot : slots) {
            if (!slots.isEmpty()) {
                if (itemClass.isAssignableFrom(slot.getItem().getClass())) {
                    return itemClass.cast(slot.getItem());
                }
            }
        }
        
        return null;
    }

    public void insertItem(Item itemToInsert) {
        // If item is stackable
        if (itemToInsert.isStackable()) {
            // Go through each inventory slot and try to stack
            for (ItemSlot slot : slots) {
                Item testItem = slot.getItem();
                // If inventory slot matches the item to be added
                if (testItem != null && testItem.getClass().equals(itemToInsert.getClass())) {
                    // If inventory slot item contains space
                    if (testItem.calculateSpace() > 0) {
                        // Fill
                        testItem.fillAmount(itemToInsert);
                        if (testItem.getAmount() == 0) break;
                    }
                }
            }
        }
        
        // If items to insert (still) remain
        if (itemToInsert.getAmount() > 0) {
            // Go through each inventory slot and use empty slots instead
            for (InventorySlot slot : slots) {
                if (slot.isEmpty()) {
                    slot.setItem(itemToInsert);
                    break;
                }
            }
        }
        
        notifyListeners();
    }

    public void clear() {
        for (ItemSlot slot : slots) {
            slot.removeItem();
        }
        
        notifyListeners();
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList();
        
        for (InventorySlot slot : slots) {
            items.add(slot.getItem());
        }
        return items;
    }

    public void removeItem(Item itemToDestroy) {
        for (InventorySlot slot : slots) {
            if (!slot.isEmpty()) {
                if (slot.getItem().equals(itemToDestroy)) {
                    slot.removeItem();
                }
            }
        }
        
        notifyListeners();
    }

    @Override
    public void registerListener(InventoryChangedListener listener) {
        this.registeredListener.add(listener);
    }

    @Override
    public void notifyListeners() {
        if (registeredListener.isEmpty() == false)
            for (InventoryChangedListener listener : registeredListener) {
                listener.onInventoryChanged();
            }
    }

    @Override
    public void unregisterListener(InventoryChangedListener listener) {
        registeredListener.remove(listener);
    }

    public Player getPlayer() {
        return this.player;
    }
    
    public boolean isFull() {
        boolean full = true;
        for (InventorySlot slot : slots) {
            if (slot.isEmpty()) {
                full = false;
                break;
            }
        }
        return full;
    }
    
    public List<InventorySlot> getSlots() {
        return this.slots;
    }
    
}
