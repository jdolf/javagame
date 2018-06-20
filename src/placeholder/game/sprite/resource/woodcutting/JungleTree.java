package placeholder.game.sprite.resource.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.material.JungleLog;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class JungleTree extends WoodcuttingResource {
    
    public final static String IMAGE = "jungle_tree.png";
    public final static Dimension DIMENSION = new Dimension(48, 48);
    public final static int REPLENISH_TIME = 800;
    public final static int STABILITY = 40;
    public final static int REQUIRED_LEVEL = 5;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(JungleLog.class, 1, 1)
    );
    
    public JungleTree(Point2D location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location, DIMENSION);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 90;
        lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
