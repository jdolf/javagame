/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.contextmenu;

import placeholder.game.util.Point;
import java.util.Collection;
import java.util.List;
import placeholder.game.screen.overlay.contextmenu.entry.ContextMenuEntry;

/**
 *
 * @author jdolf
 */
public class StandardContextMenu extends ContextMenu {
    
    public StandardContextMenu(ContextMenuManager contextManager, List<ContextMenuEntry> entries, Point position) {
        super(contextManager, entries, position);
    }
    
}
