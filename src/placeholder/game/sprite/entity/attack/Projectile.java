package placeholder.game.sprite.entity.attack;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.Arrays;
import javafx.scene.image.Image;
import placeholder.game.input.Direction;
import placeholder.game.map.Map;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.animation.DirectionAnimation;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.sprite.AnimatedSprite;
import placeholder.game.sprite.collision.CollisionDetector;
import placeholder.game.sprite.collision.DefaultCollisionDetector;
import placeholder.game.sprite.DirectionDependent;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.collision.CollisionCheck;

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
        super(animation, dimension, new Point(location.getX(), location.getY()));
        this.attacker = attacker;
        this.map = attacker.getMap();
        this.attack = attack;
        this.direction = attacker.getDirection();;
        this.strength = strength;
        animation.setDirectionDependent(this);
        map.addSprite(this);
        attack.setPosition(this.getPosition());
        solid = false;
        attack();
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        
        if (attack.isInitialized()) {
            if (attack.getCollisionCheck().hasCollisionOccurrence()) {
                map.removeSprite(this);
            } else {
                Point directionOffset = this.direction.calculateOffsetChanges(
                    this.velocity
                );

                this.getPosition().setLocation(getPosition().getX() + directionOffset.getX(), getPosition().getY() + directionOffset.getY());
            }

            if (attack.getDuration() == 0) {
                map.removeSprite(this);
            }
        }
        
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }
    
    public void attack() {
        attack.attack();
    }
    
    
    
}
