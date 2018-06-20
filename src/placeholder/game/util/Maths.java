/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.util;

import java.awt.Dimension;
import java.awt.geom.Point2D;

/**
 *
 * @author jdolf
 */
public class Maths {
    
    public static boolean inside (
            Point2D testPoint,
            Point2D targetPoint,
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
            Point2D testPoint,
            Dimension testDimension,
            Point2D targetPoint,
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
