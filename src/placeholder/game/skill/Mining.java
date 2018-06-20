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
public class Mining extends Skill {
    
    public static final String DISPLAY_NAME = "Mining";
    public static final String ICON = "mining_icon.png";
    
    public Mining() {
        super(DISPLAY_NAME, ICON);
    }

    public int calculateMiningEfficiencyImpact() {
        return this.level * 3;
    }
    
}
