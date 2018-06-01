package placeholder.item.ammo;

import java.awt.Point;
import javafx.scene.image.Image;
import placeholder.item.Item;
import placeholder.item.ProjectileCreator;
import placeholder.sprite.entity.attack.AttackClient;

/**
 *
 * @author jdolf
 */
public abstract class Ammo extends Item implements ProjectileCreator {
    
    public static final int MAX_STACK_AMOUNT = 64;
    
    public Ammo(Point position, Image icon, int amount) {
        super(position, icon, MAX_STACK_AMOUNT, amount);
    }
    
    @Override
    public void createProjectile(AttackClient attackClient, int duration, int invincibilityStun) {
        this.removeAmount(1);
    }
    
    
    
    
    
}
