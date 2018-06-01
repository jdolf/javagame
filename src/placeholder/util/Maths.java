/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.util;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author jdolf
 */
public class Maths {
    
    public static boolean inside (
            Point testPoint,
            Point targetPoint,
            Dimension targetDimension) {
        
        if (testPoint.x >= targetPoint.x &&
                testPoint.x <= targetPoint.x + targetDimension.width &&
                testPoint.y >= targetPoint.y &&
                testPoint.y <= targetPoint.y + targetDimension.height) {
            
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
        if (testPoint.y > targetPoint.y + targetDimension.height ||
                testPoint.y + testDimension.height < targetPoint.y ||
                testPoint.x > targetPoint.x + targetDimension.width ||
                testPoint.x + testDimension.width < targetPoint.x) {
            
            return false;
            
        } else {
            return true;
        }
    }
}
