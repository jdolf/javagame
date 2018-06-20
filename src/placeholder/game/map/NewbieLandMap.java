/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.map;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import placeholder.game.screen.ImageContainer;
import placeholder.game.sprite.Sprite;
import placeholder.game.sprite.entity.mob.Dummy;
import placeholder.game.sprite.furniture.Anvil;
import placeholder.game.sprite.furniture.Furnace;
import placeholder.game.sprite.furniture.Workbench;
import placeholder.game.sprite.resource.mining.StoneRock;
import placeholder.game.sprite.resource.woodcutting.DefaultTree;
import placeholder.game.sprite.resource.woodcutting.JungleTree;
import placeholder.game.sprite.resource.woodcutting.PineTree;
import placeholder.game.sprite.resource.woodcutting.WillowTree;

/**
 *
 * @author jdolf
 */
public class NewbieLandMap extends Map {
    
    public static final MapCode MAP_CODE = MapCode.NEWBIE_LAND;

    public NewbieLandMap() {
        super(MAP_CODE);
    }

    @Override
    protected List<Sprite> createSprites() {
        List<Sprite> sprites = new ArrayList();
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(82.0, 70.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(208.0, 72.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(309.0, 77.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(304.0, 169.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(233.0, 183.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(164.0, 192.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(78.0, 195.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(80.0, 321.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(195.0, 307.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(319.0, 303.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(352.0, 275.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(420.0, 236.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(417.0, 183.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(419.0, 76.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(467.0, 362.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(408.0, 401.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(324.0, 413.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(222.0, 419.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(146.0, 424.0)));
        sprites.add(new placeholder.game.sprite.ambient.Grass(new Point2D.Double(65.0, 430.0)));
        sprites.add(new placeholder.game.sprite.furniture.Anvil(new Point2D.Double(311.0, 130.0)));
        sprites.add(new placeholder.game.sprite.furniture.Furnace(new Point2D.Double(403.0, 133.0)));
        sprites.add(new placeholder.game.sprite.furniture.Workbench(new Point2D.Double(166.0, 103.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(175.0, 394.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(98.0, 87.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(490.0, 60.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(546.0, 372.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.JungleTree(new Point2D.Double(251.0, 409.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.WillowTree(new Point2D.Double(328.0, 387.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.PineTree(new Point2D.Double(409.0, 369.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.StoneRock(new Point2D.Double(486.0, 264.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.StoneRock(new Point2D.Double(512.0, 328.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.StoneRock(new Point2D.Double(454.0, 338.0)));
        return sprites;
    }
    
    
}
