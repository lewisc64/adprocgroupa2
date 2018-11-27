/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxordering;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author up851097
 */
public abstract class Form extends JFrame {
    
    protected boolean yield = false;
    
    public abstract Object getInfo();
    
    protected void alert(String message) {
        JOptionPane.showMessageDialog(null, message, "Unable to continue.", JOptionPane.WARNING_MESSAGE);
    }
    
    protected void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
}
