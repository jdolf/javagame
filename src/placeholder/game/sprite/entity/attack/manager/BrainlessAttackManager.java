package placeholder.game.sprite.entity.attack.manager;

import placeholder.game.sprite.entity.Entity;

/**
 *
 * @author jdolf
 */
public class BrainlessAttackManager extends AttackManager<Entity> {

    @Override
    protected int attackImpl() {
        return 0;
    }
    
}
