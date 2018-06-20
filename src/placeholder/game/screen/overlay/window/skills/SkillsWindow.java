package placeholder.game.screen.overlay.window.skills;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javax.swing.text.Position;
import placeholder.game.input.InputHandler;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.ScreenItem;
import placeholder.game.screen.overlay.util.ImageDisplay;
import placeholder.game.screen.overlay.util.TextDisplay;
import placeholder.game.screen.overlay.window.ImageBackgroundWindow;
import placeholder.game.screen.overlay.window.Window;
import placeholder.game.screen.overlay.window.WindowManager;
import placeholder.game.screen.render.Renderer;
import placeholder.game.skill.Skill;
import placeholder.game.skill.util.SkillManager;
import placeholder.game.util.Grid;

/**
 *
 * @author jdolf
 */
public class SkillsWindow extends ImageBackgroundWindow {
    
    public static final Dimension SCREEN_DIMENSION = new Dimension(500, 350);
    public static final String BACKGROUND_IMAGE = "window_skills.png";
    
    public static final Dimension SKILL_DISPLAY_INIT_MARGIN = new Dimension(0, 100);
    public static final Dimension SKILL_DISPLAY_MARGIN = new Dimension(20, 20);
    public static final String TITLE = "Skills";
    public static final Paint TITLE_COLOR = Color.BLACK;
    public static final Font TITLE_FONT = new Font("Dialog", 32);
    
    private SkillManager skillManager;
    private Grid<SkillDisplay> skillDisplayGrid;
    private List<SkillDisplay> skillDisplays = new ArrayList();
    
    public SkillsWindow(SkillManager sm, WindowManager manager, InputHandler input, Dimension gameDimension, Dimension barDimension) {
        super(manager, input, gameDimension, barDimension, SCREEN_DIMENSION, BACKGROUND_IMAGE);
        this.skillManager = sm;
        createSkillDisplays();
        skillDisplayGrid = new Grid<>(
                skillDisplays,
                SKILL_DISPLAY_MARGIN,
                ScreenItem.merge(SKILL_DISPLAY_INIT_MARGIN, this.getPosition()),
                this.dimension
        );
    }
    
    private void createSkillDisplays() {
        skillManager.getSkills().forEach((skill) -> {
            skillDisplays.add(new SkillDisplay(skill));
        });
    }

    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        skillDisplayGrid.render(renderer);
    }
    
}
