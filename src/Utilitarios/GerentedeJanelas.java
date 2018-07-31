package Utilitarios;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Ncesar
 */
public class GerentedeJanelas {
    
    private static JDesktopPane jDesktopPane;
    
    public GerentedeJanelas(JDesktopPane jDesktopPane){
        GerentedeJanelas.jDesktopPane = jDesktopPane;
    }
    
    public void abrirJanelas(JInternalFrame jInternalFrame) {
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.getFocusOwner();
            try {
                jInternalFrame.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(GerentedeJanelas.class.getName()).log(Level.SEVERE, null, ex);
            }         
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
        }

    }
    
}
