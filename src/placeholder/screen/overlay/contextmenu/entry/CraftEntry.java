package placeholder.screen.overlay.contextmenu.entry;

import placeholder.crafting.CraftingManager;
import placeholder.crafting.CraftingRecipe;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class CraftEntry extends ContextMenuEntry {
    
    public static final String DISPLAY_NAME = "Craft";
    
    private CraftingRecipe craftingRecipe;
    private Inventory inventory;

    public CraftEntry(CraftingRecipe craftingRecipe, Inventory inventory) {
        super(DISPLAY_NAME);
        this.craftingRecipe = craftingRecipe;
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        craftingRecipe.craft(inventory);
    }
    
}
