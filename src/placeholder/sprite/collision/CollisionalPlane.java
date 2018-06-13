package placeholder.sprite.collision;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import javafx.scene.paint.Color;
import placeholder.input.Direction;
import placeholder.map.Map;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.sprite.SpriteReceiver;
import placeholder.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class CollisionalPlane extends ScreenItem implements TickUpdatable {
    
    private CollisionDetector cd;
    protected CollisionCheck collisionCheck;
    private Collection<Object> exceptions;
    
    private static Point2D calculateInitPosition(Dimension hitboxDown, CollisionalPlaneCreator creator) {
        return creator.getDirection().calculatePointWithOffset(hitboxDown, creator.getPosition(), creator.getDimension());
    }
    
    private static Dimension calculateInitHitbox(Dimension hitboxDown, Direction direction) {
        Dimension hitbox = new Dimension(hitboxDown);
        if (null != direction) switch (direction) {
            case LEFT:
                hitbox.width = hitboxDown.height;
                hitbox.height = hitboxDown.width;
                break;
            case RIGHT:
                hitbox.width = hitboxDown.height;
                hitbox.height = hitboxDown.width;
                break;
            default:
                break;
        }
        return hitbox;
    }
    
    public CollisionalPlane(CollisionalPlaneCreator creator, Dimension hitboxDown, Collection<Object> exceptions, Map map) {
        super(calculateInitPosition(hitboxDown, creator), calculateInitHitbox(hitboxDown, creator.getDirection()));
        this.cd = new DefaultCollisionDetector(this, creator.getMap().getSpriteReceiver());
        this.exceptions = exceptions;
    }

    @Override
    public void tickUpdate() {
        collisionCheck = this.cd.collidesAt(this.getPosition(), exceptions);
    }
    
    
    
}
