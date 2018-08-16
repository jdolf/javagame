package placeholder.game.sprite.entity;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.animation.DirectionAnimation;
import placeholder.game.screen.animation.EntityAnimation;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.AnimatedSprite;
import placeholder.game.sprite.entity.attack.manager.AttackManager;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;

/**
 *
 * @author jdolf
 */
public class AnimatedEntity<T extends SimpleAttackManager> extends Entity<T> {
    
    protected Animation animation;
    
    public AnimatedEntity(
            EntityAnimation animation,
            Dimension dimension,
            Point location) {
        super(dimension, location);
        this.animation = animation;
        animation.setDirectionDependent(this);
        animation.setData(this);
    }
    
    @Override
    public void tickUpdate() {
        animation.update();
        super.tickUpdate();
    }    
    
    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        renderer.renderAnimation(animation, this);
    }

    @Override
    public Image makePreviewImage() {
        return animation.createPreviewImage();
    }
    
    
    
}
