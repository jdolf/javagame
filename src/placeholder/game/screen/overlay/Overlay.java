/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public abstract class Overlay extends ScreenItem implements Renderable, TickUpdatable {
    
    protected boolean toggledOn = true;
    
    public Overlay(Point position, Dimension dimension) {
        super(position, dimension);
    }
    
    public Overlay(Dimension dimension) {
        super(dimension);
    }

    public void setToggledOn(boolean state) {
        toggledOn = state;
    }
    
}
