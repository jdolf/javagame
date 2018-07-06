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
import placeholder.game.sprite.entity.mob.Goblin;
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
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(681.0, 341.0)));
        sprites.add(new placeholder.game.sprite.ambient.GrassBig(new Point2D.Double(50.0, 43.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(171.0, 352.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(383.0, 108.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(853.0, 163.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(893.0, 464.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(301.0, 722.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(902.0, 828.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(604.0, 897.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(137.0, 929.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(868.0, 639.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(211.0, 428.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(161.0, 426.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.JungleTree(new Point2D.Double(236.0, 361.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.WillowTree(new Point2D.Double(303.0, 361.0)));
        sprites.add(new placeholder.game.sprite.resource.woodcutting.PineTree(new Point2D.Double(367.0, 359.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.StoneRock(new Point2D.Double(556.0, 184.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.StoneRock(new Point2D.Double(498.0, 360.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.StoneRock(new Point2D.Double(129.0, 304.0)));
        sprites.add(new placeholder.game.sprite.entity.mob.Dummy(new Point2D.Double(505.0, 120.0)));
        sprites.add(new placeholder.game.sprite.entity.mob.Dummy(new Point2D.Double(607.0, 120.0)));
        sprites.add(new placeholder.game.sprite.entity.mob.Dummy(new Point2D.Double(726.0, 254.0)));
        sprites.add(new placeholder.game.sprite.ambient.GrassBig(new Point2D.Double(50.0, -981.0)));
        sprites.add(new placeholder.game.sprite.ambient.GrassBig(new Point2D.Double(-974.0, -981.0)));
        sprites.add(new placeholder.game.sprite.ambient.GrassBig(new Point2D.Double(-973.0, 41.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(594.0, 369.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(593.0, 338.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(623.0, 338.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(624.0, 369.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(655.0, 339.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(656.0, 368.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(609.0, 324.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(638.0, 326.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(612.0, 386.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(639.0, 391.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(682.0, 366.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(684.0, 341.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(671.0, 398.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(703.0, 397.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(707.0, 368.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(712.0, 340.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(668.0, 312.0)));
        sprites.add(new placeholder.game.sprite.ambient.StoneMud(new Point2D.Double(698.0, 312.0)));
        sprites.add(new placeholder.game.sprite.entity.mob.Dummy(new Point2D.Double(611.0, 358.0)));
        sprites.add(new placeholder.game.sprite.entity.mob.Dummy(new Point2D.Double(658.0, 363.0)));
        sprites.add(new Goblin(new Point2D.Double(658.0, 500.0)));
        sprites.add(new placeholder.game.sprite.furniture.Workbench(new Point2D.Double(293.0, 115.0)));
        sprites.add(new placeholder.game.sprite.furniture.Furnace(new Point2D.Double(31.0, 80.0)));
        sprites.add(new placeholder.game.sprite.furniture.Anvil(new Point2D.Double(165.0, 106.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.TinRock(new Point2D.Double(181.0, 307.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.CopperRock(new Point2D.Double(230.0, 307.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.IronRock(new Point2D.Double(280.0, 308.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.CoalRock(new Point2D.Double(329.0, 311.0)));
        sprites.add(new placeholder.game.sprite.resource.mining.GoldRock(new Point2D.Double(377.0, 313.0)));
        sprites.add(new placeholder.game.sprite.entity.mob.Goblin(new Point2D.Double(283.0, 171.0)));
        sprites.add(new placeholder.game.sprite.entity.mob.Goblin(new Point2D.Double(423.0, 227.0)));
        return sprites;
    }
    
    
}
