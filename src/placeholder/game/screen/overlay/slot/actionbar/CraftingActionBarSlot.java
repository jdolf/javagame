package placeholder.game.screen.overlay.slot.actionbar;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import placeholder.game.input.InputHandler;
import placeholder.game.input.Key;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.window.Window;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.screen.overlay.window.crafting.CraftingWindow;
import placeholder.game.sprite.entity.player.Player;

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
