package placeholder.game.sprite.resource.mining;

import placeholder.game.util.Point;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.material.ore.CopperOre;
import placeholder.game.item.material.ore.Stone;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class CopperRock extends Rock {
    
    public final static String IMAGE = "copper_rock.png";
    public final static int REPLENISH_TIME = 400;
    public final static int STABILITY = 35;
    public final static int REQUIRED_LEVEL = 1;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(CopperOre.class, 1, 1)
    );
    
    public CopperRock(Point location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 65;
        this.lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
