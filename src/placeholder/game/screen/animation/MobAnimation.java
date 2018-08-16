package placeholder.game.screen.animation;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;
import placeholder.game.sprite.entity.mob.Mob;

/**
 *
 * @author jdolf
 */
public class MobAnimation extends EntityAnimation<Mob> {
    
    public static final int DEFAULT_CYCLE_TIME = 15;
    private int moveCounter = 0;
    private int lastStep = 2;
    
    public MobAnimation(Image image, Dimension dimension) {
        super(image, dimension);
    }

    @Override
    public int calculateColumn() {
        // Dirty workaround; generics don't seem to work
        SimpleAttackManager attackManager = (SimpleAttackManager) this.data.getAttackManager();
        if (attackManager.isAttacking()) {
            if (attackManager.getStartUpTime() > 0) {
                return 4;
            } else {
                if (attackManager.getAttack().getDuration() >= attackManager.getAttack().getDefaultDuration() / 2) {
                    return 5;
                } else if (attackManager.getAttack().getDuration() <= attackManager.getAttack().getDefaultDuration() / 2 && attackManager.getAttack().getDuration() != 0) {
                    return 6;
                }
            }
        }
        if (this.data.isMoving()) {
            if (moveCounter >= DEFAULT_CYCLE_TIME) {
                moveCounter = 0;
                if (lastStep == 2) {
                    lastStep = 3;
                    return 3;
                } else {
                    lastStep = 2;
                    return 2;
                }
            }
            return currentColumn;
        }
        
        return super.calculateColumn();
    }
    
    @Override
    public void update() {
        super.update();
        if (data.isMoving()) this.moveCounter += 1;
    }
    
    
    
}
