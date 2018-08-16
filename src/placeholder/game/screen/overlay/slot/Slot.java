/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot;

import placeholder.game.util.Dimension;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;

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
