package placeholder.game.sprite.collision;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import javafx.scene.paint.Color;
import placeholder.game.input.Direction;
import placeholder.game.map.Map;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.SpriteReceiver;
import placeholder.game.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class CollisionalPlane extends ScreenItem implements TickUpdatable {
    
    private CollisionalPlaneCreator creator;
    protected Dimension hitboxDown;
    protected CollisionDetector cd = new DefaultCollisionDetector(this, null);
    protected CollisionCheck collisionCheck;
    protected Collection<Object> exceptions;
    
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
    
    protected void calculateScreenItem(CollisionalPlaneCreator creator, Dimension hitboxDown, Collection<Object> exceptions) {
        this.setDimension(calculateInitHitbox(hitboxDown, creator.getDirection()));
        this.setPosition(calculateInitPosition(hitboxDown, creator));
        this.cd = new DefaultCollisionDetector(this, creator.getMap());
        this.exceptions = exceptions;
    }
    
    public CollisionalPlane(CollisionalPlaneCreator creator, Dimension hitboxDown, Collection<Object> exceptions) {
        this.creator = creator;
        this.hitboxDown = hitboxDown;
        this.exceptions = exceptions;
    }

    @Override
    public void tickUpdate() {
        if (this.getPosition() != null) {
            collisionCheck = this.cd.collidesAt(this.getPosition(), exceptions);
        }
    }
    
    public void addException(Object object) {
        this.exceptions.add(object);
    }
    
    
    
    
    
}
