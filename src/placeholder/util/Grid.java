package placeholder.util;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.List;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class Grid<T extends ScreenItem & Renderable> extends ScreenItem implements Renderable {
    
    private int rows;
    private int columns;
    private List<T> items;
    private Dimension itemMargin;
    
    public Grid(List<T> items, Dimension itemMargin, Point2D screenPosition, Dimension dimension) {
        super(screenPosition, dimension);
        this.items = items;
        this.itemMargin = itemMargin;
        initialize(true);
    }
    
    public Grid(List<T> items, int rows, int columns, Dimension itemMargin, Point2D screenPosition, Dimension dimension) {
        super(screenPosition, dimension);
        this.items = items;
        this.itemMargin = itemMargin;
        this.rows = rows;
        this.columns = columns;
        initialize(false);
    }

    private void initialize(boolean calculateDimensions) {
        if (calculateDimensions) {
            calculateColumns();
            calculateRows();
        }
        calculateItemsPosition();
    }
    
    @Override
    public void render(Renderer renderer) {
        items.forEach((item) -> {
            if (item != null) {
                item.render(renderer);
            }
        });
    }
    
    private void calculateColumns() {
        int itemWidth = 0;
        
        try {
            itemWidth = items.get(0).getDimension().width + itemMargin.width;
        } catch (Exception ex) {
            itemWidth = 1;
        }
        
        
        this.columns = this.dimension.width / itemWidth;
    }
    
    private void calculateRows() {
        int itemHeight = 0;
        
        try {
            itemHeight = items.get(0).getDimension().height + itemMargin.height;
        } catch (Exception ex) {
            itemHeight = 1;
        }
        
        
        this.rows = this.dimension.height / itemHeight;
    }
    
    private void calculateItemsPosition() {
        int currentColumn = 1;
        int currentRow = 1;
        
        for (T item : items) {
            double itemX = (currentColumn - 1) * (item.getDimension().width + itemMargin.width) + itemMargin.width + this.getPosition().getX();
            double itemY = (currentRow - 1) * (item.getDimension().height + itemMargin.height) + itemMargin.height + this.getPosition().getY();

            item.setPosition(new Point2D.Double(itemX, itemY));
            
            if (currentColumn >= columns) {
                currentColumn = 1;
                currentRow += 1;
            } else {
                currentColumn += 1;
            }
        }
    }
    
    public List<T> getItems() {
        return this.items;
    }
    
    public int getRows() {
        return this.rows;
    }
    
    public int getColumns() {
        return this.columns;
    }
    
}
