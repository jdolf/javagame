/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.actionbar;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import placeholder.screen.overlay.Overlay;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.slot.actionbar.ActionBarSlot;
import placeholder.screen.overlay.slot.CallableSlotManager;
import placeholder.screen.overlay.slot.actionbar.InventoryActionBarSlot;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.render.Renderer;
import placeholder.input.InputHandler;
import placeholder.screen.overlay.slot.actionbar.EquipmentActionBarSlot;
import placeholder.screen.overlay.slot.actionbar.SkillsActionBarSlot;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class ActionBar extends Overlay {
    
    public static final int DEFAULT_HEIGHT = 50;
    public static final Paint DEFAULT_PAINT = Color.CORNSILK;
    
    private Paint paintColor = DEFAULT_PAINT;
    private InputHandler inputHandler;
    private CallableSlotManager slotManager;
    private Player player;
    
    public ActionBar (
            WindowManager windowManager,
            ContextMenuManager contextManager,
            InputHandler inputHandler,
            Dimension gameDimension,
            Point2D gamePosition,
            Player player) {
        super(calculatePosition(gameDimension, gamePosition, DEFAULT_HEIGHT), new Dimension(gameDimension.width, DEFAULT_HEIGHT));
        this.inputHandler = inputHandler;
        this.player = player;
        List<ActionBarSlot> slots = new ArrayList<>();
        slots.add(new InventoryActionBarSlot(inputHandler, contextManager, windowManager, gameDimension, this.dimension, player.getInventory()));
        slots.add(new SkillsActionBarSlot(player.getSkillManager(), windowManager, inputHandler, gameDimension, this.dimension));
        slots.add(new EquipmentActionBarSlot(inputHandler, contextManager, windowManager, gameDimension, this.dimension, player.getPlayerEquipmentManager()));
        slotManager = new CallableSlotManager(slots, this.getPosition(), this.dimension, inputHandler);
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderRect(paintColor, this);
        slotManager.render(renderer);
    }
    
    public static Point2D calculatePosition(Dimension gameDimension, Point2D gamePosition, int barHeight) {
        double x = gamePosition.getX();
        double y = gamePosition.getY() + (gameDimension.height - barHeight);
        return new Point2D.Double(x, y);
    }

    @Override
    public void tickUpdate() {
        slotManager.tickUpdate();
    }
    
}
