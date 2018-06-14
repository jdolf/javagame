package placeholder.item.equipment.weaponequipment.range.projectile;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.EnumMap;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.input.Direction;
import placeholder.item.equipment.weaponequipment.Hitbox;
import placeholder.screen.ImageContainer;
import placeholder.sprite.entity.attack.AttackClient;

/**
 *
 * @author jdolf
 */
public class WoodArrowProjectile extends RangeProjectile {
    
    public static final int STRENGTH = 5;
    public static final Dimension DIMENSION = new Dimension(32, 32);
    public static final String ANIMATION_NAME = "wood_arrow.png";

    public WoodArrowProjectile(AttackClient attackClient, int duration, int invincibilityStun) {
        super(
                attackClient,
                DIMENSION,
                ImageContainer.getInstance().getImage(ANIMATION_NAME),
                STRENGTH,
                duration,
                invincibilityStun
                
                
        );
        this.velocity = 4;
    }
    
}
