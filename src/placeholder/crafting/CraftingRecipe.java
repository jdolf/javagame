package placeholder.crafting;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        this.craftingStations = craftingStations;
    }
    
    public void craft(Inventory inventory) {
        boolean inserted = false;
        
        try {
            inserted = inventory.insertItem(
                    recipeTemplate.getClass()
                    .getDeclaredConstructor(Point2D.class, int.class)
                    .newInstance(null, recipeTemplate.getAmount()));

        } catch (Exception ex) {
            Logger.getLogger(CraftingRecipe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (inserted == false) {
            try {
                inserted = inventory.insertItem(
                        recipeTemplate.getClass()
                        .getDeclaredConstructor(Point2D.class)
                        .newInstance(null));

            } catch (Exception ex) {
                Logger.getLogger(CraftingRecipe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (inserted) {
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
