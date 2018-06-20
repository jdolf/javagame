/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.input;

import javafx.scene.input.KeyCode;

/**
 *
 * @author jdolf
 */
public class DefaultKey implements Key {
    
    private KeyCode keyCode;
    private boolean pressed = false;
    private boolean activatedByPress = false;
    private boolean activatedByRelease = false;
    
    public DefaultKey(KeyCode keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public void setPressed(boolean state) {
        this.pressed = state;
    }

    @Override
    public boolean isBeingPressed() {
        return this.pressed;
    }

    @Override
    public int getKeyCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean matchesKeyCode(KeyCode keyCode) {
        return this.keyCode.equals(keyCode);
    }

    @Override
    public boolean isActivatedByPress() {
        return this.activatedByPress;
    }

    @Override
    public boolean isActivatedByRelease() {
        return this.activatedByRelease;
    }

    @Override
    public void tickUpdate() {
        activatedByPress = false;
        activatedByRelease = false;
    }

    @Override
    public void setActivatedByPress(boolean state) {
        this.activatedByPress = state;
    }

    @Override
    public void setActivatedByRelease(boolean state) {
        this.activatedByRelease = state;
    }
    
}
