package placeholder.game.sprite.entity;

import java.util.ArrayList;
import java.util.List;
import placeholder.game.util.Amount;

/**
 *
 * @author jdolf
 */
public class Health extends Amount {
    
    public static final int MIN_HEALTH = 0;
    
    private List<HealthChangedListener> listener = new ArrayList();
    
    public Health(int initMaxHealth) {
        super(MIN_HEALTH, initMaxHealth, initMaxHealth);
    }

    @Override
    public void remove(int amount) {
        int previous = this.getAmount();
        super.remove(amount);
        System.out.println("Removed " + amount + " HP");
        notifyListener(previous);
    }

    @Override
    public void add(int amount) {
        int previous = this.getAmount();
        super.add(amount);
        notifyListener(previous);
    }
    
    public void addHealthChangedListener(HealthChangedListener listener) {
        this.listener.add(listener);
    }
    
    private void notifyListener(int previousAmount) {
        listener.forEach((listener) -> {
            listener.onHealthChanged(this.getAmount() - previousAmount);
        });
    }
    
}
