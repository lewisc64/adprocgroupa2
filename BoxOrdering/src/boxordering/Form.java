
package boxordering;

import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public abstract class Form extends JDialog {
    
    protected boolean valid = false;
    
    public Form() {
        setModalityType(ModalityType.APPLICATION_MODAL);
    }
    
    public abstract Object getInfo();
    
    public boolean isValid() {
        return valid;
    }
    
    protected void showWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Unable to Continue", JOptionPane.WARNING_MESSAGE);
    }
    
    protected void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
}
