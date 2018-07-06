package placeholder.game.sprite.entity.mob;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.game.screen.animation.EntityAnimation;
import placeholder.game.sprite.entity.AnimatedEntity;
import placeholder.game.sprite.entity.attack.manager.AttackManager;
import placeholder.game.sprite.entity.attack.manager.BrainlessAttackManager;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;
import placeholder.game.sprite.entity.mob.ai.AI;

/**
 *
 * @author jdolf
 */
public class Mob<T extends SimpleAttackManager> extends AnimatedEntity<T> {
    
    protected AI ai;
    
    public Mob(EntityAnimation entityAnimation, Dimension dimension, Point2D location) {
        super(entityAnimation, dimension, location);
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        ai.tickUpdate();
    }
    
    
    
}
