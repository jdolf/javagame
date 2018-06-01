/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.window;

import placeholder.screen.TickUpdatable;
import placeholder.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public interface WindowManager extends Renderable, TickUpdatable {

    Window getWindow();

    boolean hasWindow();

    void registerWindow(Window window);

    void unregisterWindow();
    
}
