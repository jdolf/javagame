package placeholder.game.skill;

import javafx.scene.image.Image;

/**
 *
 * @author jdolf
 */
public class Hitpoints extends Skill {
    
    public static final String DISPLAY_NAME = "Hitpoints";
    public static final String ICON = "hitpoints_icon.png";
    
    public Hitpoints() {
        super(DISPLAY_NAME, ICON);
    }

    protected int calculateHitpointsImpact() {
        // Every level yields an extra 10 hitpoints
        return (this.level - 1) * 10;
    }
    
}
