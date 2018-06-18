package placeholder.loot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import placeholder.item.Item;

/**
 *
 * @author jdolf
 */
public abstract class DropManager {
    
    protected Collection<LootTableItem> items;
    protected Random random = new Random();
    
    public DropManager() {
        items = new ArrayList();
    }
    
    public DropManager(Collection<LootTableItem> items) {
        this.items = items;
    }
    
    public abstract Collection<Item> roll();
    
    public void addLootTableItem(LootTableItem item) {
        items.add(item);
    }
    
}
