package fluidlearn.gui;

import fluidlearn.Valutazione;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Risposta;
import fluidlearn.controllers.GestisciCompitoController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RispostePanel extends javax.swing.JPanel {

    private Compito c;

    public RispostePanel(Compito c) {
        initComponents();
        this.c = c;

        titleLabel.setText("Bozze per il Compito: " + c.getTitolo());
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));

        List<Risposta> rispostaList = c.getReazioni();

        JPanel rispostaContainerPanel = new JPanel();
        GridBagLayout gbl_risposta_Panel = new GridBagLayout();
        GridBagConstraints gbc_risposta_Panel = new GridBagConstraints();
        rispostaContainerPanel.setLayout(gbl_risposta_Panel);

        int i = 0;

        for (final Risposta risp : rispostaList) {


            //Autore
            JLabel autoreLB = new JLabel("  Autore: " + risp.getAutore());
            autoreLB.setFont(autoreLB.getFont().deriveFont(Font.BOLD));

            //Titolo
            JLabel titoloLB = new JLabel("  Titolo: " + risp.getTitolo());
            titoloLB.setFont(titoloLB.getFont().deriveFont(Font.BOLD));

            //Data
            JLabel dataLB = new JLabel("  Data: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(risp.getData()));

            //Valuta Button
            JButton valutaButt = new JButton("Valuta");
            valutaButt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    Gui.root.getContentPane().removeAll();
                    Gui.root.getContentPane().add(new ValutaRispostaPanel(risp));
                    Gui.root.setVisible(true);

                }
            });

            //Valutato
            String valutato;
            Valutazione v = risp.getValutazione();
            
            if (v != null) {
                valutato = "  " + v.getVoto() + " " + v.getTesto();
            } else {
                valutato = "  [Non valutato]";
            }

            JLabel valutatoLB = new JLabel(valutato);
            valutatoLB.setFont(valutatoLB.getFont().deriveFont(Font.BOLD));
            
            JLabel pubblicataLB = new JLabel("[Valutazione Pubblicata]");
            pubblicataLB.setFont(pubblicataLB.getFont().deriveFont(Font.BOLD));

            //Risposta Panel
            JPanel rispostaPanel = new JPanel();
            rispostaPanel.setLayout(new GridLayout(1, 10));
            rispostaPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 2, 0, Color.ORANGE));
            rispostaPanel.add(autoreLB);
            rispostaPanel.add(titoloLB);
            rispostaPanel.add(dataLB);
            rispostaPanel.add(valutatoLB);
            
            if(v != null && v.isPubblicata())
                rispostaPanel.add(pubblicataLB);
            else
                rispostaPanel.add(valutaButt);

            gbc_risposta_Panel.gridx = 0;
            gbc_risposta_Panel.gridy = i;
            gbc_risposta_Panel.gridwidth = 1;
            gbc_risposta_Panel.gridheight = 1;
            gbc_risposta_Panel.fill = GridBagConstraints.HORIZONTAL;
            gbc_risposta_Panel.insets = new Insets(0, 0, 3, 0);
            gbc_risposta_Panel.weightx = 1;
            gbc_risposta_Panel.weighty = 0;
            gbc_risposta_Panel.anchor = GridBagConstraints.NORTH;
            gbl_risposta_Panel.setConstraints(rispostaPanel, gbc_risposta_Panel);
            rispostaContainerPanel.add(rispostaPanel);

            i++;

        }

        containerPanel.add(rispostaContainerPanel, BorderLayout.CENTER);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        pubblicaButt = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        containerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Indietro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel5.add(jPanel3, java.awt.BorderLayout.LINE_START);

        pubblicaButt.setText("Pubblica Valutazioni");
        pubblicaButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubblicaButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pubblicaButt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(pubblicaButt)
                .addContainerGap())
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.BorderLayout());

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Risposte");
        jPanel9.add(titleLabel, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel10.setLayout(new java.awt.BorderLayout());

        containerPanel.setLayout(new java.awt.BorderLayout());
        jScrollPane2.setViewportView(containerPanel);

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new UdaPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pubblicaButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubblicaButtActionPerformed
        
        GestisciCompitoController gcc = new GestisciCompitoController();
        gcc.pubblicaValutazioni(c);
        
        JOptionPane.showMessageDialog(null, "Valutazioni pubblicate con successo", "Message", JOptionPane.INFORMATION_MESSAGE);
        
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new RispostePanel(c));
        Gui.root.setVisible(true);
    }//GEN-LAST:event_pubblicaButtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pubblicaButt;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
