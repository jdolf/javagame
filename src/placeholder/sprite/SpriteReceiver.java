/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import placeholder.map.Map;
import placeholder.util.Maths;

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
