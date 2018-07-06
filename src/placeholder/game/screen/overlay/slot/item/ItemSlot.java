/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.slot.item;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.text.TextAlignment;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.render.Renderer;
import placeholder.game.item.Item;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.overlay.contextmenu.ContextMenu;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.contextmenu.StandardContextMenu;
import placeholder.game.screen.overlay.contextmenu.entry.CancelEntry;
import placeholder.game.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.game.screen.overlay.slot.SelectableSlot;

/**
 *
 * @author jdolf
 */
public abstract class ItemSlot<T extends Item> extends SelectableSlot {
    
    public static final Dimension DEFAULT_ITEM_MARGIN = new Dimension(8, 8);
    public static final Dimension DEFAULT_DIMENSION = new Dimension(48, 48);

    private T item;
    protected Dimension itemMargin;
    private ContextMenuManager contextMenuManager;

    public ItemSlot(ContextMenuManager manager) {
        super(DEFAULT_DIMENSION);
        this.itemMargin = DEFAULT_ITEM_MARGIN;
        this.contextMenuManager = manager;
    }
    
    protected ContextMenu createContextMenu() {
        List<ContextMenuEntry> entries = createContextMenuEntries();
        if (entries != null) {
            entries.add(0, new CancelEntry(contextMenuManager));
            return new StandardContextMenu(contextMenuManager, entries, this.getPosition());
        } else {
            return null;
        }
    }
    
    protected abstract List<ContextMenuEntry> createContextMenuEntries();

    @Override
    public void executeCommand() {
        ContextMenu menu = createContextMenu();
        
        if (menu != null) {
            menu.open();
        }
    }

    public void setItem(T t) {
        this.item = t;
        if (this.hasPositionAndDimension()) {
            setItemPosition();
        }
    }
    
    public void removeItem() {
        this.item = null;
    }

    public T getItem() {
        return this.item;
    }

    public boolean isEmpty() {
        if (this.item == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void render(Renderer renderer) {
        Image image;
        
        if (selected) {
            image = ImageContainer.getInstance().getImage(ICON_NAME_SELECTED);
        } else {
            image = ImageContainer.getInstance().getImage(ICON_NAME_UNSELECTED);
        }
        
        renderer.renderImage(image, this);
        
        if (getItem() != null) {
            renderItem(renderer);
        }
    }
    
    protected void renderItem(Renderer renderer) {
        getItem().render(renderer);
    }

    @Override
    public void setPosition(Point2D position) {
        super.setPosition(position);
        // Update item position if an item exists in this slot
        if (!this.isEmpty()) {
            setItemPosition();
        }
    }
    
    private void setItemPosition() {
        item.setPosition(ScreenItem.merge(itemMargin, this.getPosition()));
    }

    @Override
    public void choose() {
        executeCommand();
    }
    
    
    
}
