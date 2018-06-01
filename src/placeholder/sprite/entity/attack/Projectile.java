package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import placeholder.input.Direction;
import placeholder.map.Map;
import placeholder.screen.animation.Animation;
import placeholder.screen.animation.DirectionAnimation;
import placeholder.screen.overlay.ScreenItem;
import placeholder.sprite.AnimatedSprite;
import placeholder.sprite.collision.CollisionDetector;
import placeholder.sprite.collision.DefaultCollisionDetector;
import placeholder.sprite.DirectionDependent;
import placeholder.sprite.Sprite;
import placeholder.sprite.collision.CollisionCheck;

/**
 *
 * @author jdolf
 */
public abstract class Projectile extends AnimatedSprite implements DirectionDependent {
    
    /**
     * The map to register this projectile on
     */
    private Map map;
    protected Attack attack;
    private AttackClient attacker;
    protected Direction direction;
    protected int velocity = 1;
    protected int strength = 0;
    
    public Projectile(
            DirectionAnimation animation,
            Attack attack,
            Dimension dimension,
            Point location,
            AttackClient attacker,
            int strength
    ) {
        super(animation, dimension, new Point(location));
        this.attacker = attacker;
        this.map = attacker.getMap();
        this.attack = attack;
        this.direction = attacker.getDirection();;
        this.strength = strength;
        animation.setDirectionDependent(this);
        map.addSprite(this);
        attack.setPosition(this.getPosition());
        solid = false;
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        
        if (attack.isInitialized()) {
            if (attack.getStartUpTime() == 0 &&
                    attack.getCollisionCheck().hasCollisionOccurrence()) {
                map.removeSprite(this);
            } else {
                Point directionOffset = this.direction.calculateOffsetChanges(
                    this.velocity
                );

                this.getPosition().translate(directionOffset.x, directionOffset.y);
            }

            if (attack.getDuration() == 0) {
                map.removeSprite(this);
            }
        }
        
        attack.tickUpdate();
        
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }
    
}
