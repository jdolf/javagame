package placeholder.game.sprite.entity.mob;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
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
import placeholder.game.sprite.entity.attack.MeleeAttack;
import placeholder.game.sprite.entity.attack.manager.BrainlessAttackManager;
import placeholder.game.sprite.entity.attack.manager.SimpleAttackManager;
import placeholder.game.sprite.entity.mob.ai.FighterAI;

/**
 *
 * @author jdolf
 */
public class Dummy extends Mob<SimpleAttackManager> {
    
    public static final Dimension DIMENSION = new Dimension(32, 32);
    public static final String ANIMATION_NAME = "dummy.png";
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(WoodArrow.class, 2, 5, 10),
            new LootTableItem(StringItem.class, 1.5, 1, 3),
            new LootTableItem(Feather.class, 1.5, 10, 60)
    );

    public Dummy(Point location) {
        super(
                new EntityAnimation(ImageContainer.getInstance().getImage(ANIMATION_NAME), DIMENSION),
                DIMENSION,
                location
                );
        this.emitsXp = true;
        this.initHealth = 100;
        this.meleeStrength = 10;
        this.lootTable.addDropManager(new UnlimitedDropManager(DROPS));
        this.attackManager = new SimpleAttackManager(
                new MeleeAttack(this, new Dimension(30, 30), 30, 30), 50, 30
        );
        this.ai = new FighterAI(this, attackManager);
    }
    
}
