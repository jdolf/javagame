package placeholder.item;

import placeholder.map.Map;
import placeholder.sprite.entity.attack.AttackClient;

/**
 *
 * @author jdolf
 */
public interface ProjectileCreator {
    void createProjectile(AttackClient attackClient, int duration, int invincibilityStun);
}
