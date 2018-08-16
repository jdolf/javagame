/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot.actionbar;

import placeholder.game.screen.overlay.slot.actionbar.ActionBarSlot;
import placeholder.game.util.Dimension;
import javafx.scene.input.KeyCode;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.window.inventory.InventoryWindow;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.input.InputHandler;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class InventoryActionBarSlot extends ActionBarSlot {
    
    public static final String ICON_NAME = "inventory_slot.png";

    public InventoryActionBarSlot(
            InputHandler inputHandler,
            ContextMenuManager contextManager,
            WindowManager windowManager,
            Dimension gameDimension,
            Dimension barDimension,
            Inventory inventory) {
        
        super(
                new InventoryWindow(windowManager, contextManager, inputHandler, gameDimension, barDimension, inventory),
                inputHandler,
                inputHandler.getKey(KeyCode.E),
                ImageContainer.getInstance().getImage(ICON_NAME)
        );
        
    }
    
    
}
