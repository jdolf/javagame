/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item.inventory;

import java.awt.Dimension;
import placeholder.screen.overlay.contextmenu.ContextMenu;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.contextmenu.StandardContextMenu;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.screen.render.Renderer;
import placeholder.item.Item;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class InventorySlot extends ItemSlot {
    
    private Dimension slotPadding;
    private ContextMenuManager manager;
    private Inventory inventory;

    public InventorySlot(ContextMenuManager manager, Inventory inventory) {
        int paddingX = (this.dimension.width - Item.DEFAULT_DIMENSION.width) / 2;
        int paddingY = (this.dimension.height - Item.DEFAULT_DIMENSION.height) / 2;
        this.slotPadding = new Dimension(paddingX, paddingY);
        this.manager = manager;
        this.inventory = inventory;
    }

    @Override
    public void setItem(Item t) {
        t.setInventory(inventory);
        super.setItem(t);
    }
    
    public ContextMenu createContextMenu() {
        Item item = getItem();
        
        if (item != null) {
            return new StandardContextMenu(manager, getItem().createContextMenuEntries(), this.getPosition());
        } else {
            return null;
        }
    }

    @Override
    public void choose() {
        executeCommand();
    }
    
    
}
