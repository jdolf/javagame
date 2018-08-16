package placeholder.game.crafting;

import placeholder.game.util.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import placeholder.game.crafting.CraftingRecipe.CraftingRecipeBuilder;
import placeholder.game.item.Item;
import placeholder.game.item.ammo.BronzeArrow;
import placeholder.game.item.ammo.IronArrow;
import placeholder.game.item.ammo.SteelArrow;
import placeholder.game.item.ammo.WoodArrow;
import placeholder.game.item.equipment.bodyequipment.BronzeChestplate;
import placeholder.game.item.equipment.bodyequipment.IronChestplate;
import placeholder.game.item.equipment.bodyequipment.SteelChestplate;
import placeholder.game.item.equipment.headequipment.BronzeHelmet;
import placeholder.game.item.equipment.headequipment.IronHelmet;
import placeholder.game.item.equipment.headequipment.SteelHelmet;
import placeholder.game.item.equipment.legsequipment.BronzePlatelegs;
import placeholder.game.item.equipment.legsequipment.IronPlatelegs;
import placeholder.game.item.equipment.legsequipment.SteelPlatelegs;
import placeholder.game.item.equipment.shieldequipment.BronzeShield;
import placeholder.game.item.equipment.shieldequipment.IronShield;
import placeholder.game.item.equipment.weaponequipment.melee.BronzeSword;
import placeholder.game.item.equipment.weaponequipment.melee.IronSword;
import placeholder.game.item.equipment.weaponequipment.melee.SteelSword;
import placeholder.game.item.equipment.weaponequipment.melee.tool.mining.BronzePickaxe;
import placeholder.game.item.equipment.weaponequipment.melee.tool.mining.IronPickaxe;
import placeholder.game.item.equipment.weaponequipment.melee.tool.mining.SteelPickaxe;
import placeholder.game.item.equipment.weaponequipment.melee.tool.woodcutting.BronzeAxe;
import placeholder.game.item.equipment.weaponequipment.melee.tool.woodcutting.IronAxe;
import placeholder.game.item.equipment.weaponequipment.melee.tool.woodcutting.SteelAxe;
import placeholder.game.item.equipment.weaponequipment.range.JungleWoodBow;
import placeholder.game.item.equipment.weaponequipment.range.PineWoodBow;
import placeholder.game.item.equipment.weaponequipment.range.ThrowingRocks;
import placeholder.game.item.equipment.weaponequipment.range.WillowWoodBow;
import placeholder.game.item.equipment.weaponequipment.range.WoodBow;
import placeholder.game.item.material.ArrowShaft;
import placeholder.game.item.material.BronzeArrowTips;
import placeholder.game.item.material.Feather;
import placeholder.game.item.material.IronArrowTips;
import placeholder.game.item.material.SteelArrowTips;
import placeholder.game.item.material.StringItem;
import placeholder.game.item.material.WoodArrowTips;
import placeholder.game.item.material.bar.BronzeBar;
import placeholder.game.item.material.ore.CoalOre;
import placeholder.game.item.material.ore.CopperOre;
import placeholder.game.item.material.bar.IronBar;
import placeholder.game.item.material.ore.IronOre;
import placeholder.game.item.material.log.Log;
import placeholder.game.item.material.bar.SteelBar;
import placeholder.game.item.material.log.JungleLog;
import placeholder.game.item.material.log.PineLog;
import placeholder.game.item.material.log.WillowLog;
import placeholder.game.item.material.ore.Stone;
import placeholder.game.item.material.ore.TinOre;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.skill.Fletching;
import placeholder.game.skill.Skill;
import placeholder.game.skill.Smithing;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.player.Player;
import placeholder.game.sprite.entity.player.inventory.InventoryChangedListener;
import placeholder.game.sprite.furniture.Anvil;
import placeholder.game.sprite.furniture.Furnace;
import placeholder.game.sprite.furniture.Workbench;

/**
 *
 * @author jdolf
 */
public class CraftingManager implements InventoryChangedListener, PositionChangeListener {
    
