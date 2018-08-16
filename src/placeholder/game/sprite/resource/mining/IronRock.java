package placeholder.game.sprite.resource.mining;

import placeholder.game.util.Point;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.material.ore.IronOre;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class IronRock extends Rock {
    
    public final static String IMAGE = "iron_rock.png";
    public final static int REPLENISH_TIME = 800;
    public final static int STABILITY = 50;
    public final static int REQUIRED_LEVEL = 10;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(IronOre.class, 1, 1)
    );
    
    public IronRock(Point location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 110;
        this.lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
