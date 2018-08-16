package placeholder.game.item;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
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
