package placeholder.game.screen.overlay.slot.item.crafting;

import java.util.ArrayList;
import java.util.List;
import placeholder.game.crafting.CraftingRecipe;
import placeholder.game.screen.overlay.contextmenu.ContextMenu;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.game.screen.overlay.contextmenu.entry.CraftEntry;
import placeholder.game.screen.overlay.slot.item.ItemSlot;
import placeholder.game.screen.overlay.window.crafting.CraftingWindow;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class CraftingSlot extends ItemSlot {

    private CraftingRecipe recipe;
    private Inventory inventory;
    private CraftingWindow window;
    
    public CraftingSlot(ContextMenuManager manager, CraftingRecipe recipe, Inventory inventory, CraftingWindow window) {
        super(manager);
        this.window = window;
        this.recipe = recipe;
        this.inventory = inventory;
        setItem(recipe.getRecipeTemplate());
    }

    @Override
    protected List createContextMenuEntries() {
        List<ContextMenuEntry> contextMenuEntries = new ArrayList();
        contextMenuEntries.add(new CraftEntry(recipe, inventory));
        
        return contextMenuEntries;
    }

    @Override
    public void select() {
        super.select();
        window.onSelectionChanged(recipe);
    }
    
    
    
    
    
    
    
}
