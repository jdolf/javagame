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
public class Woodcutting extends Skill {
    
    public static final String DISPLAY_NAME = "Woodcutting";
    public static final String ICON = "woodcutting_icon.png";
    
    public Woodcutting() {
        super(DISPLAY_NAME, ICON);
    }
    
    public int calculateWoodcuttingEfficiencyImpact() {
        return this.level * 2;
    }
    
}
