/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.slot.item;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;
import placeholder.screen.render.Renderer;
import placeholder.item.Item;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.contextmenu.ContextMenu;
import placeholder.screen.overlay.slot.SelectableSlot;

/**
 *
 * @author jdolf
 */
public abstract class ItemSlot<T extends Item> extends SelectableSlot {
    
    public static final Dimension DEFAULT_ITEM_MARGIN = new Dimension(8, 8);
    public static final Dimension DEFAULT_DIMENSION = new Dimension(48, 48);

    private T item;
    protected Dimension itemMargin;

    public ItemSlot() {
        super(DEFAULT_DIMENSION);
        this.itemMargin = DEFAULT_ITEM_MARGIN;
    }
    
    protected abstract ContextMenu createContextMenu();

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
            getItem().render(renderer);
        }
    }

    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
        // Update item position if an item exists in this slot
        if (!this.isEmpty()) {
            setItemPosition();
        }
    }
    
    private void setItemPosition() {
        item.setPosition(ScreenItem.merge(itemMargin, this.getPosition()));
    }
    
}
