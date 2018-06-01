package placeholder.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.Point;
import placeholder.input.Direction;
import placeholder.map.Map;
import placeholder.sprite.collision.CollisionDetector;
import placeholder.sprite.entity.attack.Hittable;

/**
 * An interface implemented by those who are able to attack.
 * @author jdolf
 */
public interface AttackClient {
    void attack();
    Point getPosition();
    Dimension getDimension();
    Direction getDirection();
    Map getMap();
    int getMeleeStrength();
    int getMeleeDefense();
    int getRangeStrength();
    int getRangeDefense();
    int getMagicStrength();
    int getMagicDefense();
    void setMeleeAttack(MeleeAttack meleeAttack);
}
