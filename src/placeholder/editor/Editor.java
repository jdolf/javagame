package placeholder.editor;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static placeholder.game.Placeholder.HEIGHT;
import static placeholder.game.Placeholder.WIDTH;
import placeholder.game.input.DefaultInputHandler;
import placeholder.game.input.InputHandler;
import placeholder.game.map.Map;
import placeholder.game.map.NewbieLandMap;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.CameraOrientedRenderer;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.ambient.Grass;
import placeholder.game.sprite.ambient.GrassBig;
import placeholder.game.sprite.ambient.NaturalStoneWall;
import placeholder.game.sprite.ambient.StoneMud;
import placeholder.game.sprite.ambient.StoneMudBig;
import placeholder.game.sprite.ambient.WoodFloor;
import placeholder.game.sprite.ambient.WoodWallHorizontal;
import placeholder.game.sprite.ambient.WoodWallVertical;
import placeholder.game.sprite.entity.mob.Dummy;
import placeholder.game.sprite.entity.mob.Goblin;
import placeholder.game.sprite.furniture.Anvil;
import placeholder.game.sprite.furniture.Furnace;
import placeholder.game.sprite.furniture.Workbench;
import placeholder.game.sprite.resource.mining.CoalRock;
import placeholder.game.sprite.resource.mining.CopperRock;
import placeholder.game.sprite.resource.mining.GoldRock;
import placeholder.game.sprite.resource.mining.IronRock;
import placeholder.game.sprite.resource.mining.StoneRock;
import placeholder.game.sprite.resource.mining.TinRock;
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
    
    public static final ObservableList<Sprite> ITEMS = createItems();
    
    private InputHandler inputHandler = new DefaultInputHandler();
    private Map map = new NewbieLandMap();
    private Sprite selection = null;
    private Point mousePosition = null;
    private Text selectionText;
    
    private static ObservableList<Sprite> createItems() {
        ObservableList<Sprite> templates = FXCollections.observableArrayList();
        templates.add(new Workbench(null));
        templates.add(new Anvil(null));
        templates.add(new Furnace(null));
        templates.add(new DefaultTree(null));
        templates.add(new JungleTree(null));
        templates.add(new WillowTree(null));
        templates.add(new PineTree(null));
        templates.add(new Goblin(null));
        templates.add(new Grass(null));
        templates.add(new GrassBig(null));
        templates.add(new StoneMudBig(null));
        templates.add(new StoneMud(null));
        templates.add(new StoneRock(null));
        templates.add(new TinRock(null));
        templates.add(new CopperRock(null));
        templates.add(new IronRock(null));
        templates.add(new CoalRock(null));
        templates.add(new GoldRock(null));
        templates.add(new WoodWallHorizontal(null));
        templates.add(new WoodWallVertical(null));
        templates.add(new WoodFloor(null));
        templates.add(new NaturalStoneWall(null));
        return templates;
    }
    
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        Canvas canvas = new Canvas(0, 0);
        root.getChildren().add(canvas);
        
        AnchorPane sidePanel = new AnchorPane();
        sidePanel.setPrefWidth(200);
        sidePanel.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        TilePane itemHolder = new TilePane();
        itemHolder.setPrefWidth(sidePanel.getPrefWidth());
        ITEMS.forEach((item) -> {
            ImageView imageView = new ImageView(item.makePreviewImage());
            imageView.setFitHeight(32);
            imageView.setFitWidth(32);
            imageView.setOnMouseClicked((event) -> {
                select(item);
            });
            itemHolder.getChildren().add(imageView);
        });
        System.out.println(itemHolder.getChildren().size());
        
        ScrollPane itemScrollPane = new ScrollPane();
        itemScrollPane.setLayoutX(0);
        itemScrollPane.setLayoutY(300);
        itemScrollPane.setPrefWidth(sidePanel.getPrefWidth());
        itemScrollPane.setContent(itemHolder);
        itemScrollPane.setVisible(false);
        
        sidePanel.getChildren().add(itemScrollPane);
        
        root.getChildren().add(sidePanel);
        
        ObservableList comboBoxItems = FXCollections.observableArrayList();
        comboBoxItems.addAll(Mode.values());
        ComboBox<Mode> comboBoxMode = new ComboBox(comboBoxItems);
        comboBoxMode.setLayoutX(40);
        comboBoxMode.setLayoutY(40);
        comboBoxMode.setPrefWidth(120);
        comboBoxMode.getSelectionModel().selectFirst();
        sidePanel.getChildren().add(comboBoxMode);
        
        selectionText = new Text();
        selectionText.setLayoutX(40);
        selectionText.setLayoutY(80);
        sidePanel.getChildren().add(selectionText);
        
        CameraOrientedRenderer mapRenderer = new CameraOrientedRenderer(canvas.getGraphicsContext2D(), new Dimension(0, 0));
        mapRenderer.getCamera().setPosition(new Point2D.Double(0, 0));
        
        Button buttonBack = new Button("To Back");
        buttonBack.setOnAction((action) -> {
            if (selection != null) {
                map.getSprites().remove(selection);
                map.getSprites().add(0, selection);
            }
        });
        buttonBack.setLayoutX(40);
        buttonBack.setLayoutY(120);
        sidePanel.getChildren().add(buttonBack);
        
        Button buttonFront = new Button("To Front");
        buttonFront.setOnAction((action) -> {
            if (selection != null) {
                map.getSprites().remove(selection);
                map.getSprites().add(selection);
            }
        });
        buttonFront.setLayoutX(40);
        buttonFront.setLayoutY(160);
        sidePanel.getChildren().add(buttonFront);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        sidePanel.setPrefHeight(scene.getHeight());
        canvas.setWidth(scene.getWidth() - sidePanel.getPrefWidth());
        canvas.setHeight(scene.getHeight());
        sidePanel.setLayoutX(canvas.getWidth());
        itemScrollPane.setPrefHeight(scene.getHeight() - itemScrollPane.getLayoutY());
        updateMapClearDimension(mapRenderer, canvas);
        
        canvas.setOnMouseMoved((event) -> {
            this.mousePosition = new Point((int)event.getSceneX(), (int)event.getSceneY());
        });
        
        comboBoxMode.setOnAction((event) -> {
            if (comboBoxMode.getSelectionModel().getSelectedItem() == Mode.SELECT) {
                buttonBack.setVisible(true);
                buttonFront.setVisible(true);
                itemScrollPane.setVisible(false);
            } else if (comboBoxMode.getSelectionModel().getSelectedItem() == Mode.PLACE) {
                buttonBack.setVisible(false);
                buttonFront.setVisible(false);
                itemScrollPane.setVisible(true);
            }
        });
        
        scene.setOnKeyPressed(inputHandler);
        scene.setOnKeyReleased(inputHandler);
        canvas.setOnMouseClicked((event) -> {
            
            if (comboBoxMode.getSelectionModel().getSelectedItem() != null) {
                
                if (comboBoxMode.getSelectionModel().getSelectedItem() == Mode.PLACE) {

                    if (event.getButton() == MouseButton.PRIMARY) {
                        if (selection != null) {
                            if (Maths.inside(
                                    new Point2D.Double(event.getX(), event.getY()),
                                    new Point2D.Double(canvas.getLayoutX(), canvas.getLayoutY()),
                                    new Dimension((int)canvas.getWidth(), (int)canvas.getHeight())
                                )
                            ) {
                                try {
                                    Sprite sprite = selection.getClass()
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
                    }
                } else if (comboBoxMode.getSelectionModel().getSelectedItem() == Mode.SELECT) {

                    List<Sprite> selectedSprites = map.getSpriteReceiver().getAt(new Point2D.Double(
                            mapRenderer.getCamera().getPosition().getX() + event.getX(),
                            mapRenderer.getCamera().getPosition().getY() + event.getY()
                    ), new Dimension(1, 1));

                        if (!selectedSprites.isEmpty()) {
                            select(selectedSprites.get(selectedSprites.size() - 1));
                        }
                }
                
                if (event.getButton() == MouseButton.SECONDARY) {
                    List<Sprite> selectedSprites = map.getSpriteReceiver().getAt(new Point2D.Double(
                             mapRenderer.getCamera().getPosition().getX() + event.getX(),  mapRenderer.getCamera().getPosition().getY() + event.getY()
                    ), new Dimension(1, 1));

                    if (!selectedSprites.isEmpty()) {
                        map.removeSprite(selectedSprites.get(selectedSprites.size() - 1));
                    }
                }
            }
                
        });
        scene.widthProperty().addListener((observable) -> {
            canvas.setWidth(scene.getWidth() - sidePanel.getPrefWidth());
            sidePanel.setLayoutX(canvas.getWidth());
            updateMapClearDimension(mapRenderer, canvas);
            
        });
        scene.heightProperty().addListener((observable) -> {
            canvas.setHeight(scene.getHeight());
            sidePanel.setPrefHeight(scene.getHeight());
            itemScrollPane.setPrefHeight(scene.getHeight() - itemScrollPane.getLayoutY());
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
                if (inputHandler.getKey(KeyCode.A).isBeingPressed()) offset = new Point2D.Double(-5, 0);
                if (inputHandler.getKey(KeyCode.D).isBeingPressed()) offset = new Point2D.Double(5, 0);
                if (inputHandler.getKey(KeyCode.S).isBeingPressed()) offset = new Point2D.Double(0, 5);
                if (inputHandler.getKey(KeyCode.W).isBeingPressed()) offset = new Point2D.Double(0, -5);
                
                if (offset != null) {
                    mapRenderer.getCamera().setPosition(ScreenItem.mergePoints(mapRenderer.getCamera().getPosition(), offset));
                }
                
                if (comboBoxMode.getSelectionModel().getSelectedItem() == Mode.PLACE && selection != null) {
                    selection.setPosition(
                            ScreenItem.mergePoints(mousePosition, mapRenderer.getCamera().getPosition())
                    );
                    selection.render(mapRenderer);
                }
            }
        }.start();
        
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void select(Sprite newSelection) {
        selection = newSelection;
        selectionText.setText(newSelection.getClass().getSimpleName());
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
