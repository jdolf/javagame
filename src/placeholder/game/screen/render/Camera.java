package placeholder.game.screen.render;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.screen.overlay.ScreenItem;

/**
 *
 * @author jdolf
 */
public class Camera extends ScreenItem implements PositionChangeListener {
    
    private ScreenItem target;
    
    public Camera(Dimension gameDimension) {
        super(gameDimension);
    }
    
    public void lockOnTarget(ScreenItem target) {
        target.addPositionChangeListener(this);
        this.target = target;
        calcPosition();
    }

    @Override
    public void onPositionChanged() {
        calcPosition();
    }
    
    private void calcPosition() {
        this.setPosition(
                new Point2D.Double(
                        target.getPosition().getX() - dimension.width / 2,
                        target.getPosition().getY() - dimension.height / 2
                )
        );
    }
    
}
