/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay;

import java.util.HashSet;
import java.util.Set;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class OverlayManager implements Renderable, TickUpdatable {
    
    private Set<Overlay> overlayItems = new HashSet<Overlay>();
    private boolean toggledOn = true;

    public void addOverlay(Overlay overlay) {
        overlayItems.add(overlay);
    }

    @Override
    public void render(Renderer renderer) {
        for (Overlay overlay : overlayItems) {
            overlay.render(renderer);
        }
    }

    @Override
    public void tickUpdate() {
        for (Overlay overlay : overlayItems) {
            overlay.tickUpdate();
        }
    }

    public void setToggledOn(boolean state) {
        this.toggledOn = state;
    }

    public boolean isToggledOn() {
        return this.toggledOn;
    }
    
}
