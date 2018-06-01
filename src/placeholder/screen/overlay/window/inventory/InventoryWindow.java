/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.window.inventory;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.screen.overlay.slot.item.ItemSlotManager;
import placeholder.screen.render.Renderer;
import placeholder.input.InputHandler;
import placeholder.item.Item;
import placeholder.screen.ImageContainer;
import placeholder.sprite.entity.player.inventory.Inventory;
import placeholder.sprite.entity.player.inventory.InventoryChangedListener;
import placeholder.screen.overlay.slot.item.inventory.InventorySlot;
import placeholder.screen.overlay.util.ImageDisplay;
import placeholder.screen.overlay.window.ImageBackgroundWindow;
import placeholder.screen.overlay.window.Window;
import placeholder.screen.overlay.window.WindowManager;

/**
 *
 * @author jdolf
 */
public class InventoryWindow extends ImageBackgroundWindow {
    
    public static final Dimension SCREEN_DIMENSION = new Dimension(500, 350);
    public static final String BACKGROUND_IMAGE = "window_inventory.png";
    
    public static final Dimension INVENTORY_SLOT_INIT_MARGIN = new Dimension(0, 100);
    
    private ItemSlotManager slotManager;
    private ContextMenuManager contextManager;
    private Inventory inventory;
    
    public InventoryWindow(WindowManager manager, ContextMenuManager contextManager, InputHandler input, Dimension gameDimension, Dimension barDimension, Inventory inventory) {
        super(manager, input, gameDimension, barDimension, SCREEN_DIMENSION, BACKGROUND_IMAGE);
        this.inventory = inventory;
        this.contextManager = contextManager;
        slotManager = new ItemSlotManager(
                inventory.getSlots(),
                new Point(this.getPosition().x + INVENTORY_SLOT_INIT_MARGIN.width, this.getPosition().y + INVENTORY_SLOT_INIT_MARGIN.height),
                this.dimension,
                input
        );
    }

    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        slotManager.render(renderer);
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        if (contextManager.hasOpenedContextMenu() == false) {
            slotManager.tickUpdate();
        }
    }

    @Override
    public void close() {
        super.close();
        contextManager.unregisterContextMenu();
    }

    @Override
    public void open() {
        super.open();
    }
    
    
    
}
