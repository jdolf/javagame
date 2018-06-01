package placeholder.screen.overlay.window;

import java.awt.Dimension;
import javafx.scene.image.Image;
import placeholder.input.InputHandler;
import placeholder.screen.ImageContainer;
import placeholder.screen.overlay.util.ImageDisplay;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class ImageBackgroundWindow extends Window {
    
    protected ImageDisplay background;
    
    public ImageBackgroundWindow(
            WindowManager manager,
            InputHandler input,
            Dimension gameDimension,
            Dimension barDimension,
            Dimension screenDimension,
            String backgroundPath) {
        super(manager, input, gameDimension, barDimension, screenDimension);
        background = new ImageDisplay(ImageContainer.getInstance().getImage(backgroundPath), this.getPosition(), this.dimension);
    }

    @Override
    public void render(Renderer renderer) {
        background.render(renderer);
    }
    
    
    
}
