/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot;

import java.awt.Dimension;

/**
 *
 * @author jdolf
 */
public abstract class SelectableSlot extends Slot implements Selectable {
    
    public static final String ICON_NAME_SELECTED = "selected_slot.png";
    public static final String ICON_NAME_UNSELECTED = "regular_slot.png";
    
    protected boolean selected = false;

    public SelectableSlot(Dimension dimension) {
        super(dimension);
    }

    @Override
    public void select() {
        this.selected = true;
    }

    @Override
    public void unselect() {
        this.selected = false;
    }
    
}
