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
public class ColourBox extends BasicBox {
    
    protected int colourType;

    public ColourBox(double width, double length, double height, int cardboardGrade, boolean sealable, int colourType) {
        super(width, length, height, cardboardGrade, sealable);
        this.colourType = colourType;
    }
    
    protected BigDecimal getCostOfColours() {
        switch (colourType) {
            case 1:
                return new BigDecimal(1.12);
            case 2:
                return new BigDecimal(1.15);
        }
        throw new RuntimeException("Invalid colour type.");
    }
    
    public BigDecimal calculatePrice() {
        return super.calculatePrice().multiply(getCostOfColours());
    }
    
}
