/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxordering;

import java.math.BigDecimal;

/**
 *
 * @author up851097
 */
public abstract class Box {
    
    protected double width, length, height;
    
    public abstract BigDecimal calculatePrice();
    protected abstract BigDecimal calculateBasePrice();
    protected abstract BigDecimal getPriceMultiplier();
    
}
