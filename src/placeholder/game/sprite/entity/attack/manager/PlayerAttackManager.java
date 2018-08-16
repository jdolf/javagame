package placeholder.game.sprite.entity.attack.manager;

import placeholder.game.util.Dimension;
import java.util.Map;
import placeholder.game.item.equipment.weaponequipment.Hitbox;
import placeholder.game.item.equipment.weaponequipment.WeaponEquipment;
import placeholder.game.screen.overlay.slot.item.equipment.WeaponEquipmentSlot;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.skill.SkillType;
import placeholder.game.sprite.entity.attack.Attack;
import placeholder.game.sprite.entity.attack.MeleeAttack;
import placeholder.game.item.equipment.weaponequipment.range.projectile.RangeProjectile;
import placeholder.game.item.equipment.weaponequipment.range.projectile.WoodArrowProjectile;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class PlayerAttackManager extends AttackManager<Player> {
    
    public static final Dimension DEFAULT_ATTACK_HITBOX = new Dimension(30, 30);
    public static final int DEFAULT_ATTACK_COOLDOWN = 15;
    public static final int DEFAULT_ATTACK_DURATION = 10;
    public static final int DEFAULT_ATTACK_INVINCIBILITYSTUN = 10;
    public static final int DEFAULT_ATTACK_STARTUPTIME = 20;
    
    private boolean defaultAttacking = false;
    private MeleeAttack punchAttack;
    protected WeaponEquipment usedWeapon = null;

    public PlayerAttackManager() {
        this.defaultStartUpTime = DEFAULT_ATTACK_STARTUPTIME;
    }

    @Override
    public void attack() {
        super.attack();
        WeaponEquipmentSlot weaponEquipmentSlot = source.getPlayerEquipmentManager().getWeaponEquipmentSlot();
        if (!weaponEquipmentSlot.isEmpty()) {
            usedWeapon = weaponEquipmentSlot.getItem();
        } else {
            defaultAttacking = true;
        }
    }
    
    

    @Override
    public int attackImpl() {
        
        if (usedWeapon != null) {
            usedWeapon.attackInit();
            isGoingToAttack = false;
            return usedWeapon.getAttackSpeed();
        } else {
            return DEFAULT_ATTACK_COOLDOWN;
        }
        
    }

    protected void defaultAttack() {
        punchAttack = new MeleeAttack(this.source, DEFAULT_ATTACK_HITBOX, DEFAULT_ATTACK_DURATION, DEFAULT_ATTACK_INVINCIBILITYSTUN);
        punchAttack.attack();
        isGoingToAttack = false;
    }

    @Override
    public void tickUpdate() {
        if (punchAttack != null) {
            punchAttack.tickUpdate();
            if (punchAttack.getDuration() == 0) {
                punchAttack = null;
            }
        }
        super.tickUpdate();
        if (attacking && attackCooldown <= 0) {
            usedWeapon = null;
        }
        
        if (defaultAttacking && startUpTime == 0) {
            defaultAttacking = false;
            defaultAttack();
        }
    }

    public MeleeAttack getPunchAttack() {
        return punchAttack;
    }

    public WeaponEquipment getUsedWeapon() {
        return usedWeapon;
    }
    
    public boolean isDefaultAttacking() {
        return defaultAttacking;
    }
    
    
}
