package placeholder.game.skill.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import placeholder.game.skill.Fletching;
import placeholder.game.skill.Hitpoints;
import placeholder.game.skill.Magic;
import placeholder.game.skill.Melee;
import placeholder.game.skill.Mining;
import placeholder.game.skill.Range;
import placeholder.game.skill.Skill;
import placeholder.game.skill.SkillType;
import placeholder.game.skill.Smithing;
import placeholder.game.skill.Woodcutting;

/**
 *
 * @author jdolf
 */
public class SkillManager {
    
    private List<Skill> skills = new ArrayList();
    
    private Hitpoints hitpoints = new Hitpoints();
    private Melee melee = new Melee();
    private Range range = new Range();
    private Magic magic = new Magic();
    private Mining mining = new Mining();
    private Smithing smithing = new Smithing();
    private Woodcutting woodcutting = new Woodcutting();
    private Fletching fletching = new Fletching();
    
    public SkillManager() {
        skills.add(hitpoints);
        skills.add(melee);
        skills.add(range);
        skills.add(magic);
        skills.add(mining);
        skills.add(smithing);
        skills.add(woodcutting);
        skills.add(fletching);
    }

    public void addSkillLevelChangedListener(SkillLevelChangedListener listener) {
        skills.forEach((skill) -> {
            skill.addSkillLevelChangedListener(listener);
        });
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Hitpoints getHitpoints() {
        return hitpoints;
    }

    public Melee getMelee() {
        return melee;
    }

    public Range getRange() {
        return range;
    }

    public Magic getMagic() {
        return magic;
    }

    public Mining getMining() {
        return mining;
    }

    public Smithing getSmithing() {
        return smithing;
    }

    public Woodcutting getWoodcutting() {
        return woodcutting;
    }

    public Fletching getFletching() {
        return fletching;
    }
    
    
    
    
}
