package placeholder.screen.overlay.slot.actionbar;

import java.awt.Dimension;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import placeholder.input.InputHandler;
import placeholder.input.Key;
import placeholder.screen.ImageContainer;
import placeholder.screen.overlay.window.Window;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.overlay.window.skills.SkillsWindow;
import placeholder.skill.util.SkillManager;

/**
 *
 * @author jdolf
 */
public class SkillsActionBarSlot extends ActionBarSlot {
    
    public static final String ICON_NAME = "skills_slot.png";
    
    public SkillsActionBarSlot(
            SkillManager sm,
            WindowManager wm,
            InputHandler inputHandler,
            Dimension gameDimension,
            Dimension barDimension) {
        super(new SkillsWindow(sm, wm, inputHandler, gameDimension, barDimension),
                inputHandler,
                inputHandler.getKey(KeyCode.T),
                ImageContainer.getInstance().getImage(ICON_NAME));
    }
    
}
