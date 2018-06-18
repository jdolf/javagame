package placeholder.loot;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import placeholder.item.Item;
import placeholder.screen.overlay.ScreenItem;

/**
 *
 * @author jdolf
 */
public class LootTable {
    
    private Collection<DropManager> dropManagers;
    /**
     * The start position of the items; leave blank if none
     */
    private Point2D startPosition;
    
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
    
    public void setStartPosition(Point2D position) {
        this.startPosition = position;
    }
    
}
