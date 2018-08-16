/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.headequipment;

import placeholder.game.util.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;

/**
 *
 * @author jdolf
 */
public class IronHelmet extends HeadEquipment {

    public static final String ICON_NAME = "iron_helmet_icon.png";
    public static final String ANIMATION_NAME = "iron_helmet.png";

    
    public IronHelmet(Point position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 4;
        this.magicStrength = -1;
        this.magicDefense = -2;
        this.rangeDefense = 5;
        this.displayName = "Iron Helmet";
    }
}
