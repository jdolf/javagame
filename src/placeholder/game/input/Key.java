/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.input;

import javafx.scene.input.KeyCode;
import placeholder.game.screen.TickUpdatable;

/**
 *
 * @author jdolf
 */
public interface Key extends TickUpdatable {
    void setPressed(boolean state);
    void setActivatedByPress(boolean state);
    void setActivatedByRelease(boolean state);
    boolean isBeingPressed();
    boolean isActivatedByPress();
    boolean isActivatedByRelease();
    int getKeyCode();
    boolean matchesKeyCode(KeyCode keyCode);
}
