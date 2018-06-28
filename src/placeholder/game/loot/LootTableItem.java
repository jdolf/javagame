package placeholder.game.loot;

import java.awt.geom.Point2D;
import java.util.Random;
import placeholder.game.item.Item;

/**
 *
 * @author jdolf
 */
public class LootTableItem<T extends Item> {
    
    private Class<T> itemClass;
    /**
     * The chance of getting the drop on a roll (1 in n)
     */
    private double chance = 1;
    private int minQuantity;
    private int maxQuantity;
    private Random random = new Random();
    
    public LootTableItem(Class<T> itemClass, double chance, int quantity) {
        initialize(itemClass, chance);
        this.minQuantity = quantity;
        this.maxQuantity = quantity;
    }
    
    public LootTableItem(Class<T> itemClass, double chance, int minQuantity, int maxQuantity) {
        initialize(itemClass, chance);
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }
    
    private void initialize(Class itemClass1, double chance1) {
        this.itemClass = itemClass1;
        if (chance1 < 1) throw new IllegalArgumentException("Chance can't be less than 1");
        this.chance = chance1;
    }
    
    public T create() {
        T creation = null;
        
        creation = tryWithAmountConstructor();
        
        if (creation == null) {
            creation = tryWithoutAmountConstructor();
            if (creation == null) {
                throw new RuntimeException("No suitable constructor found in LootTableItem");
            }
        }
        
        return creation;
    }
    
    private T tryWithAmountConstructor() {
        try {
            return itemClass
            .getDeclaredConstructor(Point2D.class, int.class)
            .newInstance(null, minQuantity + random.nextInt(maxQuantity - minQuantity + 1));
        } catch (Exception ex) {
            return null;
        }
    }
    
    private T tryWithoutAmountConstructor() {
        try {
            return itemClass
            .getDeclaredConstructor(Point2D.class)
            .newInstance((Object) null);
        } catch (Exception ex) {
            return null;
        }
    }
    
    public double getChance() {
        return chance;
    }
    
    
}
