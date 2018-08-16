/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay.window;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.input.InputHandler;
import placeholder.game.input.Key;
import placeholder.game.screen.overlay.Overlay;

/**
 *
 * @author jdolf
 */
public abstract class Window extends Overlay implements Renderable, TickUpdatable {
    
    public static final int DEFAULT_WIDTH_PERCENT = 75;
    public static final int DEFAULT_HEIGHT_PERCENT = 60;
    public static final Paint DEFAULT_PAINT = Color.GREY;
    public static final Paint DEFAULT_BORDER_PAINT = Color.LIGHTGRAY;
    public static final Dimension DEFAULT_BORDER_ARC_DIMENSION = new Dimension(5, 5);
    public static final int DEFAULT_BORDER_THICKNESS = 2;
    
    protected boolean initialized = false;
    protected boolean open = false;
    protected boolean ready = false;
    private boolean closeWindow = false;
    protected InputHandler input;
    protected WindowManager windowManager;
    private Dimension gameDimension;
    private Dimension barDimension;
    private Dimension specificScreenDimension;
    
    private static Point calculateScreenPosition(Dimension gameDimension, Dimension barDimension, Dimension screenDimension) {
        int windowX = (gameDimension.width - screenDimension.width) / 2;
        int windowY = ((gameDimension.height - barDimension.height) - screenDimension.height) / 2;
        return new Point(windowX, windowY);
    }
    
    public void recalculateMeasurements() {
        Point newPosition = calculateScreenPosition(gameDimension, barDimension, specificScreenDimension);
        this.getPosition().setLocation(newPosition);
    }
    
    public Window(WindowManager manager, InputHandler input, Dimension gameDimension, Dimension barDimension, Dimension screenDimension) {
        super(calculateScreenPosition(gameDimension, barDimension, screenDimension), screenDimension);
        this.windowManager = manager;
        this.input = input;
        this.initialized = true;
        this.gameDimension = gameDimension;
        this.barDimension = barDimension;
        this.specificScreenDimension = screenDimension;
    }

    public void open() {
        this.open = true;
        windowManager.registerWindow(this);
        this.closeWindow = false;
    }

    public void close() {
        this.closeWindow = true;
        ready = false;
        open = false;
    }

    @Override
    public void tickUpdate() {
        if (closeWindow == true && ready == false) {
            windowManager.unregisterWindow();
        } else if (this.ready) {
            if (input.getKey(KeyCode.ESCAPE).isBeingPressed()) {
                this.close();
            }
        } else {
            this.ready = true;
        }
    }

    @Override
    public void render(Renderer renderer) {
        System.out.println(this.getPosition());
        renderer.renderRoundRect(DEFAULT_PAINT, DEFAULT_BORDER_ARC_DIMENSION, this);
        renderer.renderRoundRectStroke(DEFAULT_BORDER_PAINT, DEFAULT_BORDER_THICKNESS, DEFAULT_BORDER_ARC_DIMENSION, this);
    }

    public boolean isOpened() {
        return this.open;
    }

    public boolean isReady() {
        return this.ready;
    }
    
    
    
}
