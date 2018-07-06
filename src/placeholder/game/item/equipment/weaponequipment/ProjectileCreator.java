package placeholder.game.item.equipment.weaponequipment;

import placeholder.game.map.Map;
import placeholder.game.sprite.entity.attack.AttackClient;
import placeholder.game.sprite.entity.attack.Projectile;

/**
 *
 * @author jdolf
 */
public interface ProjectileCreator {
    void createProjectile(AttackClient attackClient, int duration, int invincibilityStun);
}
