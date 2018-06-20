/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.skill;

/**
 *
 * @author jdolf
 */
public class Magic extends Skill {
    
    public static final String DISPLAY_NAME = "Magic";
    public static final String ICON = "magic_icon.png";
    
    public Magic() {
        super(DISPLAY_NAME, ICON);
    }
    
    public int calculateMagicStrengthImpact() {
        return this.level / 2;
    }
    
    public int calculateMagicDefenseImpact() {
        return this.level;
    }
    
    
    
}
