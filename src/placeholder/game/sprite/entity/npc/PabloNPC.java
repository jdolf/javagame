package placeholder.game.sprite.entity.npc;

import java.util.Arrays;
import java.util.List;
import placeholder.game.util.Dimension;
import placeholder.game.util.Point;
import javafx.scene.image.Image;
import placeholder.game.screen.ImageContainer;
import placeholder.game.screen.overlay.window.dialog.Answer;
import placeholder.game.screen.overlay.window.dialog.Dialog;
import placeholder.game.screen.overlay.window.dialog.DialogSection;
import placeholder.game.screen.overlay.window.dialog.DialogWindow;
import placeholder.game.screen.overlay.window.dialog.SimpleDialogSection;
import placeholder.game.sprite.entity.player.Player;
import static placeholder.game.sprite.furniture.Anvil.IMAGE_NAME;

/**
 *
 * @author jdolf
 */
public class PabloNPC extends NPC {
    
    public static final Dimension DIMENSION = new Dimension(21, 32);
    public static final String IMAGE_NAME = "pablo.png";
    
    public PabloNPC(Point location) {
        super(DIMENSION, location, ImageContainer.getInstance().getImage(IMAGE_NAME));
    }

    @Override
    public void onInteraction(Player player) {
        List<DialogSection> sections = Arrays.asList(
            new SimpleDialogSection(1, this.name, "Dies ist ein Test.", new Answer(2)),
            new SimpleDialogSection(2, this.name, "Noch ein Test.", new Answer(0))
        );
        Dialog dialog = new Dialog(sections);
    }
    
}
