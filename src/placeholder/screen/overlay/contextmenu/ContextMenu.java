/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.contextmenu;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.contextmenu.entry.ContextMenuEntry;
import placeholder.screen.overlay.slot.ContextMenuEntrySlot;
import placeholder.screen.overlay.slot.SelectableSlotManager;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public abstract class ContextMenu extends ScreenItem implements Renderable, TickUpdatable {
    
    private boolean ready = false;
    private Dimension dimension;
    protected SelectableSlotManager<ContextMenuEntrySlot> slotManager;
    protected ContextMenuManager contextManager;
    
    public ContextMenu(ContextMenuManager contextManager, List<ContextMenuEntry> entries, Point position) {
        super(position, calculateDimension(entries));
        // Reverse the order of entries; most specific entries come first
        Collections.reverse(entries);
        // Create slots
        List<ContextMenuEntrySlot> slots = createSlots(entries);
        slotManager = new SelectableSlotManager(slots, this.getPosition(), this.dimension, slots.size(), 1);
        this.contextManager = contextManager;
        setEntriesPosition(entries, this.getPosition());
    }
    
    public static Dimension calculateDimension(List<ContextMenuEntry> entries) {
        Dimension newDimension = new Dimension(0, 0);
        
        for (ContextMenuEntry entry : entries) {
            newDimension.height += entry.getDimension().height;
        }
        
        return newDimension;
    }
    
    public static void setEntriesPosition(List<ContextMenuEntry> entries, Point contextMenuPosition) {
        for (int i = 0; i < entries.size(); i++) {
            Point position = new Point();
            ContextMenuEntry target = entries.get(i);
            position.x = contextMenuPosition.x;
            position.y = contextMenuPosition.y + i * target.getDimension().height;
            target.setPosition(position);
        }
    }
    
    private List<ContextMenuEntrySlot> createSlots(List<ContextMenuEntry> entries) {
        List<ContextMenuEntrySlot> slots = new ArrayList();
        for (ContextMenuEntry entry : entries) {
            slots.add(new ContextMenuEntrySlot(this, entry));
        }
        return slots;
    }

    @Override
    public void render(Renderer renderer) {
        slotManager.render(renderer);
    }

    @Override
    public void tickUpdate() {
        if (this.ready) {
            slotManager.tickUpdate();
        } else {
            this.ready = true;
        }
    }

    public SelectableSlotManager getSlotManager() {
        return this.slotManager;
    }

    public void open() {
        contextManager.registerContextMenu(this);
    }

    public void close() {
        contextManager.unregisterContextMenu();
    }

    public boolean isReady() {
        return this.ready;
    }

}
