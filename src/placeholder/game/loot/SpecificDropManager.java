package placeholder.game.loot;

import java.util.ArrayList;
import java.util.Collection;
import placeholder.game.item.Item;

/**
 * Drops a specified amount of items.
 * @author jdolf
 */
public class SpecificDropManager extends DropManager {
    
    private int amount;

    public SpecificDropManager(int amount) {
        this.amount = amount;
    }

    public SpecificDropManager(Collection<LootTableItem> items, int amount) {
        super(items);
        this.amount = amount;
    }

    /**
     * Loops through possible items until the specific amount of wanted items is fetched.
     * @return 
     */
    @Override
    public Collection<Item> roll() {
        Collection<Item> dropItems = new ArrayList();
        
        for (LootTableItem item : this.items) {
            if (random.nextDouble() <= 1 / item.getChance()) {
                dropItems.add(item.create());
            }
            if (dropItems.size() == amount) break;
        }
        
        return dropItems;
    }

    
    
}
