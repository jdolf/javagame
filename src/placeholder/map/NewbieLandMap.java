/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.map;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import placeholder.sprite.Sprite;
import placeholder.sprite.entity.mob.Dummy;
import placeholder.sprite.furniture.Anvil;
import placeholder.sprite.furniture.Furnace;
import placeholder.sprite.furniture.Workbench;
import placeholder.sprite.resource.mining.StoneRock;
import placeholder.sprite.resource.woodcutting.DefaultTree;
import placeholder.sprite.resource.woodcutting.JungleTree;
import placeholder.sprite.resource.woodcutting.PineTree;
import placeholder.sprite.resource.woodcutting.WillowTree;

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
        sprites.add(new StoneRock(new Point2D.Double(100, 80)));
        sprites.add(new DefaultTree(new Point2D.Double(300, 210)));
        sprites.add(new JungleTree(new Point2D.Double(350, 210)));
        sprites.add(new WillowTree(new Point2D.Double(400, 210)));
        sprites.add(new PineTree(new Point2D.Double(450, 210)));
        sprites.add(new Dummy(new Point2D.Double(200, 120)));
        sprites.add(new Dummy(new Point2D.Double(240, 120)));
        sprites.add(new Dummy(new Point2D.Double(280, 120)));
        sprites.add(new Workbench(new Point2D.Double(50, 350)));
        sprites.add(new Anvil(new Point2D.Double(300, 300)));
        sprites.add(new Furnace(new Point2D.Double(300, 400)));
        return sprites;
    }
    
    
}
