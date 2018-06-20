package placeholder.game.sprite.resource.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.material.JungleLog;
import placeholder.game.item.material.WillowLog;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class WillowTree extends WoodcuttingResource {
    
    public final static String IMAGE = "willow_tree.png";
    public final static Dimension DIMENSION = new Dimension(48, 48);
    public final static int REPLENISH_TIME = 1500;
    public final static int STABILITY = 70;
    public final static int REQUIRED_LEVEL = 10;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(WillowLog.class, 1, 1)
    );
    
    public WillowTree(Point2D location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location, DIMENSION);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 150;
        lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
