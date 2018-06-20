package placeholder.game.loot;

import java.util.ArrayList;
import java.util.Collection;
import placeholder.game.item.Item;

/**
 *
 * @author jdolf
 */
public class UnlimitedDropManager extends DropManager {

    public UnlimitedDropManager() {}

    public UnlimitedDropManager(Collection<LootTableItem> items) {
        super(items);
    }

    @Override
    public Collection<Item> roll() {
        Collection<Item> dropItems = new ArrayList();
        
        for (LootTableItem item : this.items) {
            if (random.nextDouble() <= 1 / item.getChance()) {
                dropItems.add(item.create());
            }
        }
        
        return dropItems;
    }
    
}
