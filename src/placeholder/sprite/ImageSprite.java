package placeholder.sprite;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class ImageSprite extends Sprite {

    private Image image;
    
    public ImageSprite(Dimension dimension, Point2D location, Image image) {
        super(dimension, location);
        this.image = image;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderImage(image, this);
    }

    @Override
    public void tickUpdate() {}
    
}
