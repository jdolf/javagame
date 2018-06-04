/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.skill;

import placeholder.skill.util.SkillLevelChangedListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.screen.ImageContainer;
import placeholder.skill.util.SkillExperienceChangedListener;

/**
 *
 * @author jdolf
 */
public abstract class Skill {
    
    /**
     * States how much experience is needed to reach a specific level. If this
     * ever needs a change use the excel sheet, which calculates this table. Copy
     * into Notepad++, make a capturing group and use the replace function with
     * regex to make .put() methods easily.
     * 
     * Example:
     * Find what: (\d+)\t+(\d+)
     * Replace with: LEVEL_UP_TABLE.put\(\1, \2\);
     */
    public static final Map<Integer, Integer> LEVEL_UP_TABLE;
    
    static {
        LEVEL_UP_TABLE = new HashMap<>();
        LEVEL_UP_TABLE.put(1, 0);
        LEVEL_UP_TABLE.put(2, 83);
        LEVEL_UP_TABLE.put(3, 192);
        LEVEL_UP_TABLE.put(4, 317);
        LEVEL_UP_TABLE.put(5, 461);
        LEVEL_UP_TABLE.put(6, 627);
        LEVEL_UP_TABLE.put(7, 818);
        LEVEL_UP_TABLE.put(8, 1038);
        LEVEL_UP_TABLE.put(9, 1291);
        LEVEL_UP_TABLE.put(10, 1582);
        LEVEL_UP_TABLE.put(11, 1917);
        LEVEL_UP_TABLE.put(12, 2302);
        LEVEL_UP_TABLE.put(13, 2745);
        LEVEL_UP_TABLE.put(14, 3254);
        LEVEL_UP_TABLE.put(15, 3839);
        LEVEL_UP_TABLE.put(16, 4512);
        LEVEL_UP_TABLE.put(17, 5286);
        LEVEL_UP_TABLE.put(18, 6176);
        LEVEL_UP_TABLE.put(19, 7200);
        LEVEL_UP_TABLE.put(20, 8378);
        LEVEL_UP_TABLE.put(21, 9733);
        LEVEL_UP_TABLE.put(22, 11291);
        LEVEL_UP_TABLE.put(23, 13083);
        LEVEL_UP_TABLE.put(24, 15144);
        LEVEL_UP_TABLE.put(25, 17514);
        LEVEL_UP_TABLE.put(26, 20240);
        LEVEL_UP_TABLE.put(27, 23375);
        LEVEL_UP_TABLE.put(28, 26980);
        LEVEL_UP_TABLE.put(29, 31126);
        LEVEL_UP_TABLE.put(30, 35894);
        LEVEL_UP_TABLE.put(31, 41377);
        LEVEL_UP_TABLE.put(32, 47682);
        LEVEL_UP_TABLE.put(33, 54933);
        LEVEL_UP_TABLE.put(34, 63272);
        LEVEL_UP_TABLE.put(35, 72862);
        LEVEL_UP_TABLE.put(36, 83891);
        LEVEL_UP_TABLE.put(37, 96574);
        LEVEL_UP_TABLE.put(38, 111159);
        LEVEL_UP_TABLE.put(39, 127932);
        LEVEL_UP_TABLE.put(40, 147221);
        LEVEL_UP_TABLE.put(41, 169403);
        LEVEL_UP_TABLE.put(42, 194912);
        LEVEL_UP_TABLE.put(43, 224247);
        LEVEL_UP_TABLE.put(44, 257982);
        LEVEL_UP_TABLE.put(45, 296777);
        LEVEL_UP_TABLE.put(46, 341391);
        LEVEL_UP_TABLE.put(47, 392697);
        LEVEL_UP_TABLE.put(48, 451699);
        LEVEL_UP_TABLE.put(49, 519551);
        LEVEL_UP_TABLE.put(50, 597581);
    }
    
    protected List<SkillLevelChangedListener> levelListener = new ArrayList();
    protected List<SkillExperienceChangedListener> experienceListener = new ArrayList();
    /**
     * Some statistics improve as the skill level gets higher. This property
     * saves by how much it gets better. The impact is calculated by a formula
     * depending on the skill's level.
     */
    protected int experience = 0;
    protected int level = 1;
    protected int experienceToNextLevel = 0;
    protected String displayName;
    protected Image icon;
    
    public Skill(String displayName, String iconPath) {
        this.displayName = displayName;
        this.icon = ImageContainer.getInstance().getImage(iconPath);
        calculateExperienceToNextLevel();
    }
    
    public void addExperience(int experience) {
        this.experience += experience;
        calculateLevel();
        calculateExperienceToNextLevel();
        notifySkillExperienceChangedListeners();
    }
    
    private void calculateLevel() {
        int nextLevelXp = LEVEL_UP_TABLE.get(level + 1);
        if (experience >= nextLevelXp) {
            levelUp();
        }
    }
    
    protected void levelUp() {
        level += 1;
        String message = String.format("Well done! Your %s level is now %d", this.displayName, this.level);
        System.out.println(message);
        // Recursion in case multiple level ups happen at the same frame
        calculateLevel();
        notifySkillLevelChangedListeners();
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public int getExperience() {
        return this.experience;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public int getExperienceToNextLevel() {
        return this.experienceToNextLevel;
    }
    
    private final void calculateExperienceToNextLevel() {
        experienceToNextLevel = LEVEL_UP_TABLE.get(level + 1) - experience;
    }
    
    public void addSkillLevelChangedListener(SkillLevelChangedListener listener) {
        this.levelListener.add(listener);
    }
    
    private void notifySkillLevelChangedListeners() {
        this.levelListener.forEach((listener) -> {
            listener.onSkillLevelChanged();
        });
    }
    
    public void addSkillExperienceChangedListener(SkillExperienceChangedListener listener) {
        this.experienceListener.add(listener);
    }
    
    private void notifySkillExperienceChangedListeners() {
        this.experienceListener.forEach((listener) -> {
            listener.onExperienceChanged();
        });
    }
    
    public Image getIcon() {
        return this.icon;
    }
}
