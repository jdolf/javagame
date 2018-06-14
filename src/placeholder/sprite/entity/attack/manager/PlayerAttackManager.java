package placeholder.sprite.entity.attack.manager;

import java.awt.Dimension;
import java.util.Map;
import placeholder.item.equipment.weaponequipment.Hitbox;
import placeholder.screen.overlay.slot.item.equipment.WeaponEquipmentSlot;
import placeholder.screen.render.Renderable;
import placeholder.screen.render.Renderer;
import placeholder.skill.SkillType;
import placeholder.sprite.entity.attack.Attack;
import placeholder.sprite.entity.attack.MeleeAttack;
import placeholder.item.equipment.weaponequipment.range.projectile.RangeProjectile;
import placeholder.item.equipment.weaponequipment.range.projectile.WoodArrowProjectile;
import placeholder.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class PlayerAttackManager extends AttackManager<Player> {
    
    public static final Dimension DEFAULT_ATTACK_HITBOX = new Dimension(30, 40);
    public static final int DEFAULT_ATTACK_COOLDOWN = 30;
    public static final int DEFAULT_ATTACK_DURATION = 10;
    public static final int DEFAULT_ATTACK_INVINCIBILITYSTUN = 10;
    public static final int DEFAULT_ATTACK_STARTUPTIME = 10;


    @Override
    public void attack() {
        WeaponEquipmentSlot weaponEquipmentSlot = source.getPlayerEquipmentManager().getWeaponEquipmentSlot();
        this.attacking = true;
        
        if (!weaponEquipmentSlot.isEmpty()) {
            weaponEquipmentSlot.getItem().attackInit();
            usedWeapon = weaponEquipmentSlot.getItem();
            this.registerAttackCooldown(weaponEquipmentSlot.getItem().getAttackSpeed());
        } else {
            initAttack = true;
            startUpTime = DEFAULT_ATTACK_STARTUPTIME;
            this.registerAttackCooldown(DEFAULT_ATTACK_COOLDOWN);
        }
        
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        
    }

    @Override
    protected void initializedAttack() {
        new MeleeAttack(this.source, DEFAULT_ATTACK_HITBOX, DEFAULT_ATTACK_DURATION, DEFAULT_ATTACK_INVINCIBILITYSTUN);
            this.registerAttackCooldown(DEFAULT_ATTACK_COOLDOWN);
    }
    
}
