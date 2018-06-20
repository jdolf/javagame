package placeholder.game.sprite.collision;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.game.input.Direction;
import placeholder.game.map.Map;

/**
 *
 * @author jdolf
 */
public interface CollisionalPlaneCreator {
    Point2D getPosition();
    Dimension getDimension();
    Direction getDirection();
    Map getMap();
}
