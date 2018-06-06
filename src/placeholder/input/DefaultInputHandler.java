/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author jdolf
 */
public class DefaultInputHandler implements InputHandler {
    
    Key[] keys = new Key[] {
        new DefaultKey(KeyCode.DOWN),
        new DefaultKey(KeyCode.UP),
        new DefaultKey(KeyCode.LEFT),
        new DefaultKey(KeyCode.RIGHT),
        new DefaultKey(KeyCode.R),
        new DefaultKey(KeyCode.ESCAPE),
        new DefaultKey(KeyCode.SPACE),
        new DefaultKey(KeyCode.T),
        new DefaultKey(KeyCode.E),
        new DefaultKey(KeyCode.F)
    };

    @Override
    public void handle(KeyEvent event) {
        
        Key targetKey = null;
        boolean newState = false;
        
        for (Key key : keys) {
            if (key.matchesKeyCode(event.getCode())) {
                targetKey = key;
            }
        }
        
        if (targetKey != null) {
            if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                newState = true;
                targetKey.setActivatedByPress(true);
            } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                newState = false;
                targetKey.setActivatedByRelease(true);
            }

            targetKey.setPressed(newState);
        } 
        
    }

    @Override
    public Key getKey(KeyCode keyCode) {
        for (Key key : keys) {
            if (key.matchesKeyCode(keyCode)) {
                return key;
            }
        }
        
        throw new IllegalArgumentException("KeyCode not found or implemented yet");
    }

    @Override
    public void tickUpdate() {
        for (Key key : keys) {
            key.tickUpdate();
        }
    }
    
    
    
}
