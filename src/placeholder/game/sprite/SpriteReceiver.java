/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.List;
import placeholder.game.map.Map;
import placeholder.game.util.Maths;

/**
 *
 * @author jdolf
 */
public class SpriteReceiver extends Receiver<Sprite> {
    
    public SpriteReceiver(Map map) {
        super(map);
    }

    @Override
    public List<Sprite> getItems() {
        return map.getSprites();
    }
    
}
