
package boxordering;

import java.math.BigDecimal;

public class ColourBox extends BasicBox {

    protected int colourType;

    public ColourBox(double width, double length, double height, int cardboardGrade, boolean sealable, int colourType) {
        super(width, length, height, cardboardGrade, sealable);
        this.colourType = colourType;
    }
    
    public int getType() {
        if (colourType == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    private BigDecimal getCostOfColours() {
        switch (colourType) {
            case 1:
                return new BigDecimal(0.12);
            case 2:
                return new BigDecimal(0.15);
        }
        throw new RuntimeException("Invalid colour type.");
    }

    protected BigDecimal getPriceMultiplier() {
        return super.getPriceMultiplier().add(getCostOfColours());
    }

}
