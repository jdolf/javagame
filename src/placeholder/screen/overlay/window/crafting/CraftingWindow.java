package placeholder.screen.overlay.window.crafting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import placeholder.crafting.CraftableRecipesChangedListener;
import placeholder.crafting.CraftingManager;
import placeholder.crafting.CraftingRecipe;
import placeholder.input.InputHandler;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.contextmenu.ContextMenu;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.slot.SelectableSlotManager;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.screen.overlay.slot.item.crafting.CraftingSlot;
import placeholder.screen.overlay.window.ImageBackgroundWindow;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.render.Renderer;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.entity.player.inventory.Inventory;
import placeholder.util.SelectionChangedListener;

/**
 *
 * @author jdolf
 */
public class CraftingWindow extends ImageBackgroundWindow implements CraftableRecipesChangedListener {
    
    public static final Dimension SLOTS_INIT_MARGIN = new Dimension(0, 100);
    public static final Dimension SCREEN_DIMENSION = new Dimension(500, 350);
    public static final String BACKGROUND_IMAGE = "window_crafting.png";
    
    private RecipeDisplay recipeDisplay;
    private SelectableSlotManager<CraftingSlot> slotManager;
    private CraftingManager craftingmanager;
    private ContextMenuManager contextMenuManager;
    private Player player;
    private Dimension gameDimension;
    
    public CraftingWindow(
            WindowManager manager,
            InputHandler input,
            Dimension gameDimension,
            Dimension barDimension,
            Player player,
            ContextMenuManager contextMenuManager) {
        super(manager, input, gameDimension, barDimension, SCREEN_DIMENSION, BACKGROUND_IMAGE);
        this.player = player;
        this.gameDimension = gameDimension;
        this.craftingmanager = player.getCraftingManager();
        this.contextMenuManager = contextMenuManager;
        recipeDisplay = new RecipeDisplay(ScreenItem.merge(new Dimension(this.dimension.width - 175, 115), this.getPosition()), new Dimension(150, 200));
        
        createSlotManager();
        player.getCraftingManager().addCraftableRecipesChangedListener(this);
    }

    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        if (slotManager != null) {
            slotManager.render(renderer);
        }
        recipeDisplay.render(renderer);
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        if (slotManager != null && contextMenuManager.hasOpenedContextMenu() == false) {
            slotManager.tickUpdate();
        }
    }

    @Override
    public void onCraftableRecipesChanged() {
        createSlotManager();
    }
    
    private void createSlotManager() {
        List<CraftingSlot> itemSlots = createSlots();
        
        if (itemSlots.size() > 0) {
            if (slotManager != null) {
                slotManager.updateGrid(itemSlots);
            } else {
                slotManager = new SelectableSlotManager<CraftingSlot>(
                    createSlots(),
                    new Point2D.Double(this.getPosition().getX() + SLOTS_INIT_MARGIN.width, this.getPosition().getY() + SLOTS_INIT_MARGIN.height),
                    this.dimension
                );
                slotManager.setInputHandler(input);
            }
        } else {
            slotManager = null;
            onSelectionChanged(null);
        }
    }
    
    private List<CraftingSlot> createSlots() {
        List<CraftingSlot> itemSlots = new ArrayList();
        
        this.craftingmanager.getCraftableRecipes().forEach((craftingRecipe) -> {
            itemSlots.add(new CraftingSlot(contextMenuManager, craftingRecipe, player.getInventory(), this));
        });
        
        return itemSlots;
    }
    
    @Override
    public void close() {
        super.close();
        contextMenuManager.unregisterContextMenu();
    }

    public void onSelectionChanged(CraftingRecipe recipe) {
        recipeDisplay.setTemplate(recipe);
    }
    
    
}
