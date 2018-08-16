/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.window;

import placeholder.game.util.Dimension;
import placeholder.game.screen.overlay.SizeChangeListener;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class DefaultWindowManager implements WindowManager, SizeChangeListener {
    
    private Window window;
    
    public DefaultWindowManager(Dimension dimension) {
        dimension.addSizeChangeListener(this);
    }

    @Override
    public Window getWindow() {
        return this.window;
    }

    @Override
    public boolean hasWindow() {
        if (this.window == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void registerWindow(Window window) {
        if (this.window != null) this.window.close();
        this.window = window;
    }

    @Override
    public void unregisterWindow() {
        this.window = null;
    }

    @Override
    public void render(Renderer renderer) {
        window.render(renderer);
    }

    @Override
    public void tickUpdate() {
        window.tickUpdate();
    }

    @Override
    public void onSizeChanged(Dimension dimension) {
        if (hasWindow()) {
            window.recalculateMeasurements();
        }
    }


}
