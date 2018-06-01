/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.input;

import java.awt.Point;

/**
 *
 * @author jdolf
 */
public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;
    
    public Point calculateOffsetChanges(int offset) {
        Point position = new Point(0, 0);
        if (DOWN == this) position.y += offset;
        if (UP == this) position.y -= offset;
        if (LEFT == this) position.x -= offset;
        if (RIGHT == this) position.x += offset;
        return position;
    }
}
