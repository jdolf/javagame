/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.entity.bodypart;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.input.Direction;
import placeholder.game.screen.animation.Animation;
import placeholder.game.screen.animation.DirectionAnimation;
import placeholder.game.screen.animation.DefaultAnimation;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public abstract class BodyPart implements Renderable {

    /**
     * Coordinates relative to the top left of the Entity. Positive y = down
     * Positive x = right
     */
    protected Point2D offsetCoordinates;
    protected Dimension dimension;
    protected Animation animation;
    protected Player player;
    protected int zIndex = 1;

    public BodyPart(
            Point2D offsetCoordinates,
            Dimension dimension,
            Player player, 
            Animation animation) {
        this.offsetCoordinates = offsetCoordinates;
        this.dimension = dimension;
        this.player = player;
        this.animation = animation;
    }

    public Animation getAnimation() {
        return this.animation;
    }

    public Dimension getDimension() {
        return this.dimension;
    }

    public Entity getPlayer() {
        return this.player;
    }

    public void render(Renderer renderer) {
        renderer.renderAnimation(animation,
                new ScreenItem(
                        new Point2D.Double(
                                player.getPosition().getX() + offsetCoordinates.getX(),
                                player.getPosition().getY() + offsetCoordinates.getY()
                        ),
                        new Dimension(
                                dimension.width,
                                dimension.height
                        )
                )
        );
    }

    public void update() {
        this.animation.update();
        
        // Update z-Index
        if (player.getDirection() == Direction.DOWN) {
            this.zIndex = getDownZIndex();
        } else if (player.getDirection() == Direction.UP) {
            this.zIndex = getUpZIndex();
        } else if (player.getDirection() == Direction.LEFT) {
            this.zIndex = getLeftZIndex();
        } else if (player.getDirection() == Direction.RIGHT) {
            this.zIndex = getRightZIndex();
        }
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public Point2D getOffsetCoordinates() {
        return this.offsetCoordinates;
    }
    
    public abstract int getDownZIndex();
    
    public abstract int getUpZIndex();
    
    public abstract int getLeftZIndex();
    
    public abstract int getRightZIndex();

}
