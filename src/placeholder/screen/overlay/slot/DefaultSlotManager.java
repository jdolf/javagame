/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.util.Grid;

/**
 *
 * @author jdolf
 */
public abstract class DefaultSlotManager<T extends Slot> implements Renderable {
    
    public static final Dimension DEFAULT_SLOT_MARGIN = new Dimension(20, 20);
    
    protected Grid<T> grid;
    protected Dimension slotMargin;
    
    public DefaultSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension) {
        this.slotMargin = DEFAULT_SLOT_MARGIN;
        this.grid = new Grid<>(slots, slotMargin, gridPosition, gridDimension);
    }
    
    public DefaultSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension, int rows, int columns) {
        this.slotMargin = DEFAULT_SLOT_MARGIN;
        this.grid = new Grid<>(slots, rows, columns, slotMargin, gridPosition, gridDimension);
    }
    
    public DefaultSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension, Dimension slotMargin) {
        this.slotMargin = slotMargin;
        this.grid = new Grid<>(slots, slotMargin, gridPosition, gridDimension);
    }
    
    public DefaultSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension, int rows, int columns, Dimension slotMargin) {
        this.slotMargin = slotMargin;
        this.grid = new Grid<>(slots, rows, columns, slotMargin, gridPosition, gridDimension);
    }
    
    @Override
    public void render(Renderer renderer) {
        grid.render(renderer);
    }
    
}
