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
import placeholder.sprite.resource.mining.StoneRock;

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
        sprites.add(new Dummy(new Point2D.Double(200, 120)));
        return sprites;
    }
    
    
}
