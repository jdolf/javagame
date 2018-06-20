package placeholder.game.sprite.entity.hitsplat;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.util.Unregisterable;

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

    public Hitsplat(Unregisterable unregisterable, Point2D position, int amount) {
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
            this.getPosition().setLocation(getPosition().getX(), getPosition().getY() - VELOCITY);;
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
