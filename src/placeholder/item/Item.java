/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.item;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.geom.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.screen.overlay.contextmenu.entry.ContextMenuEntryCreator;
import placeholder.screen.overlay.contextmenu.entry.DestroyEntry;
import placeholder.screen.render.Renderer;
import placeholder.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public abstract class Item extends ScreenItem implements ContextMenuEntryCreator {
    
    public static final int DEFAULT_AMOUNT = 1;
    public static final Dimension DEFAULT_DIMENSION = new Dimension(32, 32);
    public static final Font AMOUNT_FONT = new Font(8);
    public static final Paint AMOUNT_PAINT = Color.BLACK;
    
    protected Image icon;
    protected int amount;
    protected int maxStack;
    private boolean stackable;
    /**
     * The Inventory this item may reside in.
     */
    protected Inventory inventory;
    
    public Item(Point2D position, Image icon, int maxStack) {
        super(position, DEFAULT_DIMENSION);
        this.icon = icon;
        this.maxStack = maxStack;
        this.amount = DEFAULT_AMOUNT;
        validateMaxStack(maxStack);
        if (maxStack > 1) this.stackable = true;
    }
    
    public Item(Point2D position, Image icon, int maxStack, int amount) {
        super(position, DEFAULT_DIMENSION);
        this.icon = icon;
        this.maxStack = maxStack;
        this.amount = amount;
        validateMaxStack(maxStack);
        if (maxStack > 1) this.stackable = true;
    }
    
    public boolean isStackable() {
        return this.stackable;
    }
    
    /**
     * Fills the amount in case an item wants to stack.
     * @param item The item this item should stack with.
     */
    public void fillAmount(Item item) {
        int space = calculateSpace();
        
        if (this.getClass().equals(item.getClass())) {
            if (space > 0) {
                if (space >= item.getAmount()) {
                    addAmount(item.getAmount());
                    item.removeAmount(item.getAmount());
                } else if (item.getAmount() > space) {
                    addAmount(space);
                    item.removeAmount(space);
                }
            }
        }
        
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void addAmount(int amount) {
        this.amount += amount;
    }
    
    public void removeAmount(int amount) {
        this.amount -= amount;
        if (this.amount <= 0) inventory.removeItem(this);
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    /**
     * Returns the difference of the max possible stack of the item and the
     * current amount of items, yielding the theoretical amount to reach the
     * max stack.
     * @return 
     */
    public int calculateSpace() {
        return maxStack - amount;
    }
    
    private void validateMaxStack(int maxStack1) throws IllegalArgumentException {
        if (maxStack1 <= 0) {
            throw new IllegalArgumentException("maxStack has "
                    + "to be at least 1");
        }
        if (amount > maxStack) throw new IllegalArgumentException("amount "
                + "can't be greater than maxStack");
    }

    public void render(Renderer renderer) {
        renderer.renderImage(icon, this);
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public List<ContextMenuEntry> createContextMenuEntries() {
        List<ContextMenuEntry> entries = new ArrayList();
        entries.add(new DestroyEntry(this.inventory, this));
        return entries;
    }


}
