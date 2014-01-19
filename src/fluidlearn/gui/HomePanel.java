package fluidlearn.gui;

import fluidlearn.Corso;
import fluidlearn.Permessi;
import fluidlearn.SessioneUtente;
import fluidlearn.controllers.CorsoController;
import fluidlearn.controllers.HomeController;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomePanel extends javax.swing.JPanel {
    
    public HomePanel() {
        initComponents();
        
        HomeController hc = new HomeController();
        List<Corso> listaCorsi = hc.getCorsi();
        Iterator<Corso> iter = listaCorsi.iterator();
        
        //fillerButt.setVisible(false);
        
        gridCorsi.add(new JLabel(""));
        
        while (iter.hasNext()){
            final Corso tempCorso = iter.next();
            JButton tempButton = new JButton(tempCorso.getNome());
            tempButton.setActionCommand(""+tempCorso.getId());
            
            tempButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                    SessioneUtente.getInstance().setCurrentCorso(tempCorso);
                    SessioneUtente.getInstance().getRuoliUtente();
                    
                    corsoButtActionPerformed(evt);
                    
                }});
            
            gridCorsi.add(tempButton);
        }
        
        gridCorsi.add(new JLabel(""));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        listaCorsiPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gridCorsi = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        jPanel5.setLayout(new java.awt.BorderLayout());

        listaCorsiPanel.setBorder(null);
        listaCorsiPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Corsi");
        jPanel1.add(jLabel1);

        listaCorsiPanel.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        gridCorsi.setBorder(null);
        gridCorsi.setLayout(new java.awt.GridLayout(7, 0));
        listaCorsiPanel.add(gridCorsi, java.awt.BorderLayout.CENTER);

        jLabel2.setForeground(new java.awt.Color(213, 213, 213));
        jLabel2.setText(".                         .");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(396, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        listaCorsiPanel.add(jPanel4, java.awt.BorderLayout.LINE_END);

        backButton.setText("Indietro");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        listaCorsiPanel.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel5.add(listaCorsiPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new LoginPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void corsoButtActionPerformed(java.awt.event.ActionEvent evt) {
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new CorsoPanel());
        Gui.root.setVisible(true);
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel gridCorsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel listaCorsiPanel;
    // End of variables declaration//GEN-END:variables

}
