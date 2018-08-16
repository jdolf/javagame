package placeholder.game.sprite;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class ImageSprite extends Sprite {
    
    private Image image;
    
    public ImageSprite(Dimension dimension, Point location, Image image) {
        super(dimension, location);
        this.image = image;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderImage(image, this);
    }

    @Override
    public void tickUpdate() {}

    @Override
    public Image makePreviewImage() {
        return image;
    }
}
