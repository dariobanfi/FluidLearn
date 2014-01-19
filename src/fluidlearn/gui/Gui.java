package fluidlearn.gui;

import java.awt.Frame;
import javax.swing.JFrame;

public class Gui {
    
    public static JFrame root;
    
    public Gui() {
        
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) {}
        catch (InstantiationException ex) {}
        catch (IllegalAccessException ex) {}
        catch (javax.swing.UnsupportedLookAndFeelException ex) {}

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                root = new JFrame("FluidLearn");
                root.setExtendedState(Frame.MAXIMIZED_BOTH);
                root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                root.setSize(600, 450);
                root.setVisible(true);
                
                root.getContentPane().add(new LoginPanel());
            }
        });
    }
        
}
