/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.collision;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.List;
import placeholder.game.item.Item;
import placeholder.game.sprite.entity.attack.Hittable;

/**
 *
 * @author jdolf
 */
public interface CollisionDetector {
    CollisionCheck collidesAt(Point2D targetLocation);
    CollisionCheck collidesAt(Point2D targetLocation, Collection<Object> exceptions);
    Collection<Item> collidesWithItemsAt(Point2D targetLocation);
}
