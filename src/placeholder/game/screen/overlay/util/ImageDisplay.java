package placeholder.game.screen.overlay.util;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class ImageDisplay extends Display<Image> {

    public ImageDisplay(Image image, Point2D screenPosition, Dimension dimension) {
        super(screenPosition, dimension);
        
        this.data = image;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderImage(this.data, this);
    }
    
}
