package placeholder.crafting;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import placeholder.screen.overlay.PositionChangeListener;
import placeholder.sprite.Sprite;
import placeholder.sprite.entity.player.Player;
import placeholder.sprite.entity.player.inventory.Inventory;
import placeholder.sprite.entity.player.inventory.InventoryChangedListener;

/**
 *
 * @author jdolf
 */
public class CraftingManager implements InventoryChangedListener, PositionChangeListener {
    
    private Player player;
    
    public static final Dimension NEARBY_CRAFTING_STATION_RADIUS = new Dimension(100, 100);
    public static final Collection<CraftingRecipe> RECIPES = Arrays.asList(
            
    );
    
    protected Collection<CraftingRecipe> craftableRecipes = new ArrayList();
    protected Collection<Sprite> nearbyCraftingStations = new ArrayList();
    
    public CraftingManager(Player player) {
        this.player = player;
        player.getInventory().registerListener(this);
        player.addPositionChangeListener(this);
        
        calculateNearbyCraftingStations();
        calculateCraftableRecipes();
    }

    @Override
    public void onInventoryChanged() {
        calculateCraftableRecipes();
    }
    
    /**
     * Computes which crafting recipes are craftable from the passed inventory.
     */
    private void calculateCraftableRecipes() {
        RECIPES.forEach((recipe) -> {
            boolean allcraftingStationsAvailable = true;
            
            for (Sprite craftingStation : recipe.getCraftingStations()) {
                boolean craftingStationAvailable = false;
                
                for (Sprite nearbyCraftingStation : nearbyCraftingStations) {
                    if (craftingStation.getClass().equals(nearbyCraftingStation.getClass())) {
                        craftingStationAvailable = true;
                    }
                }

                if (!craftingStationAvailable) {
                    allcraftingStationsAvailable = false;
                    break;
                }
            }
            
            if (allcraftingStationsAvailable) {
                recipe.getMaterials().forEach((material) -> {
                    if (player.getInventory().hasItem(material.getClass(), material.getAmount())) {
                        craftableRecipes.add(recipe);
                    }
                });
            }
        });
    }

    @Override
    public void onPositionChanged() {
        calculateNearbyCraftingStations();
    }
    
    private void calculateNearbyCraftingStations() {
        player.getMap().getSpriteReceiver().getSpritesAt(player.getPosition(), NEARBY_CRAFTING_STATION_RADIUS).forEach((sprite) -> {
            if (sprite.isCraftingStation()) {
                nearbyCraftingStations.add(sprite);
            }
        });
    }

    public Collection<CraftingRecipe> getCraftableRecipes() {
        return craftableRecipes;
    }
    
    
    
}
