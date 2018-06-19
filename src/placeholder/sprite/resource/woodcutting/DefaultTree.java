package placeholder.sprite.resource.woodcutting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import javafx.scene.image.Image;
import placeholder.item.material.Log;
import placeholder.item.material.Stone;
import placeholder.loot.LootTableItem;
import placeholder.loot.UnlimitedDropManager;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class DefaultTree extends WoodcuttingResource {
    
    public final static String IMAGE = "default_tree.png";
    public final static Dimension DIMENSION = new Dimension(48, 48);
    public final static int REPLENISH_TIME = 500;
    public final static int STABILITY = 30;
    public final static int REQUIRED_LEVEL = 1;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(Log.class, 1, 1)
    );
    
    public DefaultTree(Point2D location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location, DIMENSION);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 40;
        lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
}
