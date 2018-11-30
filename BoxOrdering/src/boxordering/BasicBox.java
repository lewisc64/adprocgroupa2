
package boxordering;

import java.math.BigDecimal;

public class BasicBox extends Box {
    
    protected int cardboardGrade;
    protected boolean sealable;
    
    public BasicBox(double width, double length, double height, int cardboardGrade, boolean sealable) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.cardboardGrade = cardboardGrade;
        this.sealable = sealable;
    }
    
    private BigDecimal getCostOfCardboard() {
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
    
    public int getType() {
        return 1;
    }
    
    public BigDecimal calculatePrice() {
        BigDecimal result = calculateBasePrice().multiply(getPriceMultiplier());
        return result;
    }
        
    protected BigDecimal calculateBasePrice() {
        BigDecimal surfaceArea = new BigDecimal(length * height * 2 + width * height * 2 + length * width * 2);
        BigDecimal price = surfaceArea.multiply(getCostOfCardboard());
        return price;
    }
    
    protected BigDecimal getPriceMultiplier() {
        return new BigDecimal(sealable ? 1.1 : 1);
    }
    
}
