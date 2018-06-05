/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.screen.overlay;

import java.awt.Dimension;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jdolf
 */
public class ScreenItem {
    
    private List<PositionChangeListener> listener = new ArrayList();
    private Point position;
    protected Dimension dimension;
    
    public ScreenItem(Point screenPosition, Dimension dimension) {
        this.position = screenPosition;
        this.dimension = dimension;
    }
    
    public ScreenItem(Dimension dimension) {
        this.dimension = dimension;
    }
    
    public ScreenItem(Point position) {
        this.position = position;
    }
    
    public ScreenItem() {}

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        notifyPositionChangedListener();
    }
    
    public Dimension getDimension() {
        return this.dimension;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
        notifyPositionChangedListener();
    }
    
    public void addPositionChangeListener(PositionChangeListener listener) {
        this.listener.add(listener);
    }
    
    private void notifyPositionChangedListener() {
        this.listener.forEach((listener) -> {
            listener.onPositionChanged();
        });
    }
    
    public static Dimension mergeDimensions(Dimension d1, Dimension d2) {
        return new Dimension(d1.width + d2.width, d1.height + d2.height);
    }
    
    public static Point mergePoints(Point p1, Point p2) {
        return new Point(p1.x + p2.x, p1.y + p2.y);
    }
    
    public static Point merge(Dimension d, Point p) {
        return new Point(p.x + d.width, p.y + d.height);
    }
    
    public boolean hasPositionAndDimension() {
        if (this.position != null && this.dimension != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
