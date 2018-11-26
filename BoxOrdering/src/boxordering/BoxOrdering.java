/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxordering;

/**
 *
 * @author up851097
 */
public class BoxOrdering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Box box = new ReinforcedBox(4, 6, 2, 2, true, 2, false);
        System.out.println(box.calculatePrice());
        
    }
    

}
