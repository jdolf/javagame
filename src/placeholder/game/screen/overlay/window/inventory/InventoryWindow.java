/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.window.inventory;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.List;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.slot.item.ItemSlot;
import placeholder.game.screen.overlay.slot.item.ItemSlotManager;
import placeholder.game.screen.render.Renderer;
import placeholder.game.input.InputHandler;
import placeholder.game.item.Item;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.sprite.entity.player.inventory.Inventory;
import placeholder.game.sprite.entity.player.inventory.InventoryChangedListener;
import placeholder.game.screen.overlay.slot.item.inventory.InventorySlot;
import placeholder.game.screen.overlay.util.ImageDisplay;
import placeholder.game.screen.overlay.window.ImageBackgroundWindow;
import placeholder.game.screen.overlay.window.Window;
import placeholder.game.screen.overlay.window.WindowManager;

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
                new Point(this.getPosition().getX() + INVENTORY_SLOT_INIT_MARGIN.width, this.getPosition().getY() + INVENTORY_SLOT_INIT_MARGIN.height),
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

    @Override
    public void recalculateMeasurements() {
        super.recalculateMeasurements();
        slotManager.getGrid().getPosition().setLocation(
                this.getPosition().getX() + INVENTORY_SLOT_INIT_MARGIN.width,
                this.getPosition().getY() + INVENTORY_SLOT_INIT_MARGIN.height
        );
    }

    
    
    
    
}
