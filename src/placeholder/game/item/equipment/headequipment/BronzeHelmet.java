/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.item.equipment.headequipment;

import java.awt.geom.Point2D;
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
public class BronzeHelmet extends HeadEquipment {

    public static final String ICON_NAME = "bronze_helmet_icon.png";
    public static final String ANIMATION_NAME = "bronze_helmet.png";

    
    public BronzeHelmet(Point2D position) {
        super(
                position,
                ImageContainer.getInstance().getImage(ICON_NAME),
                ImageContainer.getInstance().getImage(ANIMATION_NAME)
        );
        this.meleeDefense = 3;
        this.magicStrength = -1;
        this.magicDefense = -2;
        this.displayName = "Bronze Helmet";
    }
}
