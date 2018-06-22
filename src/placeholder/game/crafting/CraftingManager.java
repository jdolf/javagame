package placeholder.game.crafting;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.Item;
import placeholder.game.item.ammo.WoodArrow;
import placeholder.game.item.equipment.headequipment.BronzeHelmet;
import placeholder.game.item.equipment.weaponequipment.range.ThrowingRocks;
import placeholder.game.item.material.BronzeBar;
import placeholder.game.item.material.CoalOre;
import placeholder.game.item.material.CopperOre;
import placeholder.game.item.material.IronBar;
import placeholder.game.item.material.IronOre;
import placeholder.game.item.material.Log;
import placeholder.game.item.material.SteelBar;
import placeholder.game.item.material.Stone;
import placeholder.game.item.material.TinOre;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.entity.player.inventory.InventoryChangedListener;
import placeholder.game.sprite.furniture.Furnace;
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
            ),
            new CraftingRecipe(
                    new BronzeBar(null, 1),
                    Arrays.asList(
                            new TinOre(null),
                            new CopperOre(null)
                    ),
                    Arrays.asList(new Furnace(null))
            ),
            new CraftingRecipe(
                    new IronBar(null, 1),
                    Arrays.asList(
                            new IronOre(null)
                    ),
                    Arrays.asList(new Furnace(null))
            ),
            new CraftingRecipe(
                    new SteelBar(null, 1),
                    Arrays.asList(
                            new IronOre(null),
                            new CoalOre(null)
                    ),
                    Arrays.asList(new Furnace(null))
            ),
            new CraftingRecipe(
                    new BronzeHelmet(null),
                    Arrays.asList(
                            new BronzeBar(null, 3)
                    ),
                    Arrays.asList(new Furnace(null))
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
                boolean hasMaterials = true;
                
                for (Item material : recipe.getMaterials()) {
                    if (!player.getInventory().hasItem(material.getClass(), material.getAmount())) {
                        hasMaterials = false;
                    } 
                }
                
                if (hasMaterials) {
                    craftableRecipes.add(recipe);
                }
            }
        });
        
        System.out.println(craftableRecipes.size());
        
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
