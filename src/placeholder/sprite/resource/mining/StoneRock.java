/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource.mining;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class StoneRock extends Rock {
    
    public final static String IMAGE = "stone_rock.png";
    public final static Dimension DIMENSION = new Dimension(32, 32);
    public final static int REPLENISH_TIME = 120;
    public final static int STABILITY = 500;
    public final static int REQUIRED_LEVEL = 1;
    
    public StoneRock(Point location) {
        super(ImageContainer.getInstance().getImage(IMAGE),
                location, REPLENISH_TIME, STABILITY, REQUIRED_LEVEL);
    }
    
}
