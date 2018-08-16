package placeholder.game.screen.overlay.slot.actionbar;

import placeholder.game.util.Dimension;
import javafx.scene.input.KeyCode;
import placeholder.game.input.InputHandler;
import placeholder.game.item.equipment.EquipmentManager;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import static placeholder.game.screen.overlay.slot.actionbar.InventoryActionBarSlot.ICON_NAME;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.screen.overlay.window.equipment.EquipmentWindow;

/**
 *
 * @author jdolf
 */
public class EquipmentActionBarSlot extends ActionBarSlot {
    
    public static final String ICON_NAME = "equipment_slot.png";
    
    public EquipmentActionBarSlot(
            InputHandler inputHandler,
            ContextMenuManager contextManager,
            WindowManager windowManager,
            Dimension gameDimension,
            Dimension barDimension,
            EquipmentManager equipmentManager) {
        super(new EquipmentWindow(contextManager, windowManager, inputHandler, gameDimension, barDimension, equipmentManager),
                inputHandler,
                inputHandler.getKey(KeyCode.R),
                ImageContainer.getInstance().getImage(ICON_NAME)
        );
    }
    
}
