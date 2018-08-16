/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.collision;

import placeholder.game.util.Point;
import java.util.Collection;
import java.util.List;
import placeholder.game.item.Item;
import placeholder.game.map.Map;
import placeholder.game.sprite.entity.attack.Hittable;

/**
 *
 * @author jdolf
 */
public interface CollisionDetector {
    CollisionCheck collidesAt(Point targetLocation);
    CollisionCheck collidesAt(Point targetLocation, Collection<Object> exceptions);
    Collection<Item> collidesWithItemsAt(Point targetLocation);
    void setMap(Map map);
    Map getMap();
}
