/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.skill;

import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public class Range extends Skill {
    
    public static final String DISPLAY_NAME = "Range";
    public static final String ICON = "range_icon.png";
    
    public Range() {
        super(DISPLAY_NAME, ICON);
    }

    public int calculateRangeStrengthImpact() {
        return this.level / 2;
    }
    
    public int calculateRangeDefenseImpact() {
        return this.level / 3;
    }
    
}