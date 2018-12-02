
package boxordering;

import java.math.BigDecimal;

public abstract class Box implements Cloneable {
    
    protected double width, length, height;
    
    /**
     * Derives the type of the box based on what level of hierarchy it is at,
     * and fields relevant to that subclass.
     * @return 
     */
    public abstract int getType();
    
    /**
     * Calculates the total cost of the box.
     * @return The total cost of the box, including percentage increases.
     */
    public abstract BigDecimal calculatePrice();
    
    /**
     * Calculates the cost of the box before any percentage increases.
     * @return Price
     */
    protected abstract BigDecimal calculateBasePrice();
    
    /**
     * 
     * @return A string representing the dimensions.
     */
    public String getDimensions() {
        return width + " x " + length + " x " + height + " (m)";
    }
    
    /**
     * Gets the percentage increase for the price.
     * @return BigDecimal representing the price multiplier.
     */
    protected BigDecimal getPriceMultiplier() {
        return new BigDecimal(1);
    }
    
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
