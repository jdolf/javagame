/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.input;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import placeholder.screen.TickUpdatable;

/**
 *
 * @author jdolf
 */
public interface InputHandler extends EventHandler<KeyEvent>, TickUpdatable {
    
    Key getKey(KeyCode keyCode);
    
}
