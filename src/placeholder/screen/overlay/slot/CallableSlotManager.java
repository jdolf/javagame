/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot;

import java.awt.Dimension;
import java.awt.Point;
import placeholder.screen.overlay.slot.actionbar.ActionBarSlot;
import java.util.List;
import placeholder.screen.overlay.ScreenItem;
import placeholder.input.InputHandler;
import placeholder.screen.TickUpdatable;

/**
 *
 * @author jdolf
 */
public class CallableSlotManager extends DefaultSlotManager<ActionBarSlot> implements TickUpdatable {
    
    public static final Dimension DEFAULT_SLOT_MARGIN = new Dimension(20, 10);
    protected InputHandler input;
    
    public CallableSlotManager(List<ActionBarSlot> slots, Point gridPosition, Dimension gridDimension, InputHandler input) {
        super(slots, gridPosition, gridDimension, DEFAULT_SLOT_MARGIN);
        this.input = input;
    }

    @Override
    public void tickUpdate() {
        this.grid.getItems().forEach((t) -> {
            if (t.isCalled()) {
                t.executeCommand();
            }
        });
    }
    
}
