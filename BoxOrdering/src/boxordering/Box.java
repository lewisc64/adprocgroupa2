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
    protected int cardboardGrade;
    protected boolean sealable;
    
    public Box() {}
    
    protected BigDecimal getCostOfCardboard() {
        switch (cardboardGrade) {
            case 1:
                return new BigDecimal(0.55);
            case 2:
                return new BigDecimal(0.65);
            case 3:
                return new BigDecimal(0.82);
            case 4:
                return new BigDecimal(0.98);
            case 5:
                return new BigDecimal(1.5);
        }
        throw new RuntimeException("Invalid cardboard grade.");
    }
        
    public BigDecimal calculatePrice() {
        return new BigDecimal(0);
    }
    
}
