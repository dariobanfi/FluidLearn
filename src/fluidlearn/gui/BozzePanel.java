/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluidlearn.gui;

import fluidlearn.Risorsa;
import fluidlearn.SessioneUtente;
import fluidlearn.Uda;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Post;
import fluidlearn.controllers.BozzeController;
import fluidlearn.corpo.Artefatto;
import fluidlearn.nodi.Nodo;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Ambigioz
 */
public class BozzePanel extends javax.swing.JPanel {

    public BozzePanel() {
        initComponents();

        SessioneUtente sessione = SessioneUtente.getInstance();
        Uda currentUda = sessione.getCurrentUda();

        titleLabel.setText("Bozze per l'UDA: " + currentUda.toString());
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));
        
        BozzeController bc = new BozzeController();
        List<Post> listaBozzePost = bc.getBozzePost();
        List<Compito> listaBozzeCompito = bc.getBozzeCompito();
        
        int numAzioni = listaBozzePost.size() + listaBozzeCompito.size();
        if(numAzioni > 10)
            bozzeContainerPanel = new JPanel(new GridLayout((numAzioni/2 + 1), 2));
            

        for (final Post p : listaBozzePost) 
            mostraBozzaPost(p);

        for (final Compito c : listaBozzeCompito) 
            mostraBozzaCompito(c);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        backButt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bozzeContainerPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_END);

        backButt.setText("Indietro");
        backButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backButt)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(backButt)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);
        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        bozzeContainerPanel.setLayout(new java.awt.GridLayout(10, 0));
        jScrollPane1.setViewportView(bozzeContainerPanel);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        titleLabel.setText("Bozze per l'UDA: ");
        jPanel6.add(titleLabel);

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new UdaPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_backButtActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButt;
    private javax.swing.JPanel bozzeContainerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    private void mostraBozzaPost(final Post p) {
        //Titolo
        JLabel titoloLB = new JLabel(" Titolo: " + p.getTitolo());
        titoloLB.setFont(titoloLB.getFont().deriveFont(Font.BOLD));

        //Autore
        JLabel autoreLB = new JLabel(" Autore: " + p.getAutore());
        autoreLB.setFont(titoloLB.getFont().deriveFont(Font.BOLD));

        //Data
        JLabel dataLB = new JLabel(" Data: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(p.getData()));

        //Titolo Panel
        JPanel titoloPanel = new JPanel();
        titoloPanel.setLayout(new GridLayout(3, 1));
        titoloPanel.add(titoloLB);
        titoloPanel.add(autoreLB);
        titoloPanel.add(dataLB);

        //Testo
        JTextArea testoJTA = new JTextArea(p.getCorpo().getTesto());
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
        if (!p.getNodi().isEmpty()) {
            s = " Nodi: ";
            for (Nodo n : p.getNodi()) {
                s += "[" + n.getTitolo() + "] ";
            }
        }
        JLabel nodiLB = new JLabel(s);
        infoPostPanel.add(nodiLB);

        //Risorse
        if (!p.getRisorse().isEmpty()) {
            infoPostPanel.add(new JLabel(" Risorse: "));
            for (Risorsa r : p.getRisorse()) {
                infoPostPanel.add(new JLabel("   " + r.getLink()));
            }
        }

        //Buttons Panel
        JPanel buttonPanel = new JPanel();

        JButton cancellaButt = new JButton("Cancella");
        cancellaButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                BozzeController gpc = new BozzeController();
                gpc.cancellaBozza(p);

                JOptionPane.showMessageDialog(null, "Bozza eliminata con successo", "Message", JOptionPane.INFORMATION_MESSAGE);

                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new BozzePanel());
                Gui.root.setVisible(true);

            }
        });

        JButton modificaButt = new JButton("Modifica");
        modificaButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean plugin = p.getCorpo() instanceof Artefatto;
                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new ModificaPostPanel(p, plugin));
                Gui.root.setVisible(true);

            }
        });

        buttonPanel.add(cancellaButt);
        buttonPanel.add(modificaButt);


        //PostPanel
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new GridLayout(4, 1));
        postPanel.setBorder(BorderFactory.createMatteBorder(2, 10, 2, 0, Color.DARK_GRAY));

        postPanel.add(titoloPanel);
        postPanel.add(testoJSC);
        postPanel.add(infoPostPanel);
        postPanel.add(buttonPanel);

        //Post Container Panel
        bozzeContainerPanel.add(postPanel);
    }

    private void mostraBozzaCompito(final Compito c) {
        //Titolo
        JLabel titoloLB = new JLabel(" Titolo: " + c.getTitolo());
        titoloLB.setFont(titoloLB.getFont().deriveFont(Font.BOLD));

        //Autore
        JLabel autoreLB = new JLabel(" Autore: " + c.getAutore());
        autoreLB.setFont(titoloLB.getFont().deriveFont(Font.BOLD));

        //Data
        JLabel dataLB = new JLabel(" Data: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(c.getData()));

        //Data Consegna
        JLabel consegnaLB;
        if(c.getConsegna() != null)
            consegnaLB = new JLabel(" Data Consegna: " + new SimpleDateFormat("dd-MM-yyyy").format(c.getConsegna()));
        else
            consegnaLB = new JLabel(" Data Consegna: Nessun Limite");

        //Titolo Panel
        JPanel titoloPanel = new JPanel();
        titoloPanel.setLayout(new GridLayout(4, 1));
        titoloPanel.add(titoloLB);
        titoloPanel.add(autoreLB);
        titoloPanel.add(dataLB);
        titoloPanel.add(consegnaLB);

        //Testo
        JTextArea testoJTA = new JTextArea(c.getCorpo().getTesto());
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
        if (!c.getNodi().isEmpty()) {
            s = " Nodi: ";
            for (Nodo n : c.getNodi()) {
                s += "[" + n.getTitolo() + "] ";
            }
        }
        JLabel nodiLB = new JLabel(s);
        infoPostPanel.add(nodiLB);

        //Risorse
        if (!c.getRisorse().isEmpty()) {
            infoPostPanel.add(new JLabel(" Risorse: "));
            for (Risorsa r : c.getRisorse()) {
                infoPostPanel.add(new JLabel("   " + r.getLink()));
            }
        }

        //Buttons Panel
        JPanel buttonPanel = new JPanel();

        JButton cancellaButt = new JButton("Cancella");
        cancellaButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                BozzeController gpc = new BozzeController();
                gpc.cancellaBozza(c);

                JOptionPane.showMessageDialog(null, "Bozza eliminata con successo", "Message", JOptionPane.INFORMATION_MESSAGE);

                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new BozzePanel());
                Gui.root.setVisible(true);

            }
        });

        JButton modificaButt = new JButton("Modifica");
        modificaButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new ModificaCompitoPanel(c, c.getCorpo() instanceof Artefatto));
                Gui.root.setVisible(true);

            }
        });

        buttonPanel.add(cancellaButt);
        buttonPanel.add(modificaButt);


        //Bozza Compito Panel
        JPanel compitoPanel = new JPanel();
        compitoPanel.setLayout(new GridLayout(4, 1));
        compitoPanel.setBorder(BorderFactory.createMatteBorder(2, 10, 2, 0, new Color(178, 34, 34)));

        compitoPanel.add(titoloPanel);
        compitoPanel.add(testoJSC);
        compitoPanel.add(infoPostPanel);
        compitoPanel.add(buttonPanel);

        //Bozze Container Panel
        bozzeContainerPanel.add(compitoPanel);
    }
}
