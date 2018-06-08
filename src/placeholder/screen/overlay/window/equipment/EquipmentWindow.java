package placeholder.screen.overlay.window.equipment;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.input.InputHandler;
import placeholder.item.equipment.EquipmentManager;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.slot.SelectableSlotManager;
import placeholder.screen.overlay.slot.item.equipment.EquipmentSlot;
import placeholder.screen.overlay.window.ImageBackgroundWindow;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class EquipmentWindow extends ImageBackgroundWindow {
    
    public static final Dimension SCREEN_DIMENSION = new Dimension(500, 350);
    public static final String BACKGROUND_IMAGE = "window_equipment.png";
    public static final Dimension DISPLAY_INIT_MARGIN = new Dimension(70, 90);
    public static final int[][] INVISIBLE_FILLER = {};
    
    private SelectableSlotManager<EquipmentSlot> slotManager;
    private EquipmentManager equipmentManager;
    private ContextMenuManager cm;
    
    public EquipmentWindow(
            ContextMenuManager cm,
            WindowManager manager,
            InputHandler input,
            Dimension gameDimension,
            Dimension barDimension,
            EquipmentManager equipmentManager) {
        super(manager, input, gameDimension, barDimension, SCREEN_DIMENSION, BACKGROUND_IMAGE);
        this.equipmentManager = equipmentManager;
        this.slotManager = new SelectableSlotManager<EquipmentSlot>(
                equipmentManager.getEquipmentSlots(),
                new Point2D.Double(this.getPosition().getX() + DISPLAY_INIT_MARGIN.width, this.getPosition().getY() + DISPLAY_INIT_MARGIN.height),
                this.dimension
        );
        this.cm = cm;
        slotManager.setInputHandler(input);
    }
    
    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        slotManager.render(renderer);
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        if (cm.hasOpenedContextMenu() == false) {
            slotManager.tickUpdate();
        }
    }
    
}
