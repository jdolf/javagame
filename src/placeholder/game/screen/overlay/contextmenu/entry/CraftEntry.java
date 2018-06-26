package placeholder.game.screen.overlay.contextmenu.entry;

import placeholder.game.crafting.CraftingManager;
import placeholder.game.crafting.CraftingRecipe;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class CraftEntry extends ContextMenuEntry {
    
    public static final String DISPLAY_NAME = "Craft";
    
    private CraftingRecipe craftingRecipe;
    private Player player;

    public CraftEntry(CraftingRecipe craftingRecipe, Player player) {
        super(DISPLAY_NAME);
        this.craftingRecipe = craftingRecipe;
        this.player = player;
    }

    @Override
    public void execute() {
        craftingRecipe.craft(player);
    }
    
}
