/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.render;

import java.awt.Dimension;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jdolf
 */
public class CameraOrientedRenderer extends DefaultRenderer {

    // TODO: calculate difference to camera

    public CameraOrientedRenderer(GraphicsContext gc, Dimension gameDimension) {
        super(gc, gameDimension);
    }
    
    
}