    public static final Dimension NEARBY_CRAFTING_STATION_RADIUS = new Dimension(100, 100);
    public static final Collection<CraftingRecipe> RECIPES = Arrays.asList(
            new CraftingRecipeBuilder(
                    new ThrowingRocks(null, 20),
                    Arrays.asList(
                            new Stone(null, 1)
                    )
            ).build(),
            new CraftingRecipeBuilder(
                    new ArrowShaft(null, 25),
                    Arrays.asList(
                            new Log(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 30)
            .build(),
            new CraftingRecipeBuilder(
                    new ArrowShaft(null, 35),
                    Arrays.asList(
                            new JungleLog(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 45)
            .addSkillRequirement(Fletching.class, 5)
            .build(),
            new CraftingRecipeBuilder(
                    new ArrowShaft(null, 45),
                    Arrays.asList(
                            new WillowLog(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 60)
            .addSkillRequirement(Fletching.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new ArrowShaft(null, 55),
                    Arrays.asList(
                            new PineLog(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 75)
            .addSkillRequirement(Fletching.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new WoodArrowTips(null, 50),
                    Arrays.asList(
                            new Log(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 25)
            .build(),
            new CraftingRecipeBuilder(
                    new WoodArrow(null, 25),
                    Arrays.asList(
                            new ArrowShaft(null, 25),
                            new Feather(null, 25),
                            new WoodArrowTips(null, 25)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 70)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeArrow(null, 25),
                    Arrays.asList(
                            new ArrowShaft(null, 25),
                            new Feather(null, 25),
                            new BronzeArrowTips(null, 25)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 100)
            .build(),
            new CraftingRecipeBuilder(
                    new IronArrow(null, 25),
                    Arrays.asList(
                            new ArrowShaft(null, 25),
                            new Feather(null, 25),
                            new IronArrowTips(null, 25)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 140)
            .addSkillRequirement(Fletching.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelArrow(null, 25),
                    Arrays.asList(
                            new ArrowShaft(null, 25),
                            new Feather(null, 25),
                            new SteelArrowTips(null, 25)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 210)
            .addSkillRequirement(Fletching.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeBar(null, 1),
                    Arrays.asList(
                            new TinOre(null),
                            new CopperOre(null)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Furnace(null)
                    )
            ).addExperienceReward(Smithing.class, 90)
            .build(),
            new CraftingRecipeBuilder(
                    new IronBar(null, 1),
                    Arrays.asList(
                            new IronOre(null)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Furnace(null)
                    )
            ).addExperienceReward(Smithing.class, 120)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelBar(null, 1),
                    Arrays.asList(
                            new IronOre(null),
                            new CoalOre(null)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Furnace(null)
                    )
            ).addExperienceReward(Smithing.class, 250)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeHelmet(null),
                    Arrays.asList(
                            new BronzeBar(null, 3)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 270)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeChestplate(null),
                    Arrays.asList(
                            new BronzeBar(null, 7)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 630)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzePlatelegs(null),
                    Arrays.asList(
                            new BronzeBar(null, 5)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 450)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeShield(null),
                    Arrays.asList(
                            new BronzeBar(null, 5)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 450)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzePickaxe(null),
                    Arrays.asList(
                            new BronzeBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 360)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeAxe(null),
                    Arrays.asList(
                            new BronzeBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 360)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeSword(null),
                    Arrays.asList(
                            new BronzeBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 360)
            .build(),
            new CraftingRecipeBuilder(
                    new BronzeArrowTips(null, 50),
                    Arrays.asList(
                            new BronzeBar(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 90)
            .build(),
            new CraftingRecipeBuilder(
                    new IronHelmet(null),
                    Arrays.asList(
                            new IronBar(null, 3)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 360)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new IronChestplate(null),
                    Arrays.asList(
                            new IronBar(null, 7)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 840)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new IronPlatelegs(null),
                    Arrays.asList(
                            new IronBar(null, 5)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 600)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new IronShield(null),
                    Arrays.asList(
                            new IronBar(null, 5)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 500)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new IronSword(null),
                    Arrays.asList(
                            new IronBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 480)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new IronPickaxe(null),
                    Arrays.asList(
                            new IronBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 480)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new IronAxe(null),
                    Arrays.asList(
                            new IronBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 480)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new IronArrowTips(null, 50),
                    Arrays.asList(
                            new IronBar(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 120)
            .addSkillRequirement(Smithing.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelHelmet(null),
                    Arrays.asList(
                            new SteelBar(null, 3)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 750)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelChestplate(null),
                    Arrays.asList(
                            new SteelBar(null, 7)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 1750)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelPlatelegs(null),
                    Arrays.asList(
                            new SteelBar(null, 5)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 1250)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelHelmet(null),
                    Arrays.asList(
                            new SteelBar(null, 5)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 1250)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelSword(null),
                    Arrays.asList(
                            new SteelBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 1000)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelPickaxe(null),
                    Arrays.asList(
                            new SteelBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 1000)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelAxe(null),
                    Arrays.asList(
                            new SteelBar(null, 4)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 1000)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new SteelArrowTips(null, 50),
                    Arrays.asList(
                            new SteelBar(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                            new Anvil(null)
                    )
            ).addExperienceReward(Smithing.class, 250)
            .addSkillRequirement(Smithing.class, 20)
            .build(),
            new CraftingRecipeBuilder(
                    new WoodBow(null),
                    Arrays.asList(
                            new Log(null, 4),
                            new StringItem(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 200)
            .build(),
            new CraftingRecipeBuilder(
                    new JungleWoodBow(null),
                    Arrays.asList(
                            new JungleLog(null, 4),
                            new StringItem(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 350)
            .addSkillRequirement(Fletching.class, 5)
            .build(),
            new CraftingRecipeBuilder(
                    new WillowWoodBow(null),
                    Arrays.asList(
                            new WillowLog(null, 4),
                            new StringItem(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 500)
            .addSkillRequirement(Fletching.class, 10)
            .build(),
            new CraftingRecipeBuilder(
                    new PineWoodBow(null),
                    Arrays.asList(
                            new Log(null, 4),
                            new StringItem(null, 1)
                    )
            ).withCraftingStations(
                    Arrays.asList(
                        new Workbench(null)
                    )
            ).addExperienceReward(Fletching.class, 650)
            .addSkillRequirement(Fletching.class, 20)
            .build()
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
            
            if (hasSkillRequirements(recipe)) {
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
            }
        });
        
        notifyCraftableRecipesChangedListener();
    }
    
    private boolean hasSkillRequirements(CraftingRecipe recipe) {
        boolean success = true;
        
        for (Map.Entry<Class<? extends Skill>, Integer> set : recipe.getSkillRequirements().entrySet()) {
            for (Skill skill : player.getSkillManager().getSkills()) {
                if (skill.getClass() == set.getKey()) {
                    if (skill.getLevel() < set.getValue()) {
                        success = false;
                        break;
                    }
                }
            }
            
            if (!success) {
                break;
            }
        }
        
        return success;
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
