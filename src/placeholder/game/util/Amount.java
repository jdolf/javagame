package placeholder.game.util;

/**
 *
 * @author jdolf
 */
public class Amount {
    protected int maxAmount;
    protected int minAmount;
    private int amount;
    
    public Amount(int minAmount, int maxAmount, int startAmount) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.amount = startAmount;
    }
    
    public void add(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount can't be negative!");
        
        if (this.amount + amount > maxAmount) {
            this.amount = this.maxAmount;
        } else {
            this.amount += amount;
        }
    }
    
    public void remove(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount can't be negative!");
        
        if (this.amount - amount < minAmount) {
            this.amount = this.minAmount;
        } else {
            this.amount -= amount;
        }
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public int getMaxAmount() {
        return this.maxAmount;
    }
    
    public int getMinAmount() {
        return this.minAmount;
    }
}
