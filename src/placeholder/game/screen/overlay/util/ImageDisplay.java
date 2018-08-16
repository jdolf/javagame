package placeholder.game.screen.overlay.util;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class ImageDisplay extends Display<Image> {

    public ImageDisplay(Image image, Point screenPosition, Dimension dimension) {
        super(screenPosition, dimension);
        
        this.data = image;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderImage(this.data, this);
    }
    
}
