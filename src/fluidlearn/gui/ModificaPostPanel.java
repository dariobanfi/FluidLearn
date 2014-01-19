package fluidlearn.gui;

import fluidlearn.Risorsa;
import fluidlearn.Uda;
import fluidlearn.Visibilita;
import fluidlearn.contributi.Post;
import fluidlearn.controllers.CorsoController;
import fluidlearn.controllers.GestisciPostController;
import fluidlearn.nodi.Nodo;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ModificaPostPanel extends javax.swing.JPanel {

    private final Post post;
    private final boolean pl;
    List<Nodo> listaNodiCorso;
    List<Risorsa> risorse;

    public ModificaPostPanel(Post p, boolean pl) {
        initComponents();
        this.post = p;
        this.pl = pl;

        CorsoController cc = new CorsoController();
        listaNodiCorso = cc.getNodi();

        //Titolo
        titoloJTF.setText(p.getTitolo());

        //Testo
        testoJTA.setText(p.getCorpo().getTesto());
        if (pl) {
            testoJTA.setEditable(false);
        }

        if (p.getVisibilita() != null) {
            visibilitaJCB.setSelectedItem(p.getVisibilita());
        }

        //Nodi
        for (int i = 0; i < listaNodiCorso.size(); i++) {
            Nodo nodo = listaNodiCorso.get(i);
            JCheckBox tempJCB = new JCheckBox(nodo.getTitolo());
            tempJCB.setActionCommand("" + i);
            for (Nodo n : p.getNodi()) {
                if (n.equals(nodo)) {
                    tempJCB.setSelected(true);
                }
            }
            listaNodiPanel.add(tempJCB);
        }

        //Risorse
        risorse = new ArrayList<Risorsa>();
        for (Risorsa r : p.getRisorse()) {
            risorse.add(r);
            risorsePanel.add(new JLabel(r.getLink()));
        }

        if (p.getData() != null && !p.isDraft()) {
            udaJCB.setModel(new javax.swing.DefaultComboBoxModel(cc.getUda().toArray()));
            udaJCB.setVisible(true);
            udaLB.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        mostraAnteprimaButton = new javax.swing.JButton();
        annullaButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        visibilitaJCB = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        risorseJTF = new javax.swing.JTextField();
        addRisorsaButt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pulisciRisorsaButt = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        udaLB = new javax.swing.JLabel();
        udaJCB = new javax.swing.JComboBox();
        risorsePanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nodiPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        listaNodiPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titoloJTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        testoJTA = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.BorderLayout());

        mostraAnteprimaButton.setText("Mostra Anteprima");
        mostraAnteprimaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraAnteprimaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mostraAnteprimaButton);

        annullaButton.setText("Annulla");
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });
        jPanel1.add(annullaButton);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(3, 0));

        jLabel10.setText(" ");
        jPanel2.add(jLabel10);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel11);

        jPanel7.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jLabel5.setText("   ");
        jPanel7.add(jLabel5, java.awt.BorderLayout.LINE_START);

        jLabel7.setText("    ");
        jPanel7.add(jLabel7, java.awt.BorderLayout.LINE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel13.setText("Visibilità");
        jPanel3.add(jLabel13, java.awt.BorderLayout.PAGE_START);

        infoPanel.setLayout(new java.awt.GridLayout(20, 0));

        visibilitaJCB.setModel(new javax.swing.DefaultComboBoxModel(Visibilita.values()));
        infoPanel.add(visibilitaJCB);

        jLabel14.setText(" ");
        infoPanel.add(jLabel14);

        jLabel12.setText("Risorse");
        infoPanel.add(jLabel12);
        infoPanel.add(risorseJTF);

        addRisorsaButt.setText("Aggiungi Risorsa");
        addRisorsaButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRisorsaButtActionPerformed(evt);
            }
        });
        infoPanel.add(addRisorsaButt);

        jLabel3.setText(" ");
        infoPanel.add(jLabel3);

        pulisciRisorsaButt.setText("Pulisci Risorse");
        pulisciRisorsaButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulisciRisorsaButtActionPerformed(evt);
            }
        });
        infoPanel.add(pulisciRisorsaButt);

        jLabel15.setText(" ");
        infoPanel.add(jLabel15);

        udaLB.setText("UDA");
        udaLB.setVisible(false);
        infoPanel.add(udaLB);

        udaJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        udaJCB.setVisible(false);
        infoPanel.add(udaJCB);

        jPanel3.add(infoPanel, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel3, java.awt.BorderLayout.CENTER);

        risorsePanel.setLayout(new java.awt.GridLayout(10, 0));

        jLabel16.setText("   Lista Risorse");
        risorsePanel.add(jLabel16);

        jPanel7.add(risorsePanel, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new java.awt.GridLayout(2, 0));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(" ");
        jPanel12.add(jLabel8);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Nodi");
        jPanel12.add(jLabel9);

        jPanel8.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        nodiPanel.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("  ");
        nodiPanel.add(jLabel4, java.awt.BorderLayout.LINE_END);

        jPanel8.add(nodiPanel, java.awt.BorderLayout.LINE_END);

        listaNodiPanel.setLayout(new java.awt.GridLayout(20, 0));
        jPanel8.add(listaNodiPanel, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel8, java.awt.BorderLayout.LINE_END);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.GridLayout(3, 0));

        jLabel1.setText("Titolo");
        jPanel10.add(jLabel1);
        jPanel10.add(titoloJTF);

        jLabel2.setText(" ");
        jPanel10.add(jLabel2);

        jPanel9.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Testo");
        jPanel11.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        testoJTA.setColumns(20);
        testoJTA.setLineWrap(true);
        testoJTA.setRows(5);
        testoJTA.setWrapStyleWord(true);
        jScrollPane1.setViewportView(testoJTA);

        jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel9, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void mostraAnteprimaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraAnteprimaButtonActionPerformed

        if (titoloJTF.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Inserire il titolo", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (testoJTA.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Inserire il testo", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Nodo> nodiList = new ArrayList<Nodo>();
        for (Component c : listaNodiPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox tempJCB = (JCheckBox) c;
                if (tempJCB.isSelected()) {
                    nodiList.add(listaNodiCorso.get(Integer.parseInt(tempJCB.getActionCommand())));
                }
            }
        }

        GestisciPostController gpc = new GestisciPostController();

        if (udaJCB.isVisible()) {
            gpc.setUDA(this.post, (Uda) udaJCB.getSelectedItem());
        }

        if (pl) {
            gpc.setDatiPostPlugin(this.post, titoloJTF.getText(),
                    Visibilita.valueOf(visibilitaJCB.getSelectedItem().toString().toUpperCase()), nodiList, risorse);
        } else {
            gpc.setDatiPost(this.post, titoloJTF.getText(), testoJTA.getText(),
                    Visibilita.valueOf(visibilitaJCB.getSelectedItem().toString().toUpperCase()), nodiList, risorse);
        }

        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new AnteprimaPostPanel(post, pl));
        Gui.root.setVisible(true);
    }//GEN-LAST:event_mostraAnteprimaButtonActionPerformed

    private void annullaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButtonActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new UdaPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_annullaButtonActionPerformed

    private void addRisorsaButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRisorsaButtActionPerformed
        risorse.add(new Risorsa(risorseJTF.getText()));

        risorsePanel.setVisible(false);
        JLabel jlb = new JLabel(risorseJTF.getText());
        jlb.setHorizontalAlignment(SwingConstants.CENTER);
        risorsePanel.add(jlb);
        risorsePanel.setVisible(true);

        risorseJTF.setText("");
    }//GEN-LAST:event_addRisorsaButtActionPerformed

    private void pulisciRisorsaButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulisciRisorsaButtActionPerformed
        risorse = new ArrayList();
        risorsePanel.setVisible(false);
        risorsePanel.removeAll();
        risorsePanel.add(new JLabel("   Lista Risorse"));
        risorsePanel.setVisible(true);
    }//GEN-LAST:event_pulisciRisorsaButtActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRisorsaButt;
    private javax.swing.JButton annullaButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listaNodiPanel;
    private javax.swing.JButton mostraAnteprimaButton;
    private javax.swing.JPanel nodiPanel;
    private javax.swing.JButton pulisciRisorsaButt;
    private javax.swing.JTextField risorseJTF;
    private javax.swing.JPanel risorsePanel;
    private javax.swing.JTextArea testoJTA;
    private javax.swing.JTextField titoloJTF;
    private javax.swing.JComboBox udaJCB;
    private javax.swing.JLabel udaLB;
    private javax.swing.JComboBox visibilitaJCB;
    // End of variables declaration//GEN-END:variables
}
