package placeholder.game.screen.overlay.slot.actionbar;

import placeholder.game.util.Dimension;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import placeholder.game.input.InputHandler;
import placeholder.game.input.Key;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.window.Window;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.screen.overlay.window.skills.SkillsWindow;
import placeholder.game.skill.util.SkillManager;

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
                inputHandler.getKey(KeyCode.F),
                ImageContainer.getInstance().getImage(ICON_NAME));
    }
    
}
