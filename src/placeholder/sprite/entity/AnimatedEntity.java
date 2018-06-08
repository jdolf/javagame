package placeholder.sprite.entity;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.DirectionAnimation;
import placeholder.screen.animation.EntityAnimation;
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
            EntityAnimation animation,
            Dimension dimension,
            Point2D location,
            AttackManager attackManager) {
        super(dimension, location, attackManager);
        this.animation = animation;
        animation.setDirectionDependent(this);
        animation.setEntity(this);
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
