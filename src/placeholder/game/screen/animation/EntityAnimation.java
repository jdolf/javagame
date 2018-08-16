package placeholder.game.screen.animation;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import placeholder.game.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class EntityAnimation<T extends Entity> extends DirectionAnimation<T> {
    
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
    
    
}
