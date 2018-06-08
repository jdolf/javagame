/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay.window;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.input.InputHandler;
import placeholder.input.Key;

/**
 *
 * @author jdolf
 */
public abstract class Window extends ScreenItem implements Renderable, TickUpdatable {
    
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
    
    private static Dimension calculateScreenDimension(Dimension gameDimension, Dimension barDimension, int widthPercentage, int heightPercentage) {
        int windowWidth = gameDimension.width * widthPercentage / 100;
        int windowHeight = (gameDimension.height - barDimension.height) * heightPercentage / 100;
        return new Dimension(windowWidth, windowHeight);
    }
    
    private static Point2D calculateScreenPosition(Dimension gameDimension, Dimension barDimension, int widthPercentage, int heightPercentage) {
        int windowX = gameDimension.width * (100 - widthPercentage) / 2 / 100;
        int windowY = (gameDimension.height - barDimension.height) * (100 - heightPercentage) / 2 / 100;
        return new Point2D.Double(windowX, windowY);
    }
    
    private static Point2D calculateScreenPosition(Dimension gameDimension, Dimension barDimension, Dimension screenDimension) {
        int windowX = (gameDimension.width - screenDimension.width) / 2;
        int windowY = ((gameDimension.height - barDimension.height) - screenDimension.height) / 2;
        return new Point2D.Double(windowX, windowY);
    }
    
    public Window(WindowManager manager, InputHandler input, Dimension gameDimension, Dimension barDimension) {
        super(calculateScreenPosition(gameDimension, barDimension, DEFAULT_WIDTH_PERCENT, DEFAULT_HEIGHT_PERCENT),
                calculateScreenDimension(gameDimension, barDimension, DEFAULT_WIDTH_PERCENT, DEFAULT_HEIGHT_PERCENT));
        this.windowManager = manager;
        this.input = input;
        this.initialized = true;
    }
    
    public Window(WindowManager manager, InputHandler input, Dimension gameDimension, Dimension barDimension, int widthPercentage, int heightPercentage) {
        super(calculateScreenPosition(gameDimension, barDimension, widthPercentage, heightPercentage),
                calculateScreenDimension(gameDimension, barDimension, widthPercentage, heightPercentage));
        this.windowManager = manager;
        this.input = input;
        this.initialized = true;
    }
    
    public Window(WindowManager manager, InputHandler input, Dimension gameDimension, Dimension barDimension, Dimension screenDimension) {
        super(calculateScreenPosition(gameDimension, barDimension, screenDimension), screenDimension);
        this.windowManager = manager;
        this.input = input;
        this.initialized = true;
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
