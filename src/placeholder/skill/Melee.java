/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.skill;

import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public class Melee extends Skill {
    
    public static final String DISPLAY_NAME = "Melee";
    public static final String ICON = "melee_icon.png";
    
    public Melee() {
        super(DISPLAY_NAME, ICON);
    }

    public int calculateMeleeStrengthImpact() {
        // Every level yields 2 melee strength
        return this.level * 2;
    }
    
    public int calculateMeleeDefenseImpact() {
        // Every 3 levels yield a bit of melee defense
        return this.level / 3;
    }

    
    
}
