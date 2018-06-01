/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.collision;

import java.awt.Point;
import java.util.Collection;
import java.util.List;
import placeholder.sprite.entity.attack.Hittable;

/**
 *
 * @author jdolf
 */
public interface CollisionDetector {
    CollisionCheck collidesAt(Point targetLocation);
    CollisionCheck collidesAt(Point targetLocation, Collection<Object> exceptions);
}
