/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.collision;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import placeholder.game.item.Item;
import placeholder.game.map.Map;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.entity.attack.Hittable;

/**
 *
 * @author jdolf
 */
public class DefaultCollisionDetector implements CollisionDetector {
    
    private Map map;
    private ScreenItem owner;
    
    public DefaultCollisionDetector(ScreenItem owner, Map map) {
        this.owner = owner;
        this.map = map;
    }
    
    /**
     * Checks if a sprite collides with another sprite from the map.
     * @param targetLocation The location of the collision check.
     * @return The collision check results.
     */
    @Override
    public CollisionCheck collidesAt(Point2D targetLocation) {
        
        List<Sprite> sprites = map.getSpriteReceiver().getAt(targetLocation, owner.getDimension());
        return new CollisionCheck(filterCollision(sprites)); 
    }

    private Collection<Sprite> filterCollision(List<Sprite> sprites) {
        Collection<Sprite> collidedSprites = new ArrayList();
        for (Sprite targetSprite : sprites) {
            
            if (targetSprite != owner) {
                if (targetSprite.isSolid()) {
                    collidedSprites.add(targetSprite);
                }
            }
        }
        return collidedSprites; 
    }

    @Override
    public CollisionCheck collidesAt(Point2D targetLocation, Collection<Object> exceptions) {
        List<Sprite> sprites = map.getSpriteReceiver().getAt(targetLocation, owner.getDimension());
        sprites.removeAll(exceptions);
        return new CollisionCheck(filterCollision(sprites)); 
    }
    
    public Collection<Item> collidesWithItemsAt(Point2D targetLocation) {
        return map.getItemReceiver().getAt(targetLocation, owner.getDimension());
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }
    
    
    
}
