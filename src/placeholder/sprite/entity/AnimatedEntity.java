package placeholder.sprite.entity;

import java.awt.Dimension;
import java.awt.Point;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.DirectionAnimation;
import placeholder.screen.render.Renderer;
import placeholder.sprite.AnimatedSprite;
import placeholder.sprite.entity.attack.manager.AttackManager;

/**
 *
 * @author jdolf
 */
public class AnimatedEntity extends Entity {
    
    protected Animation animation;
    
    public AnimatedEntity(
            DirectionAnimation animation,
            Dimension dimension,
            Point location,
            AttackManager attackManager) {
        super(dimension, location, attackManager);
        this.animation = animation;
        animation.setDirectionDependent(this);
    }
    
    @Override
    public void tickUpdate() {
        super.tickUpdate();
        animation.update();
    }    
    
    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        renderer.renderAnimation(animation, this);
    }
    
    
    
}
