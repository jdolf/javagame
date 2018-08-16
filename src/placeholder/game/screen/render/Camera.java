package placeholder.game.screen.render;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import placeholder.game.screen.overlay.PositionChangeListener;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.overlay.SizeChangeListener;

/**
 *
 * @author jdolf
 */
public class Camera extends ScreenItem implements PositionChangeListener, SizeChangeListener {
    
    private ScreenItem target;
    
    public Camera(Dimension gameDimension) {
        super(gameDimension);
        gameDimension.addSizeChangeListener(this);
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
                new Point(
                        target.getPosition().getX() - dimension.width / 2,
                        target.getPosition().getY() - dimension.height / 2
                )
        );
    }

    @Override
    public void onSizeChanged(Dimension dimension) {
        lockOnTarget(target);
    }
    
}
