package placeholder.game.screen.animation;

import java.awt.Dimension;
import javafx.scene.image.Image;
import placeholder.game.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class EntityAnimation extends DirectionAnimation<Entity> {
    
    public EntityAnimation(Image image, Dimension dimension) {
        super(image, dimension);
    }

    @Override
    public int calculateColumn() {
        if (this.data.isDead()) {
            return 1;
        }
        return super.calculateColumn();
    }
    
    public void setEntity(Entity entity) {
        this.data = entity;
    }
    
    
}
