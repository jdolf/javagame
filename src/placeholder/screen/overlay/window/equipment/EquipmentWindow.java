package placeholder.screen.overlay.window.equipment;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import placeholder.input.InputHandler;
import placeholder.item.equipment.EquipmentChangedListener;
import placeholder.item.equipment.EquipmentManager;
import placeholder.screen.overlay.ScreenItem;
import placeholder.screen.overlay.contextmenu.ContextMenuManager;
import placeholder.screen.overlay.slot.SelectableSlotManager;
import placeholder.screen.overlay.slot.item.equipment.EquipmentSlot;
import placeholder.screen.overlay.util.TextDisplay;
import placeholder.screen.overlay.window.ImageBackgroundWindow;
import placeholder.screen.overlay.window.WindowManager;
import placeholder.screen.render.Renderer;

/**
 *
 * @author jdolf
 */
public class EquipmentWindow extends ImageBackgroundWindow implements EquipmentChangedListener {
    
    public static final Dimension SCREEN_DIMENSION = new Dimension(500, 350);
    public static final String BACKGROUND_IMAGE = "window_equipment.png";
    public static final Dimension DISPLAY_INIT_MARGIN = new Dimension(70, 90);
    public static final Dimension SMALL_INFO_DIMENSION = new Dimension(20, 10);
    public static final Paint SMALL_INFO_PAINT = Color.GREY;
    public static final Font SMALL_INFO_FONT = new Font("Consolas", 12);
    
    private SelectableSlotManager<EquipmentSlot> slotManager;
    private EquipmentManager equipmentManager;
    private ContextMenuManager cm;
    
    private TextDisplay meleeStrengthInfo;
    private TextDisplay rangeStrengthInfo;
    private TextDisplay magicStrengthInfo;
    private TextDisplay meleeDefenseInfo;
    private TextDisplay rangeDefenseInfo;
    private TextDisplay magicDefenseInfo;
    private TextDisplay playerSpeedPercentageInfo;
    private TextDisplay weaponCooldownInfo;
    private TextDisplay meleeStrength;
    private TextDisplay rangeStrength;
    private TextDisplay magicStrength;
    private TextDisplay meleeDefense;
    private TextDisplay rangeDefense;
    private TextDisplay magicDefense;
    private TextDisplay playerSpeedPercentage;
    private TextDisplay weaponCooldown;
    
