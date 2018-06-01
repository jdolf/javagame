/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author jdolf
 */
public interface SpriteReceiver {
    <T> List<T> getSpritesAt(Class<T> conditionClass, Point point, Dimension area);
    List<Sprite> getSpritesAt(Point point, Dimension area);
    List<Sprite> getSprites();
}
