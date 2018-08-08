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
import placeholder.game.sprite.entity.npc.PabloNPC;
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
        sprites.add(new placeholder.game.sprite.ambient.GrassBig(new Point2D.Double(-101.0, -63.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallHorizontal(new Point2D.Double(336.0, -12.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallHorizontal(new Point2D.Double(463.0, -12.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallHorizontal(new Point2D.Double(589.0, -12.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallVertical(new Point2D.Double(336.0, 3.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallVertical(new Point2D.Double(701.0, 3.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallVertical(new Point2D.Double(701.0, 65.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallVertical(new Point2D.Double(701.0, 128.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodFloor(new Point2D.Double(352.0, 52.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodFloor(new Point2D.Double(480.0, 52.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodFloor(new Point2D.Double(573.0, 52.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodFloor(new Point2D.Double(351.0, 100.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodFloor(new Point2D.Double(573.0, 101.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallHorizontal(new Point2D.Double(590.0, 192.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodFloor(new Point2D.Double(462.0, 100.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallVertical(new Point2D.Double(336.0, 128.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallVertical(new Point2D.Double(336.0, 65.0)));
sprites.add(new placeholder.game.sprite.ambient.WoodWallHorizontal(new Point2D.Double(336.0, 192.0)));
sprites.add(new placeholder.game.sprite.furniture.Workbench(new Point2D.Double(626.0, 67.0)));
sprites.add(new placeholder.game.sprite.ambient.NaturalStoneWall(new Point2D.Double(-96.0, -185.0)));
sprites.add(new placeholder.game.sprite.ambient.NaturalStoneWall(new Point2D.Double(414.0, -180.0)));
sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(390.0, -88.0)));
sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(770.0, -83.0)));
sprites.add(new placeholder.game.sprite.resource.woodcutting.DefaultTree(new Point2D.Double(-17.0, -51.0)));
sprites.add(new placeholder.game.sprite.ambient.GrassBig(new Point2D.Double(-98.0, -1201.0)));
sprites.add(new placeholder.game.sprite.resource.woodcutting.WillowTree(new Point2D.Double(518.0, -236.0)));
sprites.add(new placeholder.game.sprite.resource.woodcutting.WillowTree(new Point2D.Double(105.0, -246.0)));
sprites.add(new PabloNPC(new Point2D.Double(280.0, 214.0)));
        return sprites;
    }
    
    
}
