package placeholder.game.screen.animation;

import java.awt.Dimension;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.game.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class PlayerMoveAnimation extends DirectionAnimation<Entity> {
    
    public static final int DEFAULT_NUM_COLUMNS = 3;
    public static final int DEFAULT_CYCLE_TIME = 15;
    private int moveCounter = 0;
    
    public PlayerMoveAnimation(Entity data, Image image, Dimension dimension) {
        super(data, data, image, dimension);
    }

    @Override
    public int calculateColumn() {
        if (this.data.isMoving()) {
            if (moveCounter >= DEFAULT_CYCLE_TIME) {
                moveCounter = 0;
                if (this.currentColumn < DEFAULT_NUM_COLUMNS - 1) {
                    return this.currentColumn + 1;
                } else {
                    return 1;
                }
            }
            return currentColumn;
        }
        
        return super.calculateColumn();
    }

    @Override
    public void update() {
        super.update();
        if (data.isMoving()) this.moveCounter += 1;
    }
    
    
    
}
