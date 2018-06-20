package placeholder.game.crafting;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.ammo.WoodArrow;
import placeholder.game.item.equipment.weaponequipment.range.ThrowingRocks;
import placeholder.game.item.material.Log;
import placeholder.game.item.material.Stone;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.entity.player.inventory.Inventory;
import placeholder.game.sprite.entity.player.inventory.InventoryChangedListener;
import placeholder.game.sprite.furniture.Workbench;

/**
 *
 * @author jdolf
 */
public class CraftingManager implements InventoryChangedListener, PositionChangeListener {
    
    public static final Dimension NEARBY_CRAFTING_STATION_RADIUS = new Dimension(100, 100);
    public static final Collection<CraftingRecipe> RECIPES = Arrays.asList(
            new CraftingRecipe(
                    new ThrowingRocks(null, 20),
                    Arrays.asList(new Stone(null, 1))
            ),
            new CraftingRecipe(
                    new WoodArrow(null, 15),
                    Arrays.asList(new Log(null, 1)),
                    Arrays.asList(new Workbench(null))
            )
    );
    
    private Player player;
    private Collection<CraftableRecipesChangedListener> craftableRecipeListeners = new ArrayList();
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
        craftableRecipes.clear();
        
        RECIPES.forEach((recipe) -> {
            boolean allcraftingStationsAvailable = true;
            
            if (recipe.getCraftingStations() != null) {
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
            }
            
            if (allcraftingStationsAvailable) {
                recipe.getMaterials().forEach((material) -> {
                    if (player.getInventory().hasItem(material.getClass(), material.getAmount())) {
                        craftableRecipes.add(recipe);
                    }
                });
            }
        });
        
        notifyCraftableRecipesChangedListener();
    }

    @Override
    public void onPositionChanged() {
        calculateNearbyCraftingStations();
        calculateCraftableRecipes();
    }
    
    private void calculateNearbyCraftingStations() {
        nearbyCraftingStations.clear();
        player.getMap().getSpriteReceiver().getAt(
                ScreenItem.merge(
                        new Dimension(
                                player.getDimension().width / 2 - NEARBY_CRAFTING_STATION_RADIUS.width / 2,
                                player.getDimension().height / 2 - NEARBY_CRAFTING_STATION_RADIUS.height / 2
                        ), player.getPosition()
                ), NEARBY_CRAFTING_STATION_RADIUS
        ).forEach((sprite) -> {
            if (sprite.isCraftingStation()) {
                nearbyCraftingStations.add(sprite);
            }
        });
    }

    public Collection<CraftingRecipe> getCraftableRecipes() {
        return craftableRecipes;
    }
    
    private void notifyCraftableRecipesChangedListener() {
        craftableRecipeListeners.forEach((recipeListener) -> {
            recipeListener.onCraftableRecipesChanged();
        });
    }
    
    public void addCraftableRecipesChangedListener(CraftableRecipesChangedListener listener) {
        craftableRecipeListeners.add(listener);
    }
    
    
    
}
