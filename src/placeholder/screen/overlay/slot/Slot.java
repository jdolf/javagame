/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot;

import java.awt.Dimension;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public abstract class Slot extends ScreenItem implements Renderable {

    public Slot(Dimension dimension) {
        super(dimension);
    }
    
    public abstract void executeCommand();
    
    
}
