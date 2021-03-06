/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.List;
import javafx.scene.input.KeyCode;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.input.InputHandler;
import placeholder.game.util.MatrixSelectionChooser;
import placeholder.game.util.SelectionChooser;

/**
 *
 * @author jdolf
 */
public class SelectableSlotManager<T extends SelectableSlot> extends DefaultSlotManager<T> implements TickUpdatable {
    
    protected SelectionChooser chooser;
    protected InputHandler input;
    protected WindowManager manager;

    public SelectableSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension, InputHandler input) {
        super(slots, gridPosition, gridDimension);
        chooser = new MatrixSelectionChooser(grid.getItems(), grid.getColumns(), grid.getRows());
        this.input = input;
    }
    
    public SelectableSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension) {
        super(slots, gridPosition, gridDimension);
        chooser = new MatrixSelectionChooser(grid.getItems(), grid.getColumns(), grid.getRows());
    }
    
    public SelectableSlotManager(List<T> slots, Point gridPosition, Dimension gridDimension, int rows, int columns) {
        super(slots, gridPosition, gridDimension, rows, columns);
        chooser = new MatrixSelectionChooser(grid.getItems(), grid.getColumns(), grid.getRows());
    }

    @Override
    public void tickUpdate() {
            if (input.getKey(KeyCode.UP).isActivatedByPress()) chooser.up();
            if (input.getKey(KeyCode.DOWN).isActivatedByPress()) chooser.down();
            if (input.getKey(KeyCode.LEFT).isActivatedByPress()) chooser.left();
            if (input.getKey(KeyCode.RIGHT).isActivatedByPress()) chooser.right();
            if (input.getKey(KeyCode.SPACE).isActivatedByPress()) chooser.choose();
    }
    
    public void setInputHandler(InputHandler input) {
        this.input = input;
    }
    
    public SelectionChooser getSelectionChooser() {
        return chooser;
    }

    @Override
    public void updateGrid(List<T> slots) {
        super.updateGrid(slots);
        chooser = new MatrixSelectionChooser(slots, grid.getColumns(), grid.getRows());
    }
    
    
    
    
    
}
