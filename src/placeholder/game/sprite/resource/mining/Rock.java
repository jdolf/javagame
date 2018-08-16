/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.resource.mining;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public abstract class Rock extends MiningResource {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(32, 32);

    public Rock(
            Image animationImage,
            Point location,
            Dimension dimension) {
        
        super(animationImage, location, dimension);
        
    }
    
     public Rock(
             Image animationImage,
             Point location) {
         
        super(animationImage, location, DEFAULT_DIMENSION);
        
    }
    
}
