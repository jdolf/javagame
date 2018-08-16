/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.actionbar;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import placeholder.game.screen.overlay.Overlay;
import placeholder.game.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.game.screen.overlay.slot.actionbar.ActionBarSlot;
import placeholder.game.screen.overlay.slot.CallableSlotManager;
import placeholder.game.screen.overlay.slot.actionbar.InventoryActionBarSlot;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.screen.render.Renderer;
import placeholder.game.input.InputHandler;
import placeholder.game.screen.overlay.SizeChangeListener;
import placeholder.game.screen.overlay.slot.actionbar.CraftingActionBarSlot;
import placeholder.game.screen.overlay.slot.actionbar.EquipmentActionBarSlot;
import placeholder.game.screen.overlay.slot.actionbar.SkillsActionBarSlot;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class ActionBar extends Overlay implements SizeChangeListener {
    
    public static final int DEFAULT_HEIGHT = 50;
    public static final Paint DEFAULT_PAINT = Color.CORNSILK;
    
    private Paint paintColor = DEFAULT_PAINT;
    private InputHandler inputHandler;
    private CallableSlotManager slotManager;
    private Player player;
    private Point gamePosition;
    
    public ActionBar (
            WindowManager windowManager,
            ContextMenuManager contextManager,
            InputHandler inputHandler,
            Dimension gameDimension,
            Point gamePosition,
            Player player) {
        super(new Dimension(gameDimension.width, DEFAULT_HEIGHT));
        calculatePosition(gameDimension, gamePosition, DEFAULT_HEIGHT);
        gameDimension.addSizeChangeListener(this);
        this.inputHandler = inputHandler;
        this.player = player;
        this.gamePosition = gamePosition;
        List<ActionBarSlot> slots = new ArrayList<>();
        slots.add(new InventoryActionBarSlot(inputHandler, contextManager, windowManager, gameDimension, this.dimension, player.getInventory()));
        slots.add(new SkillsActionBarSlot(player.getSkillManager(), windowManager, inputHandler, gameDimension, this.dimension));
        slots.add(new EquipmentActionBarSlot(inputHandler, contextManager, windowManager, gameDimension, this.dimension, player.getPlayerEquipmentManager()));
        slots.add(new CraftingActionBarSlot(inputHandler, contextManager, windowManager, gameDimension, dimension, player));
        slotManager = new CallableSlotManager(slots, this.getPosition(), this.dimension, inputHandler);
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderRect(paintColor, this);
        slotManager.render(renderer);
    }
    
    public void calculatePosition(Dimension gameDimension, Point gamePosition, int barHeight) {
        double x = gamePosition.getX();
        double y = gamePosition.getY() + (gameDimension.height - barHeight);
        this.getPosition().setLocation(x, y);
    }

    @Override
    public void tickUpdate() {
        slotManager.tickUpdate();
    }

    @Override
    public void onSizeChanged(Dimension dimension) {
        calculatePosition(dimension, gamePosition, DEFAULT_HEIGHT);
        this.dimension = new Dimension(dimension.width, DEFAULT_HEIGHT);
    }
    
}
