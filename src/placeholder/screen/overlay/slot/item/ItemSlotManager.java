/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import placeholder.screen.overlay.ScreenItem;
import placeholder.input.InputHandler;
import placeholder.screen.overlay.slot.SelectableSlotManager;

/**
 *
 * @author jdolf
 */
public class ItemSlotManager<T extends ItemSlot> extends SelectableSlotManager<T> {
    
    public ItemSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension, InputHandler input) {
        super(slots, gridPosition, gridDimension, input);
    }
    
    public ItemSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension) {
        super(slots, gridPosition, gridDimension);
    }
    
    
    
}
