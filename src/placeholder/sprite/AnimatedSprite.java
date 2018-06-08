/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.animation.Animation;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public abstract class AnimatedSprite extends Sprite {

    protected Animation animation;

    public AnimatedSprite(Animation animation, Dimension dimension, Point2D location) {
        super(dimension, location);
        this.animation = animation;
    }

    @Override
    public void tickUpdate() {
        animation.update();
    }    
    
    @Override
    public void render(Renderer renderer) {
        renderer.renderAnimation(animation, this);
    }
    
    
}
