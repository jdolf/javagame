package placeholder.game.sprite.entity;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import java.beans.PropertyChangeEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class HealthBar extends ScreenItem implements HealthChangedListener, PositionChangeListener, Renderable {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(40, 5);
    public static final Dimension DEFAULT_INNER_DIMENSION = new Dimension(40, 5);
    public static final int DEFAULT_HEIGHT_MARGIN = -10;
    public static final Paint DEFAULT_OUTER_COLOR = Color.RED;
    public static final Paint DEFAULT_INNER_COLOR = Color.LIME;
    
    private Health health;
    private Paint outerColor;
    private Paint innerColor;
    private ScreenItem parent;
    private ScreenItem currentHealthRect = new ScreenItem(new Dimension(DEFAULT_INNER_DIMENSION.width, DEFAULT_INNER_DIMENSION.height));
    private Dimension marginToParent = new Dimension();
    
    public HealthBar(Health health, ScreenItem parent) {
        super(DEFAULT_DIMENSION);
        this.health = health;
        this.outerColor = DEFAULT_OUTER_COLOR;
        this.innerColor = DEFAULT_INNER_COLOR;
        this.parent = parent;
        
        // Calculate margin to parent
        int widthDifference = Math.abs((this.dimension.width - parent.getDimension().width) / 2);
        if (this.dimension.width > parent.getDimension().width) widthDifference *= -1;
        marginToParent.setSize(widthDifference, DEFAULT_HEIGHT_MARGIN);
        
        health.addHealthChangedListener(this);
        parent.addPositionChangeListener(this);
        onPositionChanged();
    }
    
    private void calculateInnerRect() {
        currentHealthRect.setPosition(this.getPosition());
        double maxHealth = health.getMaxAmount();
        double currentHealth = health.getAmount();
        currentHealthRect.getDimension().width = (int) (currentHealth / maxHealth * DEFAULT_DIMENSION.width);
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderRect(outerColor, this);
        renderer.renderRect(innerColor, currentHealthRect);
    }

    @Override
    public void onHealthChanged(int amount) {
        calculateInnerRect();
    }

    /**
     * If parent receives a new position (Point) adjust the position of this item too.
     */
    @Override
    public void onPositionChanged() {
        this.setPosition(ScreenItem.merge(marginToParent, parent.getPosition()));
        calculateInnerRect();
    }
    
}
