/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public abstract class Sprite extends ScreenItem implements Renderable, TickUpdatable {
    
    protected boolean solid = true;
    protected boolean craftingStation = false;
    
    public Sprite(Dimension dimension, Point2D location) {
        super(location, dimension);
    }
    
    public boolean isSolid() {
        return this.solid;
    };

    public boolean isCraftingStation() {
        return craftingStation;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    
    public abstract Image makePreviewImage();
    
    
}
