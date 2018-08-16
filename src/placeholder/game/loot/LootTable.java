package placeholder.game.loot;

import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.Collection;
import placeholder.game.item.Item;
import placeholder.game.screen.overlay.ScreenItem;

/**
 *
 * @author jdolf
 */
public class LootTable {
    
    private Collection<DropManager> dropManagers;
    /**
     * The start position of the items; leave blank if none
     */
    private Point startPosition;
    
    public LootTable() {
        dropManagers = new ArrayList();
    }
    
    public LootTable(Collection<DropManager> dropManagers) {
        this.dropManagers = dropManagers;
    }
    
    public Collection<Item> roll() {
        Collection<Item> items = new ArrayList();
        
        dropManagers.forEach((dropManager) -> {
            items.addAll(dropManager.roll());
        });
        
        if (startPosition != null) {
            items.forEach((item) -> {
                item.setPosition(startPosition);
            });
        }
        
        return items;
    }
    
    public void addDropManager(DropManager dropManager) {
        this.dropManagers.add(dropManager);
    }
    
    public void setStartPosition(Point position) {
        this.startPosition = position;
    }
    
}
