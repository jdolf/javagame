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
public class DefaultSpriteReceiver implements SpriteReceiver {
    
    private Map map;
    
    public DefaultSpriteReceiver(Map map) {
        this.map = map;
    }

    @Override
    public List<Sprite> getSpritesAt(Point2D Point2D, Dimension area) {
        
        List<Sprite> sprites = new ArrayList();
        
        for (Sprite sprite : this.getSprites()) {
            if (Maths.overlapping(Point2D, area, sprite.getPosition(), sprite.getDimension())) {
                sprites.add(sprite);
            }
        }
        
        return sprites;
    }

    @Override
    public List<Sprite> getSprites() {
        return this.map.getSprites();
    }

    @Override
    public <T> List<T> getSpritesAt(Class<T> conditionClass, Point2D Point2D, Dimension area) {
        List<T> sprites = new ArrayList();
        
        for (Sprite sprite : this.getSprites()) {
            if (conditionClass.isAssignableFrom(sprite.getClass())) {
                if (Maths.overlapping(Point2D, area, sprite.getPosition(), sprite.getDimension())) {
                    sprites.add((T) sprite);
                }
            }
        }
        
        return sprites;
    }
    
}
