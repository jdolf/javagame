package placeholder.game.sprite.entity.mob;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.ammo.WoodArrow;
import placeholder.game.item.material.Feather;
import placeholder.game.item.material.StringItem;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.animation.EntityAnimation;
import placeholder.game.sprite.entity.AnimatedEntity;
import placeholder.game.sprite.entity.attack.manager.BrainlessAttackManager;

/**
 *
 * @author jdolf
 */
public class Dummy extends AnimatedEntity {
    
    public static final Dimension DIMENSION = new Dimension(32, 32);
    public static final String ANIMATION_NAME = "dummy.png";
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(WoodArrow.class, 2, 5, 10),
            new LootTableItem(StringItem.class, 1.5, 1, 3),
            new LootTableItem(Feather.class, 1.5, 10, 60)
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