    public EquipmentWindow(
            ContextMenuManager cm,
            WindowManager manager,
            InputHandler input,
            Dimension gameDimension,
            Dimension barDimension,
            EquipmentManager equipmentManager) {
        super(manager, input, gameDimension, barDimension, SCREEN_DIMENSION, BACKGROUND_IMAGE);
        this.equipmentManager = equipmentManager;
        this.slotManager = new SelectableSlotManager<EquipmentSlot>(
                equipmentManager.getEquipmentSlots(),
                new Point2D.Double(this.getPosition().getX() + DISPLAY_INIT_MARGIN.width, this.getPosition().getY() + DISPLAY_INIT_MARGIN.height),
                this.dimension
        );
        this.cm = cm;
        slotManager.setInputHandler(input);
        equipmentManager.addEquipmentChangedListener(this);
        meleeStrengthInfo = new TextDisplay(
                "Melee Strength:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(75, 175), this.getPosition()),
                dimension
        );
        rangeStrengthInfo = new TextDisplay(
                "Range Strength:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(75, 205), this.getPosition()),
                dimension
        );
        magicStrengthInfo = new TextDisplay(
                "Magic Strength:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(75, 235), this.getPosition()),
                dimension
        );
        weaponCooldownInfo = new TextDisplay(
                "Attack Cooldown Reduction:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(125, 270), this.getPosition()),
                dimension
        );
        meleeStrength = new TextDisplay(
                String.valueOf(equipmentManager.calculateMeleeStrengthImpact()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(225, 175), this.getPosition()),
                dimension
        );
        rangeStrength = new TextDisplay(
                String.valueOf(equipmentManager.calculateRangeStrengthImpact()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(225, 205), this.getPosition()),
                dimension
        );
        magicStrength = new TextDisplay(
                String.valueOf(equipmentManager.calculateMagicStrengthImpact()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(225, 235), this.getPosition()),
                dimension
        );
        weaponCooldown = new TextDisplay(
                String.valueOf(equipmentManager.calculateCooldownPercentage()) + " %",
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(375, 270), this.getPosition()),
                dimension
        );
        meleeDefenseInfo = new TextDisplay(
                "Melee Defense:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(275, 175), this.getPosition()),
                dimension
        );
        rangeDefenseInfo = new TextDisplay(
                "Range Defense:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(275, 205), this.getPosition()),
                dimension
        );
        magicDefenseInfo = new TextDisplay(
                "Magic Defense:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(275, 235), this.getPosition()),
                dimension
        );
        meleeDefense = new TextDisplay(
                String.valueOf(equipmentManager.calculateMeleeDefenseImpact()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(425, 175), this.getPosition()),
                dimension
        );
        rangeDefense = new TextDisplay(
                String.valueOf(equipmentManager.calculateRangeDefenseImpact()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(425, 205), this.getPosition()),
                dimension
        );
        magicDefense = new TextDisplay(
                String.valueOf(equipmentManager.calculateMagicDefenseImpact()),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(425, 235), this.getPosition()),
                dimension
        );
        playerSpeedPercentageInfo = new TextDisplay(
                "Player Speed Increase:",
                TextAlignment.LEFT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(125, 300), this.getPosition()),
                dimension
        );
        playerSpeedPercentage = new TextDisplay(
                String.valueOf(equipmentManager.calculateSpeedPercentage() + " %"),
                TextAlignment.RIGHT,
                SMALL_INFO_PAINT,
                SMALL_INFO_FONT,
                ScreenItem.merge(new Dimension(375, 300), this.getPosition()),
                dimension
        );
    }
    
    private void updateDisplays() {
        meleeStrength.setData(String.valueOf(equipmentManager.calculateMeleeStrengthImpact()));
        rangeStrength.setData(String.valueOf(equipmentManager.calculateRangeStrengthImpact()));
        magicStrength.setData(String.valueOf(equipmentManager.calculateMagicStrengthImpact()));
        meleeDefense.setData(String.valueOf(equipmentManager.calculateMeleeDefenseImpact()));
        rangeDefense.setData(String.valueOf(equipmentManager.calculateRangeDefenseImpact()));
        magicDefense.setData(String.valueOf(equipmentManager.calculateMagicDefenseImpact()));
        playerSpeedPercentage.setData(String.valueOf(equipmentManager.calculateSpeedPercentage() + " %"));
        weaponCooldown.setData(String.valueOf(equipmentManager.calculateCooldownPercentage()) + " %");
    }
    
    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
        slotManager.render(renderer);
        meleeStrengthInfo.render(renderer);
        rangeStrengthInfo.render(renderer);
        magicStrengthInfo.render(renderer);
        meleeStrength.render(renderer);
        rangeStrength.render(renderer);
        magicStrength.render(renderer);
        meleeDefenseInfo.render(renderer);
        rangeDefenseInfo.render(renderer);
        magicDefenseInfo.render(renderer);
        meleeDefense.render(renderer);
        rangeDefense.render(renderer);
        magicDefense.render(renderer);
        weaponCooldownInfo.render(renderer);
        weaponCooldown.render(renderer);
        playerSpeedPercentage.render(renderer);
        playerSpeedPercentageInfo.render(renderer);
    }

    @Override
    public void tickUpdate() {
        super.tickUpdate();
        if (cm.hasOpenedContextMenu() == false) {
            slotManager.tickUpdate();
        }
    }

    @Override
    public void onEquipmentChanged() {
        updateDisplays();
    }
    
}
