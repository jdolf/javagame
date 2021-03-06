package placeholder.game.item.ammo;

import placeholder.game.util.Point;
import javafx.scene.image.Image;
import javafx.scene.text.TextAlignment;
import placeholder.game.item.Item;
import placeholder.game.item.equipment.weaponequipment.ProjectileCreator;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.attack.AttackClient;
import placeholder.game.sprite.entity.attack.Projectile;

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
