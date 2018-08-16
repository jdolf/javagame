/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.animation;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import placeholder.game.sprite.resource.Resource;

/**
 *
 * @author jdolf
 */
public class ResourceAnimation extends DefaultAnimation<Resource> {
    
    public static final int ROW_REPLENISHED = 0;
    public static final int ROW_DEPLETED = 1;
    
    public ResourceAnimation(Image image, Dimension dimension) {
        super(image, dimension);
    }

    @Override
    public int calculateColumn() {
        return 0;
    }

    @Override
    public int calculateRow() {
        if (this.data.isDepleted()) {
            return ROW_DEPLETED;
        } else {
            return ROW_REPLENISHED;
        }
    }
    
}
