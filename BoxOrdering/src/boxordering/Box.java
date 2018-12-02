
package boxordering;

import java.math.BigDecimal;

public abstract class Box implements Cloneable {
    
    protected double width, length, height;
    
    public abstract int getType();
    public abstract BigDecimal calculatePrice();
    protected abstract BigDecimal calculateBasePrice();
    
    protected BigDecimal getPriceMultiplier() {
        return new BigDecimal(1);
    }
    
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
