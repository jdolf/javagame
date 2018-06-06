package placeholder.sprite.entity.hitsplat;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.screen.TickUpdatable;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.util.Unregisterable;

/**
 *
 * @author jdolf
 */
public class Hitsplat extends ScreenItem implements TickUpdatable, Renderable {
    
    public static final Font DAMAGE_FONT = new Font(10);
    public static final Font HEAL_FONT = new Font(10);
    public static final Color DAMAGE_COLOR = Color.DARKRED;
    public static final Color HEAL_COLOR = Color.LIME;
    private static final int HITSPLAT_TIME = 60;
    private static final int VELOCITY = 3;
    public static final Dimension DIMENSION = new Dimension();
    
    private Unregisterable unregisterable;
    private int amount;
    private Font font;
    private Color color;
    private int duration = HITSPLAT_TIME;

    public Hitsplat(Unregisterable unregisterable, Point position, int amount) {
        super(position);
        if (amount < 0) {
            font = DAMAGE_FONT;
            color = DAMAGE_COLOR;
        } else {
            font = HEAL_FONT;
            color = HEAL_COLOR;
        }
        // Set Dimension by digit amount
        this.setDimension(new Dimension(String.valueOf(amount).length() * (int) font.getSize(), (int) font.getSize()));
        this.amount = Math.abs(amount);
        this.unregisterable = unregisterable;
    }
    
    @Override
    public void tickUpdate() {
        duration -= 1;
        
        if (duration >= HITSPLAT_TIME / 4 * 3) {
            this.getPosition().y -= VELOCITY;
        }
        
        if (duration <= 0) {
            unregisterable.unregister(this);
        }
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderText(color, font, Integer.toString(amount), this, TextAlignment.CENTER);
    }
    
}