package placeholder.game.item.equipment.weaponequipment.range.projectile;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.EnumMap;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.input.Direction;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.entity.attack.AttackClient;

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
        this.velocity = 7;
    }
    
}
