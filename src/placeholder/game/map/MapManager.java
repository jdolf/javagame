/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placeholder.game.map;

import java.util.HashSet;
import java.util.Set;
import placeholder.game.screen.TickUpdatable;
import placeholder.game.screen.render.Renderable;
import placeholder.game.screen.render.Renderer;
import placeholder.game.sprite.entity.player.Player;

/**
 *
 * @author jdolf
 */
public class MapManager implements Renderable, TickUpdatable {
    
    public static final MapCode DEFAULT_MAP = MapCode.NEWBIE_LAND;
    
    private Set<Map> maps = new HashSet<Map>() ;
    private Map selectedMap;
    private Player player;
    
    public MapManager(Player player) {
        maps.add(new NewbieLandMap());
        this.player = player;
        selectMap(DEFAULT_MAP);
        if (selectedMap != null) selectedMap.addSprite(player);
    }

    public boolean hasSelectedMap() {
        if (selectedMap == null) {
            return false;
        } else {
            return true;
        }
    }

    public void selectMap(MapCode mapCode) {
        
        for (Map map : maps) {
            if (map.matchesMapCode(mapCode)) {
                this.selectedMap = map;
                map.enrichPlayer(player);
                break;
            }
        }
    }

    public Map getSelectedMap() {
        return this.selectedMap;
    }

    @Override
    public void render(Renderer renderer) {
        selectedMap.render(renderer);
    }

    @Override
    public void tickUpdate() {
        selectedMap.tickUpdate();
    }
    
    
    
}
