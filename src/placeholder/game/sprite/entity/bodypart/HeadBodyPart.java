/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.entity.bodypart;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.game.screen.animation.DirectionAnimation;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class HeadBodyPart extends BodyPart {
    
    public HeadBodyPart(Image image, Point offsetCoordinates, Dimension dimension, Player player) {
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
