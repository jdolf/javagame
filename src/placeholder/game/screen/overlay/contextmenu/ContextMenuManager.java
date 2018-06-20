/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.contextmenu;

import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.input.InputHandler;

/**
 *
 * @author jdolf
 */
public class ContextMenuManager implements Renderable, TickUpdatable {
    
    protected ContextMenu openedContextMenu;
    protected InputHandler input;
    
    public ContextMenuManager(InputHandler inputHandler) {
        this.input = inputHandler;
    }

    public void registerContextMenu(ContextMenu menu) {
        this.openedContextMenu = menu;
        menu.getSlotManager().setInputHandler(input);
    }

    public void render(Renderer renderer) {
        openedContextMenu.render(renderer);
    }

    public void tickUpdate() {
        openedContextMenu.tickUpdate();
    }

    public boolean hasOpenedContextMenu() {
        if (openedContextMenu == null) {
            return false;
        } else {
            return true;
        }
    }

    public void unregisterContextMenu() {
        this.openedContextMenu = null;
    }
    
}
