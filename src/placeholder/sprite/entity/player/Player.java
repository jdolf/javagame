/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.sprite.entity.player;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import placeholder.input.Direction;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.render.Renderer;
import placeholder.input.InputHandler;
import placeholder.item.ammo.WoodArrow;
import placeholder.item.equipment.EquipmentChangedListener;
import placeholder.item.equipment.EquipmentManager;
import placeholder.item.equipment.PlayerEquipmentManager;
import placeholder.item.equipment.headequipment.BronzeHelmet;
import placeholder.item.equipment.weaponequipment.melee.BronzeSword;
import placeholder.item.equipment.weaponequipment.melee.tool.mining.BronzePickaxe;
import placeholder.item.equipment.weaponequipment.range.WoodBow;
import placeholder.skill.Skill;
import placeholder.skill.util.SkillLevelChangedListener;
import placeholder.skill.util.SkillManager;
import placeholder.sprite.collision.CollisionDetector;
import placeholder.sprite.entity.attack.manager.AttackManager;
import placeholder.sprite.entity.Entity;
import placeholder.sprite.entity.attack.AttackType;
import placeholder.sprite.entity.attack.manager.PlayerAttackManager;
import placeholder.sprite.entity.bodypart.BodyBodyPart;
import placeholder.sprite.entity.bodypart.BodyPart;
import placeholder.sprite.entity.bodypart.BodyPartContainer;
import placeholder.sprite.entity.bodypart.HeadBodyPart;
import placeholder.sprite.entity.bodypart.LeftArmBodyPart;
import placeholder.sprite.entity.bodypart.LegsBodyPart;
import placeholder.sprite.entity.bodypart.RightArmBodyPart;
import placeholder.sprite.entity.player.inventory.Inventory;
import placeholder.sprite.entity.player.inventory.StandardInventory;

/**
 *
 * @author jdolf
 */
public abstract class Player extends Entity implements EquipmentChangedListener, SkillLevelChangedListener {
    
    public static final Dimension DEFAULT_DIMENSION = new Dimension(20, 32);
    public static final Dimension DEFAULT_HEAD_DIMENSION = new Dimension(20, 13);
    public static final Point DEFAULT_HEAD_OFFSET = new Point(0, 0);
    public static final Dimension DEFAULT_BODY_DIMENSION = new Dimension(20, 10);
    public static final Point DEFAULT_BODY_OFFSET = new Point(0, 13);
    public static final Dimension DEFAULT_LEGS_DIMENSION = new Dimension(20, 9);
    public static final Point DEFAULT_LEGS_OFFSET = new Point(0, 23);
    public static final Dimension DEFAULT_LEFT_ARM_DIMENSION = new Dimension(20, 16);
    public static final Point DEFAULT_LEFT_ARM_OFFSET = new Point(-6, 10);
    public static final Dimension DEFAULT_RIGHT_ARM_DIMENSION = new Dimension(20, 16);
    public static final Point DEFAULT_RIGHT_ARM_OFFSET = new Point(6, 10);
    
    protected InputHandler input;
    protected Inventory inventory;
    protected PlayerEquipmentManager equipmentManager = new PlayerEquipmentManager(this);
    protected SkillManager skillManager = new SkillManager();
    protected WindowManager windowManager;
    protected BodyPartContainer bodyPartContainer = new BodyPartContainer(generateBodyParts(), this);
    
    public Player(InputHandler inputHandler, WindowManager windowManager, ContextMenuManager contextManager) {
        super(DEFAULT_DIMENSION, null, new PlayerAttackManager());
        this.input = inputHandler;
        this.windowManager = windowManager;
        this.inventory = new StandardInventory(contextManager, this);
        inventory.insertItem(new BronzeHelmet(null));
        inventory.insertItem(new BronzePickaxe(null));
        inventory.insertItem(new BronzeSword(null));
        inventory.insertItem(new WoodArrow(null, 10));
        inventory.insertItem(new WoodBow(null));
        this.meleeStrength = 5;
        
        // Listener
        skillManager.addSkillLevelChangedListener(this);
        equipmentManager.addEquipmentChangedListener(this);
    }

    @Override
    public void onEquipmentChanged() {
        updateStats();
    }

    @Override
    public void onSkillLevelChanged() {
        updateStats();
    }
    
    private void updateStats() {
        this.meleeStrength = skillManager.getMelee().calculateMeleeStrengthImpact() + equipmentManager.calculateMeleeStrengthImpact();
        this.meleeDefense = skillManager.getMelee().calculateMeleeDefenseImpact() + equipmentManager.calculateMeleeDefenseImpact();
        this.rangeStrength = skillManager.getRange().calculateRangeStrengthImpact() + equipmentManager.calculateRangeStrengthImpact();
        this.rangeDefense = skillManager.getRange().calculateRangeDefenseImpact() + equipmentManager.calculateRangeDefenseImpact();
        this.magicStrength = skillManager.getMagic().calculateMagicStrengthImpact() + equipmentManager.calculateMagicStrengthImpact();
        this.magicDefense = skillManager.getMagic().calculateMagicDefenseImpact() + equipmentManager.calculateMagicDefenseImpact();
    }

    protected List<BodyPart> generateBodyParts() {
        List<BodyPart> bodyParts = new ArrayList();
        bodyParts.add(new HeadBodyPart(getHeadImage(), Player.DEFAULT_HEAD_OFFSET, Player.DEFAULT_HEAD_DIMENSION, this));
        bodyParts.add(new BodyBodyPart(getBodyImage(), Player.DEFAULT_BODY_OFFSET, Player.DEFAULT_BODY_DIMENSION, this));
        bodyParts.add(new LegsBodyPart(getLegsImage(), Player.DEFAULT_LEGS_OFFSET, Player.DEFAULT_LEGS_DIMENSION, this));
        bodyParts.add(new LeftArmBodyPart(getLeftArmImage(), Player.DEFAULT_LEFT_ARM_OFFSET, Player.DEFAULT_LEFT_ARM_DIMENSION, this));
        bodyParts.add(new RightArmBodyPart(getRightArmImage(), Player.DEFAULT_RIGHT_ARM_OFFSET, Player.DEFAULT_RIGHT_ARM_DIMENSION, this));
        return bodyParts;
    }

    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        this.bodyPartContainer.render(renderer, equipmentManager);
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        this.equipmentManager.tickUpdate();
        
        if (!windowManager.hasWindow()) {
            if (input.getKey(KeyCode.DOWN).isBeingPressed()) {
                tryMove(Direction.DOWN);
            }
            if (input.getKey(KeyCode.UP).isBeingPressed()) {
                tryMove(Direction.UP);
            }
            if (input.getKey(KeyCode.LEFT).isBeingPressed()) {
                tryMove(Direction.LEFT);
            }
            if (input.getKey(KeyCode.RIGHT).isBeingPressed()) {
                tryMove(Direction.RIGHT);
            }
            if (input.getKey(KeyCode.SPACE).isActivatedByPress()) {
                attack();
            }
        }
        
        this.bodyPartContainer.update();
    }
    
    protected abstract Image getHeadImage();
            
    protected abstract Image getBodyImage();
    
    protected abstract Image getLegsImage();
    
    protected abstract Image getLeftArmImage();
    
    protected abstract Image getRightArmImage();

    public Inventory getInventory() {
        return this.inventory;
    }

    public PlayerEquipmentManager getPlayerEquipmentManager() {
        return this.equipmentManager;
    }
    
    public SkillManager getSkillManager() {
        return this.skillManager;
    }

}
