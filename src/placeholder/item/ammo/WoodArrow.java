package placeholder.item.ammo;

import java.awt.Point;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.item.Item;
import placeholder.item.ProjectileCreator;
import placeholder.screen.ImageContainer;
import placeholder.sprite.entity.attack.AttackClient;
import placeholder.sprite.entity.attack.WoodArrowProjectile;

/**
 *
 * @author jdolf
 */
public class WoodArrow extends Ammo {
    
    public static final String ICON_NAME = "wood_arrow_icon.png";
    
    public WoodArrow(Point position, int amount) {
        super(position, ImageContainer.getInstance().getImage(ICON_NAME), amount);
    }

    @Override
    public void createProjectile(AttackClient attackClient, int duration, int invincibilityStun) {
        super.createProjectile(attackClient, duration, invincibilityStun);
        new WoodArrowProjectile(attackClient, duration, invincibilityStun);
    }
    
    
    
}