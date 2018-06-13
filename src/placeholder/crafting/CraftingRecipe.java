package placeholder.crafting;

import java.util.Collection;
import placeholder.item.Item;
import placeholder.sprite.Sprite;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class CraftingRecipe {
    
    private Item recipeTemplate;
    private Collection<Item> materials;
    private Collection<Sprite> craftingStations;
    
    public CraftingRecipe(Item recipeTemplate, Collection<Item> materials) {
        this.recipeTemplate = recipeTemplate;
        this.materials = materials;
    }
    
    public CraftingRecipe(Item recipeTemplate, Collection<Item> materials, Collection<Sprite> craftingStations) {
        this(recipeTemplate, materials);
        this.craftingStations = this.craftingStations;
    }
    
    public void craft(Inventory inventory) {
        if (inventory.insertItem(new Item(recipeTemplate))) {
            materials.forEach((material) -> {
                inventory.removeItemAmount(material.getClass(), material.getAmount());
            });
        }
    }

    public Item getRecipeTemplate() {
        return recipeTemplate;
    }

    public Collection<Item> getMaterials() {
        return materials;
    }

    public Collection<Sprite> getCraftingStations() {
        return craftingStations;
    }
    
    
}
