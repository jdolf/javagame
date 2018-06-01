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
        LEVEL_UP_TABLE.put(1, 83);
        LEVEL_UP_TABLE.put(2, 178);
        LEVEL_UP_TABLE.put(3, 287);
        LEVEL_UP_TABLE.put(4, 412);
        LEVEL_UP_TABLE.put(5, 555);
        LEVEL_UP_TABLE.put(6, 719);
        LEVEL_UP_TABLE.put(7, 907);
        LEVEL_UP_TABLE.put(8, 1123);
        LEVEL_UP_TABLE.put(9, 1371);
        LEVEL_UP_TABLE.put(10, 1656);
        LEVEL_UP_TABLE.put(11, 1983);
        LEVEL_UP_TABLE.put(12, 2359);
        LEVEL_UP_TABLE.put(13, 2791);
        LEVEL_UP_TABLE.put(14, 3287);
        LEVEL_UP_TABLE.put(15, 3857);
        LEVEL_UP_TABLE.put(16, 4512);
        LEVEL_UP_TABLE.put(17, 5265);
        LEVEL_UP_TABLE.put(18, 6130);
        LEVEL_UP_TABLE.put(19, 7124);
        LEVEL_UP_TABLE.put(20, 8267);
        LEVEL_UP_TABLE.put(21, 9581);
        LEVEL_UP_TABLE.put(22, 11092);
        LEVEL_UP_TABLE.put(23, 12829);
        LEVEL_UP_TABLE.put(24, 14826);
        LEVEL_UP_TABLE.put(25, 17122);
        LEVEL_UP_TABLE.put(26, 19762);
        LEVEL_UP_TABLE.put(27, 22798);
        LEVEL_UP_TABLE.put(28, 26289);
        LEVEL_UP_TABLE.put(29, 30303);
        LEVEL_UP_TABLE.put(30, 34919);
        LEVEL_UP_TABLE.put(31, 40227);
        LEVEL_UP_TABLE.put(32, 46331);
        LEVEL_UP_TABLE.put(33, 53350);
        LEVEL_UP_TABLE.put(34, 61421);
        LEVEL_UP_TABLE.put(35, 70702);
        LEVEL_UP_TABLE.put(36, 81375);
        LEVEL_UP_TABLE.put(37, 93648);
        LEVEL_UP_TABLE.put(38, 107761);
        LEVEL_UP_TABLE.put(39, 123990);
        LEVEL_UP_TABLE.put(40, 142653);
        LEVEL_UP_TABLE.put(41, 164115);
        LEVEL_UP_TABLE.put(42, 188796);
        LEVEL_UP_TABLE.put(43, 217179);
        LEVEL_UP_TABLE.put(44, 249819);
        LEVEL_UP_TABLE.put(45, 287355);
        LEVEL_UP_TABLE.put(46, 330521);
        LEVEL_UP_TABLE.put(47, 380161);
        LEVEL_UP_TABLE.put(48, 437247);
        LEVEL_UP_TABLE.put(49, 502895);
        LEVEL_UP_TABLE.put(50, 578390);
    }
    
    protected List<SkillLevelChangedListener> listener = new ArrayList();
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
    }
    
    public void addExperience(int experience) {
        this.experience += experience;
        calculateLevel();
        calculateExperienceToNextLevel();
    }
    
    private void calculateLevel() {
        int nextLevelXp = LEVEL_UP_TABLE.get(level + 1);
        if (experience >= nextLevelXp) {
            levelUp();
        }
    }
    
    protected void levelUp() {
        level += 1;
        String message = String.format("Well done! Your % level is now %", this.displayName, this.level);
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
    
    private void calculateExperienceToNextLevel() {
        experienceToNextLevel = LEVEL_UP_TABLE.get(level + 1) - experience;
    }
    
    public void addSkillLevelChangedListener(SkillLevelChangedListener listener) {
        this.listener.add(listener);
    }
    
    private void notifySkillLevelChangedListeners() {
        this.listener.forEach((listener) -> {
            listener.onSkillLevelChanged();
        });
    }
    
    public Image getIcon() {
        return this.icon;
    }
}
