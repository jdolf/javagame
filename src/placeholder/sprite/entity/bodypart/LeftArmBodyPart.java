/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.entity.bodypart;

import java.awt.Dimension;
import java.awt.Point;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.input.Direction;
import placeholder.screen.animation.DirectionAnimation;
import placeholder.screen.animation.LeftArmAnimation;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class LeftArmBodyPart extends BodyPart {

    public LeftArmBodyPart(Image image, Point offsetCoordinates, Dimension dimension, Player player) {
        super(offsetCoordinates, dimension, player, new LeftArmAnimation(player, image, dimension));
    }

    @Override
    public void update() {
        if (player.getDirection() == Direction.DOWN) {
            offsetCoordinates.x = -6;
        } else if (player.getDirection() == Direction.UP) {
            offsetCoordinates.x = 6;
        } else if (player.getDirection() == Direction.LEFT) {
            offsetCoordinates.x = 0;
        } else if (player.getDirection() == Direction.RIGHT) {
            offsetCoordinates.x = 0;
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
