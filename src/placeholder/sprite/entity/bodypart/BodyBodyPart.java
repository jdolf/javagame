/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.entity.bodypart;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.screen.animation.DirectionAnimation;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class BodyBodyPart extends BodyPart {

    public BodyBodyPart(Image image, Point2D offsetCoordinates, Dimension dimension, Player player) {
        super(offsetCoordinates, dimension, player, new DirectionAnimation(player, image, dimension));
    }

    @Override
    public int getDownZIndex() {
        return 1;
    }

    @Override
    public int getUpZIndex() {
        return 2;
    }

    @Override
    public int getLeftZIndex() {
        return 2;
    }

    @Override
    public int getRightZIndex() {
        return 2;
    }
    
}
