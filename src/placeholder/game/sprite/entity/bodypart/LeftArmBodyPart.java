/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.sprite.entity.bodypart;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.game.input.Direction;
import placeholder.game.screen.animation.DirectionAnimation;
import placeholder.game.screen.animation.LeftArmAnimation;
import placeholder.game.sprite.entity.Entity;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class LeftArmBodyPart extends BodyPart {

    public LeftArmBodyPart(Image image, Point2D offsetCoordinates, Dimension dimension, Player player) {
        super(offsetCoordinates, dimension, player, new LeftArmAnimation(player, image, dimension));
    }

    @Override
    public void update() {
        if (player.getDirection() == Direction.DOWN) {
            offsetCoordinates.setLocation(-6, offsetCoordinates.getY());
        } else if (player.getDirection() == Direction.UP) {
            offsetCoordinates.setLocation(6, offsetCoordinates.getY());
        } else if (player.getDirection() == Direction.LEFT) {
            offsetCoordinates.setLocation(0, offsetCoordinates.getY());
        } else if (player.getDirection() == Direction.RIGHT) {
            offsetCoordinates.setLocation(0, offsetCoordinates.getY());
        }
        
        super.update();
    }

    @Override
    public int getDownZIndex() {
        return 2;
    }

    @Override
    public int getUpZIndex() {
        return 1;
    }

    @Override
    public int getLeftZIndex() {
        return 1;
    }

    @Override
    public int getRightZIndex() {
        return 3;
    }
    
}
