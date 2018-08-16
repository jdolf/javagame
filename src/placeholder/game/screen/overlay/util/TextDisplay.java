package placeholder.game.screen.overlay.util;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javax.swing.text.Position;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class TextDisplay extends Display<String> implements Renderable {
    
    private boolean centered = false;
    private Paint paint;
    private Font font;
    private TextAlignment ta;
    
    public TextDisplay(String text, TextAlignment ta, Paint paint, Font font, Point screenPosition, Dimension dimension) {
        super(screenPosition, dimension);
        this.data = text;
        this.paint = paint;
        this.font = font;
        this.ta = ta;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderText(paint, font, data, this, ta);
    }

    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public boolean isCentered() {
        return centered;
    }
    
}
