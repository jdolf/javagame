package placeholder.game.sprite.resource.mining;

import placeholder.game.util.Point;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.material.ore.GoldOre;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class GoldRock extends Rock {
    
    public final static String IMAGE = "gold_rock.png";
    public final static int REPLENISH_TIME = 4500;
    public final static int STABILITY = 120;
    public final static int REQUIRED_LEVEL = 30;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(GoldOre.class, 1, 1)
    );
    
    public GoldRock(Point location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 340;
        this.lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
