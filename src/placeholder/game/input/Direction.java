/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.input;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;

/**
 *
 * @author jdolf
 */
public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;
    
    public Point calculateOffsetChanges(double offset) {
        double x = 0;
        double y = 0;
        if (DOWN == this) y += offset;
        if (UP == this) y -= offset;
        if (LEFT == this) x -= offset;
        if (RIGHT == this) x += offset;
        return new Point(x, y);
    }
    
    public Point calculatePointWithOffset(Dimension offsetDown, Point fromPosition, Dimension fromDimension) {
        double x = fromPosition.getX();
        double y = fromPosition.getY();
        if (null != this) switch (this) {
            case UP:
                y = fromPosition.getY() - offsetDown.height;
                x = fromPosition.getX() - (offsetDown.width - fromDimension.width) / 2;
                break;
            case LEFT:
                x = fromPosition.getX() - offsetDown.width;
                if (offsetDown.width > fromDimension.height) {
                    y = fromPosition.getY() - (offsetDown.height - fromDimension.height) / 2;
                }
                break;
            case DOWN:
                y = fromPosition.getY() + fromDimension.height;
                x = fromPosition.getX() - (offsetDown.width - fromDimension.width) / 2;
                break;
            case RIGHT:
                x = fromPosition.getX() + fromDimension.width;
                if (offsetDown.width > fromDimension.height) {
                    y = fromPosition.getY() - (offsetDown.height - fromDimension.height) / 2;
                }
                break;
            default:
                break;
        }
        return new Point(x, y);
    }
}
