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
public class BasicBox extends Box {
    
    public BasicBox(double width, double length, double height, int cardboardGrade, boolean sealable) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.cardboardGrade = cardboardGrade;
        this.sealable = sealable;
    }
    
    public BigDecimal calculatePrice() {
        BigDecimal surfaceArea = new BigDecimal(length * height * 2 + width * height * 2 + length * width * 2);
        BigDecimal price = super.calculatePrice().add(surfaceArea.multiply(getCostOfCardboard()));
        if (sealable) {
            return price.multiply(new BigDecimal(1.1));
        } else {
            return price;
        }
    }
    
}
