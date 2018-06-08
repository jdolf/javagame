package placeholder.screen.overlay.util;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javax.swing.text.Position;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class TextDisplay extends Display<String> implements Renderable {
    
    private boolean centered = false;
    private Paint paint;
    private Font font;
    private TextAlignment ta;
    
    public TextDisplay(String text, TextAlignment ta, Paint paint, Font font, Point2D screenPosition, Dimension dimension) {
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
    public void setPosition(Point2D position) {
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
