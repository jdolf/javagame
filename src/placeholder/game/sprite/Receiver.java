/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import placeholder.game.map.Map;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.util.Maths;

/**
 *
 * @author jdolf
 */
public abstract class Receiver<T2 extends ScreenItem> {
    
    protected Map map;
    
    public Receiver(Map map) {
        this.map = map;
    }

    public List<T2> getAt(Point2D Point2D, Dimension area) {
        List<T2> sprites = new ArrayList();
        
        for (T2 sprite : getItems()) {
            if (Maths.overlapping(Point2D, area, sprite.getPosition(), sprite.getDimension())) {
                sprites.add(sprite);
            }
        }
        
        return sprites;
    }

    public abstract List<T2> getItems();
}
