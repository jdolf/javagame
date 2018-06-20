package placeholder.editor;

import com.sun.glass.events.MouseEvent;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static placeholder.game.Placeholder.DEFAULT_DIMENSION;
import static placeholder.game.Placeholder.HEIGHT;
import static placeholder.game.Placeholder.WIDTH;
import placeholder.game.input.DefaultInputHandler;
import placeholder.game.input.InputHandler;
import placeholder.game.map.Map;
import placeholder.game.map.NewbieLandMap;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Camera;
import placeholder.game.screen.render.CameraOrientedRenderer;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.ambient.Grass;
import placeholder.game.sprite.entity.mob.Dummy;
import placeholder.game.sprite.furniture.Anvil;
import placeholder.game.sprite.furniture.Furnace;
import placeholder.game.sprite.furniture.Workbench;
import placeholder.game.sprite.resource.mining.StoneRock;
import placeholder.game.sprite.resource.woodcutting.DefaultTree;
import placeholder.game.sprite.resource.woodcutting.JungleTree;
import placeholder.game.sprite.resource.woodcutting.PineTree;
import placeholder.game.sprite.resource.woodcutting.WillowTree;
import placeholder.game.util.Maths;

/**
 *
 * @author jdolf
 */
public class Editor extends Application {
    
    public static final ObservableList<Class<? extends Sprite>> ITEMS = FXCollections.observableArrayList(
            Anvil.class,
            Workbench.class,
            Furnace.class,
            Grass.class,
            Dummy.class,
            DefaultTree.class,
            JungleTree.class,
            WillowTree.class,
            PineTree.class,
            StoneRock.class
    );
    
    private InputHandler inputHandler = new DefaultInputHandler();
    private Map map = new NewbieLandMap();
    
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        Canvas canvas = new Canvas(0, 0);
        root.getChildren().add(canvas);
        
        CameraOrientedRenderer mapRenderer = new CameraOrientedRenderer(canvas.getGraphicsContext2D(), new Dimension(0, 0));
        mapRenderer.getCamera().setPosition(new Point2D.Double(0, 0));
        
        ComboBox<Class<? extends Sprite>> comboBox = new ComboBox();
        comboBox.setItems(ITEMS);
        comboBox.setFocusTraversable(false);
        root.getChildren().add(comboBox);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        canvas.setWidth(scene.getWidth());
        canvas.setHeight(scene.getHeight());
        updateMapClearDimension(mapRenderer, canvas);
        scene.setOnKeyPressed(inputHandler);
        scene.setOnKeyReleased(inputHandler);
        scene.setOnMouseClicked((event) -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                if (comboBox.getSelectionModel().getSelectedItem() != null) {
                    if (Maths.inside(
                            new Point2D.Double(event.getX(), event.getY()),
                            new Point2D.Double(canvas.getLayoutX(), canvas.getLayoutY()),
                            new Dimension((int)canvas.getWidth(), (int)canvas.getHeight())
                        )
                    ) {
                        try {
                            System.out.println(comboBox.getSelectionModel().getSelectedItem());
                            Sprite sprite = comboBox.getSelectionModel().getSelectedItem()
                                .getDeclaredConstructor(Point2D.class)
                                .newInstance(new Point2D.Double(
                                        mapRenderer.getCamera().getPosition().getX() + event.getX(),
                                        mapRenderer.getCamera().getPosition().getY() + event.getY())
                                );
                            map.addSprite(sprite);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                }
            } else if (event.getButton() == MouseButton.SECONDARY) {
                map.getSpriteReceiver().getAt(new Point2D.Double(event.getX(), event.getY()), new Dimension(1, 1)).forEach((sprite) -> {
                    map.removeSprite(sprite);
                });
            }
                
        });
        scene.widthProperty().addListener((observable) -> {
            canvas.setWidth(scene.getWidth());
            updateMapClearDimension(mapRenderer, canvas);
            
        });
        scene.heightProperty().addListener((observable) -> {
            canvas.setHeight(scene.getHeight());
            updateMapClearDimension(mapRenderer, canvas);
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                mapRenderer.clear();
                inputHandler.tickUpdate();
                map.tickUpdate();
                map.render(mapRenderer);
                
                Point2D offset = null;
                if (inputHandler.getKey(KeyCode.A).isBeingPressed()) offset = new Point2D.Double(-3, 0);
                if (inputHandler.getKey(KeyCode.D).isBeingPressed()) offset = new Point2D.Double(3, 0);
                if (inputHandler.getKey(KeyCode.S).isBeingPressed()) offset = new Point2D.Double(0, 3);
                if (inputHandler.getKey(KeyCode.W).isBeingPressed()) offset = new Point2D.Double(0, -3);
                
                if (offset != null) {
                    mapRenderer.getCamera().setPosition(ScreenItem.mergePoints(mapRenderer.getCamera().getPosition(), offset));
                }
            }
        }.start();
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void output() {
        map.getSprites().forEach((sprite) -> {
            String output = String.format("sprites.add(new %s(new Point2D.Double(%s, %s)));",
                    sprite.getClass().getName(),
                    String.valueOf(sprite.getPosition().getX()),
                    String.valueOf(sprite.getPosition().getY()));
            System.out.println(output);
        });
    }

    @Override
    public void stop() throws Exception {
        output();
        super.stop();
    }
    
    private void updateMapClearDimension(Renderer renderer, Canvas canvas) {
        renderer.setGameDimension(new Dimension((int)canvas.getWidth(), (int)canvas.getHeight()));
    }
    
    
    
}
