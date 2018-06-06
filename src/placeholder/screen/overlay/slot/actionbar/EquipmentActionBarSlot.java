package placeholder.screen.overlay.slot.actionbar;

import java.awt.Dimension;
import javafx.scene.input.KeyCode;
import placeholder.input.InputHandler;
import placeholder.item.equipment.EquipmentManager;
import placeholder.screen.ImageContainer;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import static placeholder.screen.overlay.slot.actionbar.InventoryActionBarSlot.ICON_NAME;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.overlay.window.equipment.EquipmentWindow;

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
                inputHandler.getKey(KeyCode.F),
                ImageContainer.getInstance().getImage(ICON_NAME)
        );
    }
    
}
