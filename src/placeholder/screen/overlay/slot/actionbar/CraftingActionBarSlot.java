package placeholder.screen.overlay.slot.actionbar;

import java.awt.Dimension;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import placeholder.input.InputHandler;
import placeholder.input.Key;
import placeholder.screen.ImageContainer;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.window.Window;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.overlay.window.crafting.CraftingWindow;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class CraftingActionBarSlot extends ActionBarSlot {
    
    public static final String ICON_NAME = "crafting_slot.png";
    
    public CraftingActionBarSlot(
            InputHandler inputHandler,
            ContextMenuManager contextManager,
            WindowManager windowManager,
            Dimension gameDimension,
            Dimension barDimension,
            Player player) {
        super(
                new CraftingWindow(
                        windowManager,
                        inputHandler,
                        gameDimension,
                        barDimension,
                        player,
                        contextManager),
                inputHandler,
                inputHandler.getKey(KeyCode.Q),
                ImageContainer.getInstance().getImage(ICON_NAME)
        );
    }
    
}
