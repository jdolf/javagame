package placeholder.game.screen.overlay.contextmenu.entry;

import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;

/**
 *
 * @author jdolf
 */
public class CancelEntry extends ContextMenuEntry {
    
    public static final String DISPLAY_NAME = "Cancel";
    private ContextMenuManager contextMenuManager;

    public CancelEntry(ContextMenuManager contextMenuManager) {
        super(DISPLAY_NAME);
        this.contextMenuManager = contextMenuManager;
    }

    @Override
    public void execute() {
        contextMenuManager.unregisterContextMenu();
    }
    
}
