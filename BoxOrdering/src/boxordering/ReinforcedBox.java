
package boxordering;

import java.math.BigDecimal;

public class ReinforcedBox extends ColourBox {
    
    private boolean corners;
    
    public ReinforcedBox(double width, double length, double height, int cardboardGrade, boolean sealable, int colourType, boolean corners) {
        super(width, length, height, cardboardGrade, sealable, colourType);
        this.corners = corners;
    }
    
    protected BigDecimal getPriceMultiplier() {
        return super.getPriceMultiplier().add(new BigDecimal(corners ? 1.25 : 1.13));
    }
    
    
}
