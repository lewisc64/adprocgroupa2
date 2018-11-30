
package boxordering;

import java.math.BigDecimal;

public abstract class Box {
    
    protected double width, length, height;
    
    public abstract int getType();
    public abstract BigDecimal calculatePrice();
    protected abstract BigDecimal calculateBasePrice();
    protected abstract BigDecimal getPriceMultiplier();
    
}
