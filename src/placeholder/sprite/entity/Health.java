package placeholder.sprite.entity;

import java.util.ArrayList;
import java.util.List;
import placeholder.util.Amount;

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
        super.remove(amount);
        System.out.println("Removed " + amount + " HP");
        notifyListener();
    }

    @Override
    public void add(int amount) {
        super.add(amount);
        notifyListener();
    }
    
    public void addHealthChangedListener(HealthChangedListener listener) {
        this.listener.add(listener);
    }
    
    private void notifyListener() {
        listener.forEach((listener) -> {
            listener.onHealthChanged();
        });
    }
    
}
