package placeholder.game.sprite.collision;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
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
    
    private static Point calculateInitPosition(Dimension hitboxDown, CollisionalPlaneCreator creator) {
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
        if (this.getPosition() == null || this.getDimension() == null) {
            calculateScreenItem(creator, hitboxDown, exceptions);
        }
        
        if (this.getPosition() != null) {
            if (cd.getMap() == null) {
                cd.setMap(creator.getMap());
            }
            collisionCheck = this.cd.collidesAt(this.getPosition(), exceptions);
        }
    }
    
    public void addException(Object object) {
        this.exceptions.add(object);
    }
    
    
    
    
    
}
