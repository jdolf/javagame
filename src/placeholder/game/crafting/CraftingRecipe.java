package placeholder.game.crafting;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import placeholder.game.item.Item;
import placeholder.game.skill.Skill;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class CraftingRecipe {
    
    private Item recipeTemplate;
    private Collection<Item> materials;
    private Collection<Sprite> craftingStations;
    private Map<Class<? extends Skill>, Integer> skillRequirements;
    private Map<Class<? extends Skill>, Integer> experienceRewards;
    
    private CraftingRecipe(CraftingRecipeBuilder builder) {
        this.recipeTemplate = builder.recipeTemplate;
        this.materials = builder.materials;
        this.craftingStations = builder.craftingStations;
        this.skillRequirements = builder.skillRequirements;
        this.experienceRewards = builder.experienceRewards;
    }
    
    public void craft(Player player) {
        boolean inserted = false;
        
        try {
            inserted = player.getInventory().insertItem(
                    recipeTemplate.getClass()
                    .getDeclaredConstructor(Point2D.class, int.class)
                    .newInstance(null, recipeTemplate.getAmount()));

        } catch (Exception ex) {}
        
        if (inserted == false) {
            try {
                inserted = player.getInventory().insertItem(
                        recipeTemplate.getClass()
                        .getDeclaredConstructor(Point2D.class)
                        .newInstance((Object)null));

            } catch (Exception ex) {}
        }
        
        if (inserted) {
            materials.forEach((material) -> {
                player.getInventory().removeItemAmount(material.getClass(), material.getAmount());
            });
        }
        
        experienceRewards.entrySet().forEach((set) -> {
            for (Skill skill : player.getSkillManager().getSkills()) {
                if (skill.getClass() == set.getKey()) {
                    skill.addExperience(set.getValue());
                    break;
                }
            }
        });
        
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

    public Map<Class<? extends Skill>, Integer> getSkillRequirements() {
        return skillRequirements;
    }
    
    public static class CraftingRecipeBuilder {
        
        private Item recipeTemplate;
        private Collection<Item> materials;
        private Collection<Sprite> craftingStations;
        private Map<Class<? extends Skill>, Integer> skillRequirements = new HashMap<>();
        private Map<Class<? extends Skill>, Integer> experienceRewards = new HashMap<>();
        
        public CraftingRecipeBuilder(Item recipeTemplate, Collection<Item> materials) {
            this.recipeTemplate = recipeTemplate;
            this.materials = materials;
        }
        
        public CraftingRecipeBuilder withCraftingStations(Collection<Sprite> craftingStations) {
            this.craftingStations = craftingStations;
            return this;
        }
        
        public CraftingRecipeBuilder addSkillRequirement(Class<? extends Skill> targetClass, int levelRequirement) {
            this.skillRequirements.put(targetClass, levelRequirement);
            return this;
        }
        
        public CraftingRecipeBuilder addExperienceReward(Class<? extends Skill> targetClass, int reward) {
            this.experienceRewards.put(targetClass, reward);
            return this;
        }
        
        public CraftingRecipe build() {
            return new CraftingRecipe(this);
        }
        
    }
    
    
}
