/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.util;

/**
 *
 * @author jdolf
 */
public interface SelectionChooser {
    void up();
    void down();
    void left();
    void right();
    void choose();
    void addSelectionChangedListener(SelectionChangedListener listener);
    void onGridItemsChanged();
}
