package placeholder.screen.overlay.util;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.image.Image;
import placeholder.screen.render.Renderer;

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
