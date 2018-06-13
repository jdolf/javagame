package placeholder.sprite.collision;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.input.Direction;
import placeholder.map.Map;

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
