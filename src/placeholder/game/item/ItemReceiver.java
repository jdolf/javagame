package placeholder.game.item;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.List;
import placeholder.game.map.Map;
import placeholder.game.sprite.Receiver;

/**
 *
 * @author jdolf
 */
public class ItemReceiver extends Receiver<Item> {
    
    public ItemReceiver(Map map) {
        super(map);
    }

    @Override
    public List<Item> getItems() {
        return map.getItems();
    }

    
    
}
