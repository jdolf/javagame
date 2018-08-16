package placeholder.game.item.ammo;

import placeholder.game.util.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.item.Item;
import placeholder.game.item.equipment.weaponequipment.ProjectileCreator;
import placeholder.game.item.equipment.weaponequipment.range.projectile.SteelArrowProjectile;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.entity.attack.AttackClient;
import placeholder.game.item.equipment.weaponequipment.range.projectile.WoodArrowProjectile;

/**
 *
 * @author jdolf
 */
public class SteelArrow extends Ammo {
    
    public static final String ICON_NAME = "steel_arrow_icon.png";
    
    public SteelArrow(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), amount);
        this.displayName = "Steel Arrow";
    }

    @Override
    public void createProjectile(AttackClient attackClient, int duration, int invincibilityStun) {
        super.createProjectile(attackClient, duration, invincibilityStun);
        new SteelArrowProjectile(attackClient, duration, invincibilityStun).attack();
    }
    
    
    
}
