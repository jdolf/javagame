/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.animation;

import java.awt.Dimension;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.image.Image;
import placeholder.game.input.Direction;
import placeholder.game.sprite.DirectionDependent;

/**
 *
 * @author jdolf
 */
public class DirectionAnimation<T> extends DefaultAnimation<T> {
    
    protected DirectionDependent directionDependent;
    
    public DirectionAnimation() {}
    
    public DirectionAnimation(Image image, Dimension dimension) {
        super(image, dimension);
    }
    
    public DirectionAnimation(DirectionDependent directionDependent, Image image, Dimension dimension) {
        super(image, dimension);
        this.directionDependent = directionDependent;
    }
    
    public DirectionAnimation(T data, DirectionDependent directionDependent, Image image, Dimension dimension) {
        super(data, image, dimension);
        this.directionDependent = directionDependent;
    }

    @Override
    public int calculateRow() {
        
        if (directionDependent == null) throw new IllegalStateException("No directionDependent set yet!");
        
        if (directionDependent.getDirection() == Direction.DOWN) {
            return 0;
        } else if (directionDependent.getDirection() == Direction.UP) {
            return 1;
        } else if (directionDependent.getDirection() == Direction.LEFT) {
            return 2;
        } else if (directionDependent.getDirection() == Direction.RIGHT) {
            return 3;
        }
        
        return 0;
    }

    @Override
    public int calculateColumn() {
        return 0;
    }

    public DirectionDependent getDirectionDependent() {
        return directionDependent;
    }

    public void setDirectionDependent(DirectionDependent directionDependent) {
        this.directionDependent = directionDependent;
    }
    
    
    
}
