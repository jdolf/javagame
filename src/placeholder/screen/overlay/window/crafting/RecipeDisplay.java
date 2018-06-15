package placeholder.screen.overlay.window.crafting;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.crafting.CraftingRecipe;
import placeholder.item.Item;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.slot.DefaultSlotManager;
import placeholder.screen.overlay.slot.item.ItemSlot;
import placeholder.screen.overlay.slot.item.ItemSlotManager;
import placeholder.screen.overlay.util.TextDisplay;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.util.SelectionChangedListener;
import placeholder.util.SelectionChooser;

/**
 *
 * @author jdolf
 */
public class RecipeDisplay extends ScreenItem implements Renderable {
    
    private CraftingRecipe template;
    private TextDisplay recipeName;
    private TextDisplay materialsInfo;
    private boolean renderable = false;
    
    public RecipeDisplay(Point2D position, Dimension dimension) {
        super(position, dimension);
    }
    
    public void setTemplate(CraftingRecipe template) {
        this.template = template;
        if (template != null) {
            update();
        } else {
            renderable = false;
        }
    }
    
    private void update() {
        recipeName = new TextDisplay(
                template.getRecipeTemplate().getDisplayName(),
                TextAlignment.LEFT,
                Color.BLACK,
                new Font(14),
                ScreenItem.merge(new Dimension(10, 10), this.getPosition()),
                this.dimension
        );
        materialsInfo = new TextDisplay(
                "Materials used",
                TextAlignment.LEFT,
                Color.BLACK,
                new Font(12),
                ScreenItem.merge(new Dimension(10, 60), this.getPosition()),
                this.dimension
        );
        
        int itemCounter = 0;
        for (Item material : template.getMaterials()) {
            material.setPosition(ScreenItem.merge(new Dimension(10, 80), ScreenItem.mergePoints(this.getPosition(), new Point2D.Double(itemCounter * 40, 0))));
            itemCounter++;
        }
        
        renderable = true;
        
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderRoundRect(Color.GRAY, new Dimension(5, 5), this);
        if (renderable) {
            recipeName.render(renderer);
            materialsInfo.render(renderer);
            template.getMaterials().forEach((material) -> {
                material.render(renderer);
            });
        }
    }
    
}
