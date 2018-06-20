package placeholder.game.sprite.entity.attack;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.game.input.Direction;
import placeholder.game.map.Map;
import placeholder.game.sprite.collision.CollisionDetector;
import placeholder.game.sprite.collision.CollisionalPlaneCreator;
import placeholder.game.sprite.entity.attack.Hittable;

/**
 * An interface implemented by those who are able to attack.
 * @author jdolf
 */
public interface AttackClient extends CollisionalPlaneCreator {
    void attack();;
    int getMeleeStrength();
    int getMeleeDefense();
    int getRangeStrength();
    int getRangeDefense();
    int getMagicStrength();
    int getMagicDefense();
    void setMeleeAttack(MeleeAttack meleeAttack);
}
