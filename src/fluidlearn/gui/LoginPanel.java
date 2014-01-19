package fluidlearn.gui;

import fluidlearn.SessioneUtente;
import fluidlearn.controllers.LoginController;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class LoginPanel extends javax.swing.JPanel {

    public LoginPanel() {
        initComponents();
        
        LoginController lc = new LoginController();
        lc.logout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginLB = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        loginButt = new javax.swing.JButton();
        loginGuestButt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        usernameJTF = new javax.swing.JTextField("Tatino");
        passwordJPF = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        loginLB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLB.setText("Login");
        jPanel1.add(loginLB);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        loginButt.setText("Login");
        loginButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtActionPerformed(evt);
            }
        });
        jPanel2.add(loginButt);

        loginGuestButt.setText("Login as Ospite");
        loginGuestButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginGuestButtActionPerformed(evt);
            }
        });
        jPanel2.add(loginGuestButt);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        jLabel2.setText(" ");
        jPanel4.add(jLabel2);

        jPanel5.setLayout(new java.awt.GridLayout(10, 0));

        jLabel4.setText(" ");
        jPanel5.add(jLabel4);

        jLabel5.setText(" ");
        jPanel5.add(jLabel5);
        jPanel5.add(jLabel6);

        jLabel7.setText(" ");
        jPanel5.add(jLabel7);
        jPanel5.add(usernameJTF);

        passwordJPF.setText("asd");
        jPanel5.add(passwordJPF);

        jLabel8.setText(" ");
        jPanel5.add(jLabel8);

        jLabel9.setText(" ");
        jPanel5.add(jLabel9);

        jLabel10.setText(" ");
        jPanel5.add(jLabel10);

        jLabel11.setText(" ");
        jPanel5.add(jLabel11);

        jPanel4.add(jPanel5);

        jLabel3.setText(" ");
        jPanel4.add(jLabel3);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtActionPerformed
        if (verifyFields()) {
            LoginController lc = new LoginController();
            lc.login(usernameJTF.getText(), passwordJPF.getText());
            if(SessioneUtente.getInstance().isLogged()){
                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new HomePanel());
                Gui.root.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login information is wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fill all fields before pressing the Login button.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtActionPerformed

    private void loginGuestButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginGuestButtActionPerformed
        LoginController lc = new LoginController();
        lc.loginGuest();
        
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new HomePanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_loginGuestButtActionPerformed

    private boolean verifyFields() {
        String usr = usernameJTF.getText();
        String pwd = passwordJPF.getText();

        if (usr != null && !(usr.equals("")) && pwd != null && !(pwd.equals(""))) {
            return true;
        }

        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton loginButt;
    private javax.swing.JButton loginGuestButt;
    private javax.swing.JLabel loginLB;
    private javax.swing.JPasswordField passwordJPF;
    private javax.swing.JTextField usernameJTF;
    // End of variables declaration//GEN-END:variables
}
