/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource.mining;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class StoneRock extends Rock {
    
    public final static String IMAGE = "stone_rock.png";
    public final static int REPLENISH_TIME = 200;
    public final static int STABILITY = 25;
    public final static int REQUIRED_LEVEL = 1;
    
    public StoneRock(Point2D location) {
        super(ImageContainer.getInstance().getImage(IMAGE), location);
        this.defaultReplenishTime = REPLENISH_TIME;
        this.defaultStability = STABILITY;
        this.requiredLevel = REQUIRED_LEVEL;
        this.experience = 15;
    }
    
}
