/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.collision;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import placeholder.screen.overlay.ScreenItem;
import placeholder.sprite.Sprite;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.entity.attack.Hittable;

/**
 *
 * @author jdolf
 */
public class DefaultCollisionDetector implements CollisionDetector {
    
    private SpriteReceiver spriteReceiver;
    private ScreenItem owner;
    
    public DefaultCollisionDetector(ScreenItem owner, SpriteReceiver spriteReceiver) {
        this.owner = owner;
        this.spriteReceiver = spriteReceiver;
    }
    
    /**
     * Checks if a sprite collides with another sprite from the map.
     * @param targetLocation The location of the collision check.
     * @return The collision check results.
     */
    @Override
    public CollisionCheck collidesAt(Point2D targetLocation) {
        
        List<Sprite> sprites = spriteReceiver.getSpritesAt(targetLocation, owner.getDimension());
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
        List<Sprite> sprites = spriteReceiver.getSpritesAt(targetLocation, owner.getDimension());
        sprites.removeAll(exceptions);
        return new CollisionCheck(filterCollision(sprites)); 
    }
    
    
    
}
