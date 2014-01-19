package fluidlearn.gui;

import fluidlearn.Permessi;
import fluidlearn.Risorsa;
import fluidlearn.SessioneUtente;
import fluidlearn.Uda;
import fluidlearn.Valutazione;
import fluidlearn.contributi.Azione;
import fluidlearn.contributi.Commento;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Post;
import fluidlearn.contributi.Risposta;
import fluidlearn.controllers.CommentaPostController;
import fluidlearn.controllers.ConsegnaRispostaController;
import fluidlearn.controllers.GestisciCompitoController;
import fluidlearn.controllers.GestisciPostController;
import fluidlearn.controllers.AzioniController;
import fluidlearn.controllers.PluginController;
import fluidlearn.controllers.UdaController;
import fluidlearn.corpo.Artefatto;
import fluidlearn.nodi.Nodo;
import fluidlearn.plugin.Plugin;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class UdaPanel extends javax.swing.JPanel {
    List<Plugin> pluginList;

    public UdaPanel() {
        initComponents();

        SessioneUtente sessione = SessioneUtente.getInstance();
        Uda currentUda = sessione.getCurrentUda();

        titleLabel.setText("Benvenuto in " + currentUda.toString());
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));

        jScrollPane1.setBorder(BorderFactory.createMatteBorder(2, 10, 0, 0, Color.DARK_GRAY));
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        PluginController pc = new PluginController();
        pluginList = pc.getPlugins();
        pluginList.add(0, null);
        creaPostJCB.setModel(new javax.swing.DefaultComboBoxModel(pluginList.toArray()));
        
        creaCompitoJCB.setModel(new javax.swing.DefaultComboBoxModel(pluginList.toArray()));
        
        if (!sessione.getUtente().puo(Permessi.CREARE_POST)) {
            creaPostButt.setVisible(false);
            creaPostJCB.setVisible(false);
        }
        if (!sessione.getUtente().puo(Permessi.CREARE_COMPITI)) {
            creaCompitoButt.setVisible(false);
            creaCompitoJCB.setVisible(false);
        }

        UdaController uc = new UdaController();
        List<Azione> azioniList = uc.getAzioni();

        GridBagLayout gbl_azioni_Panel = new GridBagLayout();
        GridBagConstraints gbc_azioni_Panel = new GridBagConstraints();
        azioniContainerPanel.setLayout(gbl_azioni_Panel);

        int i = 0;

        for (final Azione a : azioniList) {

            if (a instanceof Post) {
                mostraPost((Post) a, gbc_azioni_Panel, i, gbl_azioni_Panel);
            } else if (a instanceof Compito) {
                mostraCompito((Compito) a, gbc_azioni_Panel, i, gbl_azioni_Panel);
            }

            i++;

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        creaCompitoButt = new javax.swing.JButton();
        creaPostJCB = new javax.swing.JComboBox();
        creaCompitoJCB = new javax.swing.JComboBox();
        creaPostButt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bozzeButt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        postPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        azioniContainerPanel = new javax.swing.JPanel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(588, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        backButton.setText("Indietro");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.LINE_START);

        creaCompitoButt.setText("Crea Compito");
        creaCompitoButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaCompitoButtActionPerformed(evt);
            }
        });

        creaPostJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        creaPostJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaPostJCBActionPerformed(evt);
            }
        });

        creaCompitoJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        creaCompitoJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaCompitoJCBActionPerformed(evt);
            }
        });

        creaPostButt.setText("Crea Post");
        creaPostButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaPostButtActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(213, 213, 213));
        jLabel1.setText(".                         .");

        bozzeButt.setText("Le Mie Bozze");
        bozzeButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bozzeButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(creaCompitoButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creaPostJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creaCompitoJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creaPostButt)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bozzeButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(creaPostJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creaPostButt)
                .addGap(18, 18, 18)
                .addComponent(creaCompitoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creaCompitoButt)
                .addGap(18, 18, 18)
                .addComponent(bozzeButt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        titleLabel.setText("Post per ");
        jPanel7.add(titleLabel);

        jPanel4.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        postPanel.setBorder(null);
        postPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        azioniContainerPanel.setBorder(null);
        azioniContainerPanel.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(azioniContainerPanel);

        postPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(postPanel, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void creaCompitoJCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaCompitoJCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creaCompitoJCBActionPerformed

    private void creaPostJCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaPostJCBActionPerformed

    }//GEN-LAST:event_creaPostJCBActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new CorsoPanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void creaPostButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaPostButtActionPerformed
        GestisciPostController gpc = new GestisciPostController();
        int index = creaPostJCB.getSelectedIndex();
        Plugin pl=null;
        if(index>=0){
            pl=pluginList.get(index);
        }
        Post p = gpc.creaPost(pl);

        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new ModificaPostPanel(p, pl!=null));
        Gui.root.setVisible(true);
    }//GEN-LAST:event_creaPostButtActionPerformed

    private void creaCompitoButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaCompitoButtActionPerformed
        GestisciCompitoController gcc = new GestisciCompitoController();
        int index = creaCompitoJCB.getSelectedIndex();
        Plugin pl=null;
        if(index>=0){
            pl=pluginList.get(index);
        }
        Compito c = gcc.creaCompito(pl);

        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new ModificaCompitoPanel(c, pl!=null));
        Gui.root.setVisible(true);
    }//GEN-LAST:event_creaCompitoButtActionPerformed

    private void bozzeButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bozzeButtActionPerformed
        Gui.root.getContentPane().removeAll();
        Gui.root.getContentPane().add(new BozzePanel());
        Gui.root.setVisible(true);
    }//GEN-LAST:event_bozzeButtActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel azioniContainerPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton bozzeButt;
    private javax.swing.JButton creaCompitoButt;
    private javax.swing.JComboBox creaCompitoJCB;
    private javax.swing.JButton creaPostButt;
    private javax.swing.JComboBox creaPostJCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel postPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    private void mostraPost(final Post p, GridBagConstraints gbc_azioni_Panel, int i, GridBagLayout gbl_azioni_Panel) {

        //Visibilita
        JLabel visibilitaLB = new JLabel("" + p.getVisibilita());
        visibilitaLB.setFont(visibilitaLB.getFont().deriveFont(Font.BOLD));
        visibilitaLB.setHorizontalAlignment(SwingConstants.TRAILING);

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
        titoloPanel.setLayout(new GridLayout(4, 1));
        titoloPanel.add(visibilitaLB);
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
        infoPostPanel.add(new JLabel(" Risorse: "));
        if (!p.getRisorse().isEmpty()) {
            for (Risorsa r : p.getRisorse()) {
                infoPostPanel.add(new JLabel("   " + r.getLink()));
            }
        }

        //Buttons Panel
        JPanel buttonPanel = new JPanel();

        JButton cancellaButt = new JButton("Cancella");
        cancellaButt.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                GestisciPostController gpc = new GestisciPostController();
                gpc.cancellaPost(p);

                JOptionPane.showMessageDialog(null, "Post eliminato con successo", "Message", JOptionPane.INFORMATION_MESSAGE);

                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new UdaPanel());
                Gui.root.setVisible(true);

            }
        });

        JButton ripubblicaButt = new JButton("Ripubblica");
        ripubblicaButt.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new ModificaPostPanel(p, p.getCorpo() instanceof Artefatto));
                Gui.root.setVisible(true);

            }
        });

        JButton commentaButt = new JButton("Commenta");
        commentaButt.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                CommentaPostController cpc = new CommentaPostController();
                Commento c = cpc.creaCommento(p);

                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new ModificaCommentoPanel(c));
                Gui.root.setVisible(true);

            }
        });

        AzioniController pc = new AzioniController();
        if (pc.puoCommentarePost(p)) {
            buttonPanel.add(commentaButt);
        }

        if (pc.puoRipubblicarePost(p)) {
            buttonPanel.add(ripubblicaButt);
        }

        if (pc.puoCancellarePost(p)) {
            buttonPanel.add(cancellaButt);
        }



        //PostPanel
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new GridLayout(4, 1));
        postPanel.setBorder(BorderFactory.createTitledBorder(p.getAutore()));
        postPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 2, 0, Color.DARK_GRAY));

        postPanel.add(titoloPanel);
        postPanel.add(testoJSC);
        postPanel.add(infoPostPanel);
        postPanel.add(buttonPanel);

        List<Commento> listaCommenti = p.getReazioni();

        JPanel commentiContainerPanel = new JPanel();
        GridBagLayout gbl_commenti_Panel = new GridBagLayout();
        GridBagConstraints gbc_commenti_Panel = new GridBagConstraints();
        commentiContainerPanel.setLayout(gbl_commenti_Panel);

        int j = 0;

        for (Commento c : listaCommenti) {

            //Titolo
            JLabel ctitoloLB = new JLabel(" Titolo: " + c.getTitolo());
            ctitoloLB.setFont(ctitoloLB.getFont().deriveFont(Font.BOLD));

            //Autore
            JLabel cautoreLB = new JLabel(" Autore: " + c.getAutore());
            cautoreLB.setFont(ctitoloLB.getFont().deriveFont(Font.BOLD));

            //Data
            JLabel cdataLB = new JLabel(" Data: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(c.getData()));

            //Titolo Panel
            JPanel ctitoloPanel = new JPanel();
            ctitoloPanel.setLayout(new GridLayout(3, 1));
            ctitoloPanel.add(ctitoloLB);
            ctitoloPanel.add(cautoreLB);
            ctitoloPanel.add(cdataLB);

            //Testo
            JTextArea ctestoJTA = new JTextArea(c.getCorpo().getTesto());
            ctestoJTA.setLineWrap(true);
            ctestoJTA.setWrapStyleWord(true);
            ctestoJTA.setEditable(false);
            //ctestoJTA.setBorder(BorderFactory.createEmptyBorder());
            JScrollPane ctestoJSC = new JScrollPane(ctestoJTA);
            ctestoJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            ctestoJSC.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

            //Info Panel
            JPanel cinfoPostPanel = new JPanel();
            cinfoPostPanel.setLayout(new GridLayout(5, 1));

            //Nodi
            String cs = " Nodi: ";
            if (!c.getNodi().isEmpty()) {
                cs = " Nodi: ";
                for (Nodo n : c.getNodi()) {
                    cs += "[" + n.getTitolo() + "] ";
                }
            }
            JLabel cnodiLB = new JLabel(cs);
            cinfoPostPanel.add(cnodiLB);

            //Risorse
            cinfoPostPanel.add(new JLabel(" Risorse: "));
            if (!c.getRisorse().isEmpty()) {
                for (Risorsa r : c.getRisorse()) {
                    cinfoPostPanel.add(new JLabel("   " + r.getLink()));
                }
            }

            //PostPanel
            JPanel commentoPanel = new JPanel();
            commentoPanel.setLayout(new GridLayout(3, 1));
            commentoPanel.setBorder(BorderFactory.createTitledBorder(c.getAutore()));
            commentoPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 2, 0, Color.LIGHT_GRAY));

            commentoPanel.add(ctitoloPanel);
            commentoPanel.add(ctestoJSC);
            commentoPanel.add(cinfoPostPanel);

            //Post Container Panel
            //Dimension d = commentiContainerPanel.getSize();
            //commentoPanel.setSize((int) d.getWidth(), 75);
            commentoPanel.setBackground(Color.orange);

            gbc_commenti_Panel.gridx = 0;
            gbc_commenti_Panel.gridy = j;
            gbc_commenti_Panel.gridwidth = 1;
            gbc_commenti_Panel.gridheight = 1;
            gbc_commenti_Panel.fill = GridBagConstraints.HORIZONTAL;
            gbc_commenti_Panel.weightx = 1;
            gbc_commenti_Panel.weighty = 0;
            gbc_commenti_Panel.anchor = GridBagConstraints.NORTH;
            gbl_commenti_Panel.setConstraints(commentoPanel, gbc_commenti_Panel);
            commentiContainerPanel.add(commentoPanel);

            j++;

        }


        JPanel postBigContainer = new JPanel();
        GridBagLayout gbl_postBig_Panel = new GridBagLayout();
        GridBagConstraints gbc_postBig_Panel = new GridBagConstraints();
        postBigContainer.setLayout(gbl_postBig_Panel);

        gbc_postBig_Panel.gridx = 0;
        gbc_postBig_Panel.gridy = 0;
        gbc_postBig_Panel.gridwidth = 2;
        gbc_postBig_Panel.gridheight = 1;
        gbc_postBig_Panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_postBig_Panel.insets = new Insets(0, 0, 0, 10);
        gbc_postBig_Panel.weightx = 1.5;
        gbc_postBig_Panel.weighty = 0;
        gbc_postBig_Panel.anchor = GridBagConstraints.NORTH;
        gbl_postBig_Panel.setConstraints(postPanel, gbc_postBig_Panel);
        postBigContainer.add(postPanel);

        JLabel j1 = new JLabel("");
        gbc_postBig_Panel.gridx = 2;
        gbc_postBig_Panel.gridy = 0;
        gbc_postBig_Panel.gridwidth = 1;
        gbc_postBig_Panel.gridheight = 1;
        gbc_postBig_Panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_postBig_Panel.weightx = 1;
        gbc_postBig_Panel.weighty = 0;
        gbc_postBig_Panel.anchor = GridBagConstraints.NORTH;
        gbl_postBig_Panel.setConstraints(j1, gbc_postBig_Panel);
        //postBigContainer.add(j1);

        gbc_postBig_Panel.gridx = 1;
        gbc_postBig_Panel.gridy = 1;
        gbc_postBig_Panel.gridwidth = 2;
        gbc_postBig_Panel.gridheight = 1;
        gbc_postBig_Panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_postBig_Panel.insets = new Insets(-2, 0, 0, 30);
        gbc_postBig_Panel.weighty = 0;
        gbc_postBig_Panel.anchor = GridBagConstraints.EAST;
        gbl_postBig_Panel.setConstraints(commentiContainerPanel, gbc_postBig_Panel);
        postBigContainer.add(commentiContainerPanel);

        JLabel j2 = new JLabel("");
        gbc_postBig_Panel.gridx = 0;
        gbc_postBig_Panel.gridy = 1;
        gbc_postBig_Panel.gridwidth = 1;
        gbc_postBig_Panel.gridheight = 1;
        gbc_postBig_Panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_postBig_Panel.weightx = 1;
        gbc_postBig_Panel.weighty = 0;
        gbc_postBig_Panel.anchor = GridBagConstraints.NORTH;
        gbl_postBig_Panel.setConstraints(j2, gbc_postBig_Panel);
        postBigContainer.add(j2);

        //Post Container Panel
        Dimension d = azioniContainerPanel.getSize();
        postPanel.setSize((int) d.getWidth(), 75);

        gbc_azioni_Panel.gridx = 0;
        gbc_azioni_Panel.gridy = i;
        gbc_azioni_Panel.gridwidth = 1;
        gbc_azioni_Panel.gridheight = 1;
        gbc_azioni_Panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_azioni_Panel.weightx = 1;
        gbc_azioni_Panel.weighty = 0;
        gbc_azioni_Panel.anchor = GridBagConstraints.NORTH;
        gbl_azioni_Panel.setConstraints(postBigContainer, gbc_azioni_Panel);
        azioniContainerPanel.add(postBigContainer);
    }

    private void mostraCompito(final Compito c, GridBagConstraints gbc_azioni_Panel, int i, GridBagLayout gbl_azioni_Panel) {

        //Visibilita
        JLabel visibilitaLB = new JLabel("" + c.getVisibilita());
        visibilitaLB.setFont(visibilitaLB.getFont().deriveFont(Font.BOLD));
        visibilitaLB.setHorizontalAlignment(SwingConstants.TRAILING);

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
        titoloPanel.setLayout(new GridLayout(5, 1));
        titoloPanel.add(visibilitaLB);
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
        JPanel infoCompitoPanel = new JPanel();
        infoCompitoPanel.setLayout(new GridLayout(5, 1));

        //Nodi
        String s = " Nodi: ";
        if (!c.getNodi().isEmpty()) {
            s = " Nodi: ";
            for (Nodo n : c.getNodi()) {
                s += "[" + n.getTitolo() + "] ";
            }
        }
        JLabel nodiLB = new JLabel(s);
        infoCompitoPanel.add(nodiLB);

        //Risorse
        infoCompitoPanel.add(new JLabel(" Risorse: "));
        if (!c.getRisorse().isEmpty()) {
            for (Risorsa r : c.getRisorse()) {
                infoCompitoPanel.add(new JLabel("   " + r.getLink()));
            }
        }

        //Buttons Panel
        JPanel buttonPanel = new JPanel();

        JButton cancellaButt = new JButton("Cancella");
        cancellaButt.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                GestisciCompitoController gcc = new GestisciCompitoController();
                gcc.cancellaCompito(c);

                JOptionPane.showMessageDialog(null, "Compito eliminato con successo", "Message", JOptionPane.INFORMATION_MESSAGE);

                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new UdaPanel());
                Gui.root.setVisible(true);

            }
        });

        JButton visualizzaRisposteButt = new JButton("Visualizza Risposte");
        visualizzaRisposteButt.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new RispostePanel(c));
                Gui.root.setVisible(true);

            }
        });

        JButton consegnaRispostaButt = new JButton("Consegna Risposta");
        consegnaRispostaButt.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsegnaRispostaController crc = new ConsegnaRispostaController();
                Risposta r = null;
                try {
                    r = crc.creaRisposta(c);
                } catch (ConsegnaRispostaController.TooLateException ex) {
                    ((JButton) evt.getSource()).setEnabled(false);
                    JOptionPane.showMessageDialog(null, "La data di consegna è scaduta.", "Message", JOptionPane.INFORMATION_MESSAGE);
                }

                Gui.root.getContentPane().removeAll();
                Gui.root.getContentPane().add(new ConsegnaRispostaPanel(r));
                Gui.root.setVisible(true);

            }
        });

        AzioniController ac = new AzioniController();
        if (ac.puoCancellareCompito(c)) {
            buttonPanel.add(cancellaButt);
        }

        if (ac.puoValutareCompito(c)) {
            buttonPanel.add(visualizzaRisposteButt);
        }
        
        if (ac.puoConsegnareCompito(c)) {
            buttonPanel.add(consegnaRispostaButt);
        } 
        else {
            Risposta r = ac.getMiaConsegna(c);
            if (r != null) {
                Valutazione v = r.getValutazione();
                if (v == null) {
                    buttonPanel.add(new JLabel("In attesa di valutazione"));
                } else {
                    if (v.getVoto() != null) {
                        buttonPanel.add(new JLabel("Voto: " + v.getVoto() + ". "));
                    }
                    buttonPanel.add(new JLabel("Commento: " + v.getTesto()));
                }
            }
        }

        //PostPanel
        JPanel compitoPanel = new JPanel();
        compitoPanel.setLayout(new GridLayout(4, 1));
        compitoPanel.setBorder(BorderFactory.createTitledBorder(c.getAutore()));
        compitoPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 2, 0, new Color(178, 34, 34)));

        compitoPanel.add(titoloPanel);
        compitoPanel.add(testoJSC);
        compitoPanel.add(infoCompitoPanel);
        compitoPanel.add(buttonPanel);

        Dimension d = azioniContainerPanel.getSize();
        compitoPanel.setSize((int) d.getWidth(), 75);

        gbc_azioni_Panel.gridx = 0;
        gbc_azioni_Panel.gridy = i;
        gbc_azioni_Panel.gridwidth = 1;
        gbc_azioni_Panel.gridheight = 1;
        gbc_azioni_Panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_azioni_Panel.insets = new Insets(0, 0, 0, 58);
        gbc_azioni_Panel.weightx = 1;
        gbc_azioni_Panel.weighty = 0;
        gbc_azioni_Panel.anchor = GridBagConstraints.NORTH;
        gbl_azioni_Panel.setConstraints(compitoPanel, gbc_azioni_Panel);
        azioniContainerPanel.add(compitoPanel);
    }
}
