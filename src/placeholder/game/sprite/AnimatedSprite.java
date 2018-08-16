/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public abstract class AnimatedSprite extends Sprite {

    protected Animation animation;

    public AnimatedSprite(Animation animation, Dimension dimension, Point location) {
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

    @Override
    public Image makePreviewImage() {
        return animation.createPreviewImage();
    }
    
    

    
    
    
    
    
}
