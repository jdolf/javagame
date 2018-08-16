/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay;

import placeholder.game.util.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import placeholder.game.util.Point;
import placeholder.game.util.Dimension;
import placeholder.game.util.Point;

/**
 *
 * @author jdolf
 */
public class ScreenItem {
    
    private List<PositionChangeListener> positionListener = new ArrayList();
    private List<DimensionChangeListener> dimensionListener = new ArrayList();
    private Point position = new Point(0, 0);
    private Point middlePosition;
    protected Dimension dimension = new Dimension(0, 0);
    
    public ScreenItem(Point screenPosition, Dimension dimension) {
        this.position = screenPosition;
        this.dimension = dimension;
        if (hasPositionAndDimension()) calcMiddlePosition();
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
        if (hasPositionAndDimension()) calcMiddlePosition();
        notifyPositionChangedListener();
        notifyDimensionChangedListener();
    }
    
    public Dimension getDimension() {
        return this.dimension;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
        if (hasPositionAndDimension()) calcMiddlePosition();
        notifyPositionChangedListener();
    }
    
    private void calcMiddlePosition() {
        this.middlePosition = new Point(position.getX() + dimension.width / 2, position.getY() + dimension.height / 2);
    }
    
    public Point getMiddlePosition() {
        return this.middlePosition;
    }
    
    public void addPositionChangeListener(PositionChangeListener listener) {
        this.positionListener.add(listener);
    }
    
    private void notifyPositionChangedListener() {
        this.positionListener.forEach((listener) -> {
            listener.onPositionChanged();
        });
    }
    
    public void addDimensionChangeListener(DimensionChangeListener listener) {
        this.dimensionListener.add(listener);
    }
    
    private void notifyDimensionChangedListener() {
        this.dimensionListener.forEach((listener) -> {
            listener.onDimensionChanged();
        });
    }
    
    public static Dimension mergeDimensions(Dimension d1, Dimension d2) {
        return new Dimension(d1.width + d2.width, d1.height + d2.height);
    }
    
    public static Point mergePoints(Point p1, Point p2) {
        return new Point(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }
    
    public static Point merge(Dimension d, Point p) {
        return new Point(p.getX() + d.width, p.getY() + d.height);
    }
    
    public static Point shiftBackByHalfOfDimension(Dimension dimension, Point point) {
        return new Point(point.getX() - dimension.width / 2, point.getY() - dimension.height / 2);
    }
    
    public boolean hasPositionAndDimension() {
        if (this.position != null && this.dimension != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
