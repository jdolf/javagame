package placeholder.game.sprite.resource.mining;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.material.ore.CoalOre;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class CoalRock extends Rock {
    
    public final static String IMAGE = "coal_rock.png";
    public final static int REPLENISH_TIME = 1200;
    public final static int STABILITY = 75;
    public final static int REQUIRED_LEVEL = 20;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(CoalOre.class, 1, 1)
    );
    
    public CoalRock(Point2D location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 175;
        this.lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
