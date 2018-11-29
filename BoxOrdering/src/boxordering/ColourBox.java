
package boxordering;

import java.math.BigDecimal;

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

    protected BigDecimal getPriceMultiplier() {
        return super.getPriceMultiplier().add(getCostOfColours());
    }

}
