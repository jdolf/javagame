/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot;

import javafx.scene.paint.Color;
import placeholder.screen.overlay.contextmenu.ContextMenu;
import placeholder.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class ContextMenuEntrySlot extends SelectableSlot {

    protected ContextMenu parent;
    protected ContextMenuEntry entry;
    
    public ContextMenuEntrySlot(ContextMenu parent, ContextMenuEntry entry) {
        super(entry.getDimension());
        this.entry = entry;
        this.parent = parent;
    }

    @Override
    public void executeCommand() {
        entry.execute();
    }

    @Override
    public void choose() {
        executeCommand();
        parent.close();
    }

    @Override
    public void render(Renderer renderer) {
        if (this.selected) {
            renderer.renderRect(Color.AQUA, entry);
        } else {
            renderer.renderRect(Color.GREY, entry);
        }
        entry.render(renderer);
    }

    
    
    
    
}
