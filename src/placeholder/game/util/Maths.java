/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.util;

import placeholder.game.util.Dimension;
import placeholder.game.util.Point;

/**
 *
 * @author jdolf
 */
public class Maths {
    
    public static boolean inside (
            Point testPoint,
            Point targetPoint,
            Dimension targetDimension) {
        
        if (testPoint.getX() >= targetPoint.getX() &&
                testPoint.getX() <= targetPoint.getX() + targetDimension.width &&
                testPoint.getY() >= targetPoint.getY() &&
                testPoint.getY() <= targetPoint.getY() + targetDimension.height) {
            
            return true;
            
        } else {
            return false;
        }
    }
    
    public static boolean overlapping (
            Point testPoint,
            Dimension testDimension,
            Point targetPoint,
            Dimension targetDimension) {
        
        // Test if they are NOT overlapping (Simplest way)
        if (testPoint.getY() > targetPoint.getY() + targetDimension.height ||
                testPoint.getY() + testDimension.height < targetPoint.getY() ||
                testPoint.getX() > targetPoint.getX() + targetDimension.width ||
                testPoint.getX() + testDimension.width < targetPoint.getX()) {
            
            return false;
            
        } else {
            return true;
        }
    }
}
