/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.resource.mining;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public abstract class Rock extends MiningResource {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(32, 32);

    public Rock(
            Image animationImage,
            Point2D location,
            Dimension dimension) {
        
        super(animationImage, location, dimension);
        
    }
    
     public Rock(
             Image animationImage,
             Point2D location) {
         
        super(animationImage, location, DEFAULT_DIMENSION);
        
    }
    
}
