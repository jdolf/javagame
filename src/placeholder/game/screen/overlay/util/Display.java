package placeholder.game.screen.overlay.util;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.render.Renderable;

/**
 *
 * @author jdolf
 */
public abstract class Display<T> extends ScreenItem implements Renderable {
    
    protected T data;
    
    public Display(Point screenPosition, Dimension dimension) {
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
