package placeholder.item.ammo;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import javafx.scene.text.TextAlignment;
import placeholder.item.Item;
import placeholder.item.equipment.weaponequipment.ProjectileCreator;
import placeholder.screen.render.Renderer;
import placeholder.sprite.entity.attack.AttackClient;

/**
 *
 * @author jdolf
 */
public abstract class Ammo extends Item implements ProjectileCreator {
    
    public static final int MAX_STACK_AMOUNT = 64;
    
    public Ammo(Point2D position, Image icon, int amount) {
        super(position, icon, MAX_STACK_AMOUNT, amount);
    }
    
    @Override
    public void createProjectile(AttackClient attackClient, int duration, int invincibilityStun) {
        this.removeAmount(1);
    }
    
    
    
    
    
    
    
}
