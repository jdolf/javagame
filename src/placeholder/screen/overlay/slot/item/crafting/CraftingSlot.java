package placeholder.screen.overlay.slot.item.crafting;

import java.util.ArrayList;
import java.util.List;
import placeholder.crafting.CraftingRecipe;
import placeholder.screen.overlay.contextmenu.ContextMenu;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.screen.overlay.contextmenu.entry.CraftEntry;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class CraftingSlot extends ItemSlot {

    private CraftingRecipe recipe;
    private Inventory inventory;
    
    public CraftingSlot(ContextMenuManager manager, CraftingRecipe recipe, Inventory inventory) {
        super(manager);
        this.recipe = recipe;
        this.inventory = inventory;
        setItem(recipe.getRecipeTemplate());
    }

    @Override
    protected List createContextMenuEntries() {
        System.out.println("creating");
        List<ContextMenuEntry> contextMenuEntries = new ArrayList();
        contextMenuEntries.add(new CraftEntry(recipe, inventory));
        
        return contextMenuEntries;
    }
    
    
    
}
