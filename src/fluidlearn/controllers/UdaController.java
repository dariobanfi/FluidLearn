package fluidlearn.controllers;

import fluidlearn.SessioneUtente;
import fluidlearn.Uda;
import fluidlearn.contributi.Azione;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Post;
import fluidlearn.contributi.Risposta;
import fluidlearn.db.DBBroker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UdaController {

    public List<Post> getPost() {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Uda uda = sessione.getCurrentUda();
        return DBBroker.getPost(uda);
    }

    public List<Azione> getAzioni() {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Uda uda = sessione.getCurrentUda();

        AzioniController ac = new AzioniController();

        List<Post> posts = DBBroker.getPost(uda);
        List<Compito> compiti = DBBroker.getCompiti(uda);
        List<Azione> newList = new ArrayList<Azione>();

        for (Post p : posts) {
            if (ac.puoVisualizzare(p)) {
                newList.add(p);
            }
        }

        for (Compito c : compiti) {
            if (ac.puoVisualizzare(c)) {
                Risposta r = ac.getMiaConsegna(c);
                if (r != null && r.getValutazione() != null && !r.getValutazione().isPubblicata()) {
                    r.setValutazione(null);
                }
                newList.add(c);
            }
        }

        Collections.sort(newList, new Comparator<Azione>() {

            @Override
            public int compare(Azione c1, Azione c2) {

                int result = c1.getData().compareTo(c2.getData());

                if (result == 1) {
                    return -1;
                } else if (result == -1) {
                    return 1;
                }

                return 0;

            }
        });

        return newList;

    }
}
