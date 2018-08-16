package placeholder.game.sprite.collision;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.input.Direction;
import placeholder.game.map.Map;

/**
 *
 * @author jdolf
 */
public interface CollisionalPlaneCreator {
    Point getPosition();
    Dimension getDimension();
    Direction getDirection();
    Map getMap();
}
