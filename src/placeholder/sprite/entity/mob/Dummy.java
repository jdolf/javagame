package placeholder.sprite.entity.mob;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import placeholder.item.ammo.WoodArrow;
import placeholder.loot.LootTableItem;
import placeholder.loot.UnlimitedDropManager;
import placeholder.screen.ImageContainer;
import placeholder.screen.animation.EntityAnimation;
import placeholder.sprite.entity.AnimatedEntity;
import placeholder.sprite.entity.attack.manager.BrainlessAttackManager;

/**
 *
 * @author jdolf
 */
public class Dummy extends AnimatedEntity {
    
    public static final Dimension DIMENSION = new Dimension(32, 32);
    public static final String ANIMATION_NAME = "dummy.png";
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(WoodArrow.class, 2, 5, 10)
    );

    public Dummy(Point2D location) {
        super(new EntityAnimation(ImageContainer.getInstance().getImage(ANIMATION_NAME), DIMENSION),
                DIMENSION,
                location,
                new BrainlessAttackManager());
        this.emitsXp = true;
        this.initHealth = 100;
        this.lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
