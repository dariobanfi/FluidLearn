package fluidlearn.gui;

import fluidlearn.Risorsa;
import fluidlearn.contributi.Post;
import fluidlearn.controllers.GestisciPostController;
import fluidlearn.nodi.Nodo;
import fluidlearn.plugin.Plugin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AnteprimaPostPanel extends javax.swing.JPanel {

    private final Post post;
    private final boolean pl;

    public AnteprimaPostPanel(final Post p, boolean pl) {
        initComponents();

        this.post = p;
        this.pl=pl;

        //Titolo
        JLabel titoloLB = new JLabel(" " + post.getTitolo());
        titoloLB.setFont(titoloLB.getFont().deriveFont(Font.BOLD));

        //Autore
        JLabel autoreLB = new JLabel(" Autore: " + post.getAutore());
        autoreLB.setFont(titoloLB.getFont().deriveFont(Font.BOLD));

        //Titolo Panel
        JPanel titoloPanel = new JPanel();
        titoloPanel.setLayout(new GridLayout(2, 1));
        titoloPanel.add(titoloLB);
        titoloPanel.add(autoreLB);

        //Testo
        JTextArea testoJTA = new JTextArea(post.getCorpo().getTesto());
        testoJTA.setLineWrap(true);
        testoJTA.setWrapStyleWord(true);
        testoJTA.setEditable(false);
        JScrollPane testoJSC = new JScrollPane(testoJTA);
        testoJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Info Panel
        JPanel infoPostPanel = new JPanel();
        infoPostPanel.setLayout(new GridLayout(5, 1));

        //Nodi
        String s = " Nodi: ";
        if (!post.getNodi().isEmpty()) {
            s = " Nodi: ";
            for (Nodo n : post.getNodi()) {
                s += "[" + n.getTitolo() + "] ";
            }
        }
        JLabel nodiLB = new JLabel(s);
        infoPostPanel.add(nodiLB);

        //Risorse
        infoPostPanel.add(new JLabel(" Risorse: "));
        if (!post.getRisorse().isEmpty()) {
            for (Risorsa r : post.getRisorse()) {
                infoPostPanel.add(new JLabel("   " + r.getLink()));
            }
        }

        //PostPanel
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new GridLayout(3, 1));
        postPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 2, 0, Color.DARK_GRAY));

        postPanel.add(titoloPanel);
        postPanel.add(testoJSC);
        postPanel.add(infoPostPanel);

        Dimension d = anteprimaPanel.getSize();
        postPanel.setSize((int) d.getWidth(), 75);

        //Post Container Panel
        anteprimaPanel.add(new JLabel(""));
        anteprimaPanel.add(postPanel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        saveButt = new javax.swing.JButton();
        draftButt = new javax.swing.JButton();
        editButt = new javax.swing.JButton();
        cancelButt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        anteprimaPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        saveButt.setText("Salva");
        saveButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtActionPerformed(evt);
            }
        });
        jPanel1.add(saveButt);

        draftButt.setText("Salva come Bozza");
        draftButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draftButtActionPerformed(evt);
            }
        });
        jPanel1.add(draftButt);

        editButt.setText("Modifica");
        editButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtActionPerformed(evt);
            }
        });
        jPanel1.add(editButt);

        cancelButt.setText("Annulla Pubblicazione");
        cancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButt);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.LINE_START);

        anteprimaPanel.setLayout(new java.awt.GridLayout(3, 0));
        jPanel2.add(anteprimaPanel, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtActionPerformed
        GestisciPostController gpc = new GestisciPostController();
        gpc.salvaPost(this.post, false);
        JOptionPane.showMessageDialog(this, "Post salvato con successo", "Message", JOptionPane.INFORMATION_MESSAGE);

        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new UdaPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_saveButtActionPerformed

    private void draftButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draftButtActionPerformed
        GestisciPostController gpc = new GestisciPostController();
        gpc.salvaPost(this.post, true);
        JOptionPane.showMessageDialog(this, "Post salvato come Bozza", "Message", JOptionPane.INFORMATION_MESSAGE);

        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new UdaPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_draftButtActionPerformed

    private void editButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new ModificaPostPanel(this.post, pl));
        Gui.root.setVisible(true);
    }//GEN-LAST:event_editButtActionPerformed

    private void cancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtActionPerformed
        JOptionPane.showMessageDialog(this, "Pubblicazione annullata con successo", "Message", JOptionPane.INFORMATION_MESSAGE);

        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new UdaPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_cancelButtActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anteprimaPanel;
    private javax.swing.JButton cancelButt;
    private javax.swing.JButton draftButt;
    private javax.swing.JButton editButt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton saveButt;
    // End of variables declaration//GEN-END:variables
}
