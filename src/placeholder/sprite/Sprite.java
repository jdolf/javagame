/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite;

import java.awt.Dimension;
import java.awt.Point;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public abstract class Sprite extends ScreenItem implements Renderable, TickUpdatable {
    
    protected boolean solid = true;
    
    public Sprite(Dimension dimension, Point location) {
        super(location, dimension);
    }
    
    public boolean isSolid() {
        return this.solid;
    };
    
    
    
}
