/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot.item.inventory;

import placeholder.game.util.Dimension;
import java.util.List;
import placeholder.game.screen.overlay.contextmenu.ContextMenu;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.contextmenu.StandardContextMenu;
import placeholder.game.screen.overlay.slot.item.ItemSlot;
import placeholder.game.screen.render.Renderer;
import placeholder.game.item.Item;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class InventorySlot extends ItemSlot {
    
    private Dimension slotPadding;
    private Inventory inventory;

    public InventorySlot(ContextMenuManager manager, Inventory inventory) {
        super(manager);
        int paddingX = (this.dimension.width - Item.DEFAULT_DIMENSION.width) / 2;
        int paddingY = (this.dimension.height - Item.DEFAULT_DIMENSION.height) / 2;
        this.slotPadding = new Dimension(paddingX, paddingY);
        this.inventory = inventory;
    }

    @Override
    public void setItem(Item t) {
        t.setInventory(inventory);
        super.setItem(t);
    }

    @Override
    public void choose() {
        executeCommand();
    }

    @Override
    protected List createContextMenuEntries() {
        Item item = getItem();
        
        if (item != null) {
            return item.createContextMenuEntries();
        } else {
            return null;
        }
    }
    
    
    
    
}
