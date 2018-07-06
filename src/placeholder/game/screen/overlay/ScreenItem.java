/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.screen.overlay;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Point2D;

/**
 *
 * @author jdolf
 */
public class ScreenItem {
    
    private List<PositionChangeListener> listener = new ArrayList();
    private Point2D position;
    private Point2D middlePosition;
    protected Dimension dimension;
    
    public ScreenItem(Point2D screenPosition, Dimension dimension) {
        this.position = screenPosition;
        this.dimension = dimension;
        if (hasPositionAndDimension()) calcMiddlePosition();
    }
    
    public ScreenItem(Dimension dimension) {
        this.dimension = dimension;
    }
    
    public ScreenItem(Point2D position) {
        this.position = position;
    }
    
    public ScreenItem() {}

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        if (hasPositionAndDimension()) calcMiddlePosition();
        notifyPositionChangedListener();
    }
    
    public Dimension getDimension() {
        return this.dimension;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
        if (hasPositionAndDimension()) calcMiddlePosition();
        notifyPositionChangedListener();
    }
    
    private void calcMiddlePosition() {
        this.middlePosition = new Point2D.Double(position.getX() + dimension.width / 2, position.getY() + dimension.height / 2);
    }
    
    public Point2D getMiddlePosition() {
        return this.middlePosition;
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
    
    public static Point2D mergePoints(Point2D p1, Point2D p2) {
        return new Point2D.Double(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }
    
    public static Point2D merge(Dimension d, Point2D p) {
        return new Point2D.Double(p.getX() + d.width, p.getY() + d.height);
    }
    
    public static Point2D shiftBackByHalfOfDimension(Dimension dimension, Point2D point) {
        return new Point2D.Double(point.getX() - dimension.width / 2, point.getY() - dimension.height / 2);
    }
    
    public boolean hasPositionAndDimension() {
        if (this.position != null && this.dimension != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
