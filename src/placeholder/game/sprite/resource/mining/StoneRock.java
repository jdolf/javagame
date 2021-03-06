/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.resource.mining;

import placeholder.game.util.Point;
import java.util.Arrays;
import java.util.Collection;
import placeholder.game.item.material.ore.Stone;
import placeholder.game.loot.LootTableItem;
import placeholder.game.loot.UnlimitedDropManager;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class StoneRock extends Rock {
    
    public final static String IMAGE = "stone_rock.png";
    public final static int REPLENISH_TIME = 200;
    public final static int STABILITY = 25;
    public final static int REQUIRED_LEVEL = 1;
    public static final Collection<LootTableItem> DROPS = Arrays.asList(
            new LootTableItem(Stone.class, 1, 1)
    );
    
    public StoneRock(Point location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 45;
        this.lootTable.addDropManager(new UnlimitedDropManager(DROPS));
    }
    
    
    
}
