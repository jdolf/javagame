package placeholder.screen.overlay.window.crafting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import placeholder.crafting.CraftingManager;
import placeholder.input.InputHandler;
import placeholder.screen.overlay.contextmenu.ContextMenu;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.slot.SelectableSlotManager;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.screen.overlay.slot.item.crafting.CraftingSlot;
import placeholder.screen.overlay.window.ImageBackgroundWindow;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class CraftingWindow extends ImageBackgroundWindow {
    
    public static final Dimension SCREEN_DIMENSION = new Dimension(500, 350);
    public static final String BACKGROUND_IMAGE = "window_equipment.png";
    
    private SelectableSlotManager<ItemSlot> slotManager;
    private CraftingManager craftingmanager;
    
    public CraftingWindow(
            WindowManager manager,
            InputHandler input,
            Dimension gameDimension,
            Dimension barDimension,
            CraftingManager craftingManager,
            Inventory inventory,
            ContextMenuManager contextMenuManager) {
        super(manager, input, gameDimension, barDimension, SCREEN_DIMENSION, BACKGROUND_IMAGE);
        this.craftingmanager = craftingManager;
        
        List<ItemSlot> itemSlots = new ArrayList();
        
        craftingManager.getCraftableRecipes().forEach((craftingRecipe) -> {
            itemSlots.add(new CraftingSlot(contextMenuManager, craftingRecipe, inventory));
        });
        slotManager = new SelectableSlotManager<ItemSlot>(
                itemSlots,
                new Point2D.Double(this.getPosition().getX(), this.getPosition().getY()),
                gameDimension
        );
    }
    
}
