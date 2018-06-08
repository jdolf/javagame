/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import placeholder.screen.ImageContainer;
import placeholder.map.MapManager;
import placeholder.screen.overlay.Overlay;
import placeholder.screen.overlay.OverlayManager;
import placeholder.screen.overlay.actionbar.ActionBar;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.window.DefaultWindowManager;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.render.CameraOrientedRenderer;
import placeholder.screen.render.OverlayRenderer;
import placeholder.screen.render.Renderer;
import placeholder.input.DefaultInputHandler;
import placeholder.input.InputHandler;
import placeholder.item.equipment.EquipmentManager;
import placeholder.sprite.entity.player.AbuPlayer;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class Placeholder extends Application {
    
    public final static int WIDTH = 700;
    public final static int HEIGHT = 500;
    public static final Point2D DEFAULT_POSITION = new Point2D.Double(0, 0);
    public static final Dimension DEFAULT_DIMENSION = new Dimension(700, 500);
    
    private Player player;
    private WindowManager windowManager;
    private ContextMenuManager contextManager;
    private MapManager mapManager;
    private OverlayManager overlayManager;
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        InputHandler inputHandler = new DefaultInputHandler();
        scene.setOnKeyPressed(inputHandler);
        scene.setOnKeyReleased(inputHandler);
        
        // TODO: initialization class
        System.out.println("Loading images...");
        long startTime = System.currentTimeMillis();
        if (ImageContainer.initialize()) {
            long endTime = System.currentTimeMillis();
            System.out.println("Done loading images... Time (ms): " + (endTime - startTime));
        }
        
        Renderer mapRenderer = new CameraOrientedRenderer(canvas.getGraphicsContext2D(), DEFAULT_DIMENSION);
        Renderer overlayRenderer = new OverlayRenderer(canvas.getGraphicsContext2D(), DEFAULT_DIMENSION);
        
        contextManager = new ContextMenuManager(inputHandler);
        windowManager = new DefaultWindowManager();
        player = new AbuPlayer(inputHandler, windowManager, contextManager);
        mapManager = new MapManager(player);
        overlayManager = new OverlayManager();
        
        Overlay actionBar = new ActionBar(windowManager, contextManager, inputHandler, DEFAULT_DIMENSION, DEFAULT_POSITION, player);
        overlayManager.addOverlay(actionBar);
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                mapRenderer.clear();
                overlayRenderer.clear();
                
                // TODO list containing these two <t extends renderable & updatable>
                if (mapManager.hasSelectedMap()) {
                    mapManager.render(mapRenderer);
                    mapManager.tickUpdate();
                }
                
                if (overlayManager.isToggledOn()) {
                    overlayManager.render(overlayRenderer);
                    overlayManager.tickUpdate();
                }
                
                if (windowManager.hasWindow()) {
                    windowManager.render(overlayRenderer);
                    windowManager.tickUpdate();
                }
                
                if (contextManager.hasOpenedContextMenu()) {
                    contextManager.render(overlayRenderer);
                    contextManager.tickUpdate();
                }
                
                inputHandler.tickUpdate();
                
            }
        }.start();
        
        primaryStage.setTitle("Placeholder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
