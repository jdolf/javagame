/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.util;

import java.awt.geom.Point2D;
import placeholder.game.util.Point;
import java.util.ArrayList;
import java.util.List;
import placeholder.game.screen.overlay.PositionChangeListener;

/**
 *
 * @author jannik.dolf
 */
public class Point extends Point2D.Double {

    private List<PositionChangeListener> sizeListener = new ArrayList();

    public Point() {
    }

    public Point(double x, double y) {
        super(x, y);
    }
    
    @Override
    public void setLocation(double x, double y) {
        super.setLocation(x, y);
        notifyPositionChangedListener();
    }

    @Override
    public void setLocation(Point2D p) {
        super.setLocation(p);
        notifyPositionChangedListener();
    }
    
    public void addPositionChangeListener(PositionChangeListener listener) {
        this.sizeListener.add(listener);
    }
    
    private void notifyPositionChangedListener() {
        this.sizeListener.forEach((listener) -> {
            listener.onPositionChanged();
        });
    }
    
    
    
}
