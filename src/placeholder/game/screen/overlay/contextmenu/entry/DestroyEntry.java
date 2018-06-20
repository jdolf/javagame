/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.contextmenu.entry;

import placeholder.game.item.Item;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class DestroyEntry extends ContextMenuEntry {

    public static final String DISPLAY_NAME = "Destroy";
    private Item item;
    private Inventory inventory;
    
    public DestroyEntry(Inventory inventory, Item item) {
        super(DISPLAY_NAME);
        this.item = item;
        this.inventory = inventory;
    }
    
    @Override
    public void execute() {
        inventory.removeItem(item);
    }
    
}
