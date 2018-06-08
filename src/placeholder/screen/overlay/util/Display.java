package placeholder.screen.overlay.util;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public abstract class Display<T> extends ScreenItem implements Renderable {
    
    protected T data;
    
    public Display(Point2D screenPosition, Dimension dimension) {
        super(screenPosition, dimension);
    }
    
    public Display(Dimension dimension) {
        super(dimension);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
