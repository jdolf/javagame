/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item;

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
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.game.screen.overlay.contextmenu.entry.ContextMenuEntryCreator;
import placeholder.game.screen.overlay.contextmenu.entry.DestroyEntry;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.player.inventory.Inventory;

/**
 *
 * @author jdolf
 */
public class Item extends ScreenItem implements ContextMenuEntryCreator {
    
    public static final int DEFAULT_AMOUNT = 1;
    public static final Dimension DEFAULT_DIMENSION = new Dimension(32, 32);
    public static final Font AMOUNT_FONT = new Font(10);
    public static final Paint AMOUNT_PAINT = Color.BLACK;
    
    private Point2D amountTextPosition;
    protected Image icon;
    private int amount;
    private int maxStack;
    private boolean stackable;
    private boolean renderAmountText = true;
    protected String displayName = "Unknown";
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
    
    public Item(Item item) {
        super(item.getPosition(), item.getDimension());
        this.icon = item.icon;
        this.amount = item.amount;
        this.maxStack = item.maxStack;
        this.stackable = item.stackable;
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
        onAmountChanged();
    }
    
    public void addAmount(int amount) {
        this.amount += amount;
        onAmountChanged();
    }
    
    /**
     * Removes A certain quantity of this item.
     * @param amount
     * @return The removed amount.
     */
    public int removeAmount(int amount) {
        int removedAmount = 0;
        
        if (this.amount - amount < 0) {
            removedAmount = this.amount;
            this.amount = 0;
        } else {
            removedAmount = amount;
            this.amount -= amount;
        }
        
        onAmountChanged();
        return removedAmount;
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

    }

    public void render(Renderer renderer) {
        renderer.renderImage(icon, this);
        renderText(renderer);
    }
    
    public void renderAtScreenItem(Renderer renderer, ScreenItem si) {
        renderer.renderImage(icon, si);
        if (renderAmountText) {
            renderText(renderer);
        }
    }
    
    private void renderText(Renderer renderer) {
        if (this.amount > 1) {
            renderer.renderText(Item.AMOUNT_PAINT,
                    Item.AMOUNT_FONT,
                    String.valueOf(amount),
                    new ScreenItem(amountTextPosition, this.dimension),
                    TextAlignment.RIGHT);
        }
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
    
    private void calculateAmountTextPosition() {
        this.amountTextPosition = new Point2D.Double(dimension.width + this.getPosition().getX() + 3, this.getPosition().getY() - 3);
    }

    @Override
    public void setPosition(Point2D position) {
        super.setPosition(position);
        if (dimension != null) {
            if (renderAmountText) {
                calculateAmountTextPosition();
            }
        }
    }

    public void setMaxStack(int maxStack) {
        validateMaxStack(maxStack);
        if (maxStack > 1) this.stackable = true;
        this.maxStack = maxStack;
    }
    
    protected void onAmountChanged() {
        if (this.amount <= 0) {
            if (inventory != null) {
                inventory.removeItem(this);
            }
        }
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public void setRenderAmountText(boolean state) {
        this.renderAmountText = state;
    }


}
