package placeholder.game.screen.overlay.window;

import java.awt.Dimension;
import javafx.scene.image.Image;
import placeholder.game.input.InputHandler;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.util.ImageDisplay;
import placeholder.game.screen.render.Renderer;

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
