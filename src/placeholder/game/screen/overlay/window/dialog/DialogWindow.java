package placeholder.game.screen.overlay.window.dialog;

import placeholder.game.util.Dimension;
import placeholder.game.input.InputHandler;
import placeholder.game.screen.overlay.window.Window;
import placeholder.game.screen.overlay.window.WindowManager;

/**
 * Displays conversations.
 * @author jdolf
 */
public class DialogWindow extends Window {
    
    public static final Dimension DIMENSION = new Dimension(500, 350);
    
    private Player player;
    
    public DialogWindow(WindowManager manager, InputHandler input, Dimension gameDimension, Dimension barDimension) {
        super(manager, input, gameDimension, barDimension, DIMENSION);
    }
    
}
