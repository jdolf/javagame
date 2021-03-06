/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot.actionbar;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import placeholder.game.screen.overlay.window.Window;
import placeholder.game.screen.render.Renderer;
import placeholder.game.input.InputHandler;
import placeholder.game.input.Key;
import placeholder.game.screen.overlay.slot.Slot;

/**
 *
 * @author jdolf
 */
public abstract class ActionBarSlot extends Slot {

    public static final Dimension DEFAULT_DIMENSION = new Dimension(32, 32);
    protected Window window;
    protected InputHandler input;
    protected Key requiredKey;
    protected Image image;
    private boolean ready = false;
    
    public ActionBarSlot(Window window, InputHandler inputHandler, Key requiredKey, Image image) {
        super(DEFAULT_DIMENSION);
        this.input = inputHandler;
        this.requiredKey = requiredKey;
        this.window = window;
        this.image = image;
    }
    
    public boolean isCalled() {
        return this.requiredKey.isActivatedByPress();
    }

    @Override
    public void executeCommand() {
        if (this.window.isOpened()) {
            this.window.close();
        } else {
            this.window.open();
        }
    }

    public Window getWindow() {
        return window;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderImage(image, this);
    }
    
    
    
    
    
}
