package placeholder.game.item.ammo;

import java.awt.geom.Point2D;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.Item;
import placeholder.game.item.equipment.weaponequipment.ProjectileCreator;
import placeholder.game.item.equipment.weaponequipment.range.projectile.IronArrowProjectile;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.entity.attack.AttackClient;
import placeholder.game.item.equipment.weaponequipment.range.projectile.WoodArrowProjectile;

/**
 *
 * @author jdolf
 */
public class IronArrow extends Ammo {
    
    public static final String ICON_NAME = "iron_arrow_icon.png";
    
    public IronArrow(Point2D position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), amount);
        this.displayName = "Iron Arrow";
    }

    @Override
    public void createProjectile(AttackClient attackClient, int duration, int invincibilityStun) {
        super.createProjectile(attackClient, duration, invincibilityStun);
        new IronArrowProjectile(attackClient, duration, invincibilityStun).attack();
    }
    
    
    
}
