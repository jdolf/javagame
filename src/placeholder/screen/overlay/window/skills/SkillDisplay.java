package placeholder.screen.overlay.window.skills;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Collection;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.util.Display;
import placeholder.screen.overlay.util.ImageDisplay;
import placeholder.screen.overlay.util.TextDisplay;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.skill.Skill;
import placeholder.skill.util.SkillExperienceChangedListener;
import placeholder.skill.util.SkillLevelChangedListener;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class SkillDisplay extends Display<Skill> implements SkillExperienceChangedListener {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(100, 90);
    public static final Paint DEFAULT_TEXT_PAINT = Color.BLACK;
    public static final Font DEFAULT_FONT = new Font("Consolas", 28);
    
    public static final Paint BORDER_COLOR = Color.WHITE;
    public static final Dimension BORDER_ARC_DIMENSION = new Dimension(5, 5);
    public static final int BORDER_THICKNESS = 2;
    
    public static final Dimension ICON_DIMENSION = new Dimension(32, 32);
    public static final Dimension ICON_MARGIN = new Dimension(5, 50);
    
    public static final Dimension LEVEL_MARGIN = new Dimension(90, 47);
    public static final Dimension LEVEL_DIMENSION = new Dimension(30, 20);
    
    public static final Dimension TITLE_MARGIN = new Dimension(10, 5);
    public static final Dimension TITLE_DIMENSION = new Dimension(40, 32);
    public static final Paint TITLE_PAINT = Color.WHITE;
    public static final Font TITLE_FONT = new Font("Consolas", 13);
    
    public static final Dimension SMALL_INFO_DIMENSION = new Dimension(20, 10);
    public static final Paint SMALL_INFO_PAINT = Color.GREY;
    public static final Font SMALL_INFO_FONT = new Font("Consolas", 10);
    
    public static final Dimension XP_INFO_MARGIN = new Dimension(25, 23);
    public static final Dimension XP_MARGIN = new Dimension(90, 23);
    public static final Dimension XP_FORLEVELUP_INFO_MARGIN = new Dimension(35, 33);
    public static final Dimension XP_FORLEVELUP_MARGIN = new Dimension(90, 33);
    
    private TextDisplay title;
    private TextDisplay level;
    private ImageDisplay icon;
    private TextDisplay xpInfo;
    private TextDisplay xpForLevelUpInfo;
    private TextDisplay xp;
    private TextDisplay xpForLevelUp;

    public SkillDisplay(Skill skill) {
        super(DEFAULT_DIMENSION);
        this.data = skill;
        skill.addSkillExperienceChangedListener(this);
    }

    @Override
    public void setPosition(Point2D position) {
        super.setPosition(position);
        setDisplays();
    }
    
    private void setDisplays() {
        title = new TextDisplay(
                this.data.getDisplayName(),
                TextAlignment.LEFT,
                TITLE_PAINT,
                TITLE_FONT,
                ScreenItem.merge(TITLE_MARGIN, this.getPosition()),
                TITLE_DIMENSION
        );
        level = new TextDisplay(
                Integer.toString(this.data.getLevel()),
                TextAlignment.RIGHT,
                DEFAULT_TEXT_PAINT, 
                DEFAULT_FONT,
                ScreenItem.merge(LEVEL_MARGIN, this.getPosition()),
                LEVEL_DIMENSION
        );
        xpInfo = new TextDisplay(
                "XP:",
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(XP_INFO_MARGIN, this.getPosition()),
                SMALL_INFO_DIMENSION
        );
        xpForLevelUpInfo = new TextDisplay(
                "Left:",
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(XP_FORLEVELUP_INFO_MARGIN, this.getPosition()),
                SMALL_INFO_DIMENSION
        );
        xp = new TextDisplay(
                Integer.toString(this.data.getExperience()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(XP_MARGIN, this.getPosition()),
                SMALL_INFO_DIMENSION
        );
        xpForLevelUp = new TextDisplay(
                Integer.toString(this.data.getExperienceToNextLevel()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(XP_FORLEVELUP_MARGIN, this.getPosition()),
                SMALL_INFO_DIMENSION
        );
        icon = new ImageDisplay(
                this.data.getIcon(),
                ScreenItem.merge(ICON_MARGIN, this.getPosition()),
                ICON_DIMENSION
        );
    }
    
    private void updateDisplays() {
        xp.setData(Integer.toString(this.data.getExperience()));
        level.setData(Integer.toString(this.data.getLevel()));
        xpForLevelUp.setData(Integer.toString(this.data.getExperienceToNextLevel()));
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderRoundRectStroke(BORDER_COLOR, BORDER_THICKNESS, BORDER_ARC_DIMENSION, this);
        level.render(renderer);
        icon.render(renderer);
        title.render(renderer);
        xp.render(renderer);
        xpInfo.render(renderer);
        xpForLevelUp.render(renderer);
        xpForLevelUpInfo.render(renderer);
    }

    @Override
    public void onExperienceChanged() {
        updateDisplays();
    }
    
    
    
}
