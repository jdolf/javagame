package placeholder.sprite.entity.mob;

import java.awt.Dimension;
import java.awt.Point;
import java.util.EnumMap;
import java.util.Map;
import placeholder.screen.ImageContainer;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.DirectionAnimation;
import placeholder.screen.animation.EntityAnimation;
import placeholder.sprite.entity.AnimatedEntity;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.attack.manager.AttackManager;
import placeholder.sprite.entity.attack.manager.BrainlessAttackManager;

/**
 *
 * @author jdolf
 */
public class Dummy extends AnimatedEntity {
    
    public static final Dimension DIMENSION = new Dimension(32, 32);
    public static final String ANIMATION_NAME = "dummy.png";

    public Dummy(Point location) {
        super(new EntityAnimation(ImageContainer.getInstance().getImage(ANIMATION_NAME), DIMENSION),
                DIMENSION,
                location,
                new BrainlessAttackManager());
        this.emitsXp = true;
        this.initHealth = 100;
    }
    
}
