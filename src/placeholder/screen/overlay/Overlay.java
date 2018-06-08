/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.screen.TickUpdatable;
import placeholder.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public abstract class Overlay extends ScreenItem implements Renderable, TickUpdatable {
    
    protected boolean toggledOn = true;
    
    public Overlay(Point2D position, Dimension dimension) {
        super(position, dimension);
    }

    public void setToggledOn(boolean state) {
        toggledOn = state;
    }
    
}
