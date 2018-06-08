/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.input;

import java.awt.geom.Point2D;

/**
 *
 * @author jdolf
 */
public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;
    
    public Point2D calculateOffsetChanges(double offset) {
        double x = 0;
        double y = 0;
        if (DOWN == this) y += offset;
        if (UP == this) y -= offset;
        if (LEFT == this) x -= offset;
        if (RIGHT == this) x += offset;
        return new Point2D.Double(x, y);
    }
}
