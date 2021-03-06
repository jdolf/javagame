/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.util;

import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import placeholder.game.screen.overlay.slot.Selectable;

/**
 *
 * @author jdolf
 */
public class MatrixSelectionChooser implements SelectionChooser {

    private Collection<SelectionChangedListener> listener = new ArrayList();
    protected Selectable[][] itemMatrix;
    protected Point currentSelection = new Point(0, 0);
    
        public MatrixSelectionChooser(List<? extends Selectable> items, int numColumns, int numRows) {
        itemMatrix = new Selectable[numRows][numColumns];
        
        createMatrix(items, numColumns);
        trySelect((int)currentSelection.y, (int)currentSelection.x);
    }
    
    @Override
    public void up() {
        trySelect(-1, 0);
    }

    @Override
    public void down() {
        trySelect(1, 0);
    }

    @Override
    public void left() {
        trySelect(0, -1);
    }

    @Override
    public void right() {
        trySelect(0, 1);
    }
    
    public void trySelect(int relativeRow, int relativeColumn) {
        Selectable target = null;
        
        try {
            target = itemMatrix[((int)currentSelection.y) + relativeRow][((int)currentSelection.x) + relativeColumn];
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Don't bother
        }
        
        if (target != null) {
            currentSelection.y += relativeRow;
            currentSelection.x += relativeColumn;
            unselectAll();
            target.select();
            notifySelectionChangedListeners();
        }
    }
    
    private void unselectAll() {
        for (Selectable[] array : itemMatrix) {
            for (Selectable item : array) {
                if (item != null) {
                    item.unselect();
                }
            }
        }
    }
    
    private void createMatrix(List<? extends Selectable> items, int numColumns) {
        int currentRow = 0;
        int currentColumn = 0;
        
        for (Selectable item : items) {
            itemMatrix[currentRow][currentColumn] = item;
            
            if (currentColumn >= numColumns - 1) {
                currentRow += 1;
                currentColumn = 0;
            } else {
                currentColumn += 1;
            }
        }
    }

    @Override
    public void choose() {
        itemMatrix[((int)currentSelection.y)][((int)currentSelection.x)].choose();
    }
    
    private void notifySelectionChangedListeners() {
        listener.forEach((l) -> {
            l.onSelectionChanged();
        });
    }
    
    public void addSelectionChangedListener(SelectionChangedListener listener) {
        this.listener.add(listener);
    }

    @Override
    public void onGridItemsChanged() {}
    
}
