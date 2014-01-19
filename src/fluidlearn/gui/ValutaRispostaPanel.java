package fluidlearn.gui;

import fluidlearn.Valutazione;
import fluidlearn.contributi.Risposta;
import fluidlearn.controllers.ValutaRispostaController;
import java.awt.Font;
import javax.swing.JOptionPane;

public class ValutaRispostaPanel extends javax.swing.JPanel {

    private final Risposta risposta;

    public ValutaRispostaPanel(Risposta r) {
        initComponents();
        this.risposta = r;

        compitodi.setText(r.getAutore());
        compitodi.setFont(compitodi.getFont().deriveFont(Font.BOLD));

        titolo.setText(r.getTitolo());
        titolo.setFont(titolo.getFont().deriveFont(Font.BOLD));

        testo.setText(r.getCorpo().getTesto());
        Valutazione v = r.getValutazione();
        if (v != null) {
            Integer votoInt = v.getVoto();
            if (votoInt != null) {
                voto.setText("" + votoInt);
            } else {
                voto.setText("");
            }
            commento.setText(v.getTesto());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        compitodi = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        backButt = new javax.swing.JButton();
        salvaValutazione = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        testo = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        voto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commento = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        titolo = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Valuta risposta di:");
        jPanel1.add(jLabel1);
        jPanel1.add(compitodi);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        backButt.setText("Indietro");
        backButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtActionPerformed(evt);
            }
        });
        jPanel7.add(backButt);

        salvaValutazione.setText("Salva Valutazione");
        salvaValutazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaValutazioneActionPerformed(evt);
            }
        });
        jPanel7.add(salvaValutazione);

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        testo.setEditable(false);
        testo.setColumns(20);
        testo.setLineWrap(true);
        testo.setRows(5);
        testo.setWrapStyleWord(true);
        jScrollPane3.setViewportView(testo);

        jPanel4.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Voto numerico");
        jPanel6.add(jLabel2);

        voto.setColumns(5);
        voto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votoActionPerformed(evt);
            }
        });
        jPanel6.add(voto);

        jLabel3.setText("Commento:");
        jPanel6.add(jLabel3);

        commento.setColumns(20);
        commento.setRows(5);
        jScrollPane1.setViewportView(commento);

        jPanel6.add(jScrollPane1);

        jPanel4.add(jPanel6, java.awt.BorderLayout.PAGE_END);
        jPanel4.add(jPanel8, java.awt.BorderLayout.LINE_END);
        jPanel4.add(jPanel9, java.awt.BorderLayout.LINE_START);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jLabel5.setText("Titolo:");
        jPanel5.add(jLabel5);
        jPanel5.add(titolo);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void salvaValutazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaValutazioneActionPerformed

        ValutaRispostaController vrc = new ValutaRispostaController();

        if (risposta.getValutazione() != null) {
            vrc.cancellaValutazione(risposta);
        }

        //Voto
        String tmpvoto = voto.getText();

        //Commento
        String comm = commento.getText();

        //Controllo Voto
        Integer votoint = null;
        if (tmpvoto != null && !(tmpvoto.equals(""))) {

            try {
                votoint = Integer.parseInt(tmpvoto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Inserire un voto numerico", "Errore", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if ((tmpvoto != null && !(tmpvoto.equals(""))) || (comm != null && !(comm.equals("")))) {

            vrc.valuta(risposta, votoint, comm);

            Gui.root.getContentPane().removeAll();
            Gui.root.getContentPane().add(new RispostePanel(risposta.getAzione()));
            Gui.root.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Inserire un voto o un commento", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_salvaValutazioneActionPerformed

    private void votoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_votoActionPerformed

    private void backButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new RispostePanel(risposta.getAzione()));
        Gui.root.setVisible(true);
    }//GEN-LAST:event_backButtActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButt;
    private javax.swing.JTextArea commento;
    private javax.swing.JLabel compitodi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton salvaValutazione;
    private javax.swing.JTextArea testo;
    private javax.swing.JLabel titolo;
    private javax.swing.JTextField voto;
    // End of variables declaration//GEN-END:variables
}
