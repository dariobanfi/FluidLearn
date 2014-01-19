package fluidlearn.controllers;

import fluidlearn.Permessi;
import fluidlearn.SessioneUtente;
import fluidlearn.Visibilita;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Contributo;
import fluidlearn.contributi.Post;
import fluidlearn.contributi.Risposta;
import fluidlearn.utenti.Utente;
import java.util.Date;

public class AzioniController {

    public boolean puoCommentarePost(Post p) {
        return SessioneUtente.getInstance().getUtente().puo(Permessi.COMMENTARE);
    }

    public boolean puoCancellarePost(Post p) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Utente utente = sessione.getUtente();
        return utente.puo(Permessi.CANCELLARE_POST)
                || sessione.getUserName().equals(p.getAutore());
    }

    public boolean puoRipubblicarePost(Post p) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Utente utente = sessione.getUtente();
        return utente.puo(Permessi.CREARE_POST)
                && sessione.getUserName().equals(p.getAutore());
    }

    public boolean puoCancellareCompito(Compito c) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Utente utente = sessione.getUtente();
        return utente.puo(Permessi.VALUTARE_COMPITI)
                || sessione.getUserName().equals(c.getAutore());
    }

    public boolean puoValutareCompito(Compito c) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Utente utente = sessione.getUtente();
        return utente.puo(Permessi.VALUTARE_COMPITI)
                || sessione.getUserName().equals(c.getAutore());
    }

    public boolean puoConsegnareCompito(Compito c) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Utente utente = sessione.getUtente();
        
        boolean consegna;
        if(c.getConsegna() != null)
            consegna = new Date().before(c.getConsegna());
        else
            consegna = true;
        
        return utente.puo(Permessi.CONSEGNARE_COMPITI) && (getMiaConsegna(c) == null) && consegna;
    }

    public Risposta getMiaConsegna(Compito c) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        String username = sessione.getUserName();
        for (Risposta r : c.getReazioni()) {
            if (r.getAutore().equals(username)) {
                return r;
            }
        }
        return null;
    }

    public boolean puoVisualizzare(Contributo c) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Utente utente = sessione.getUtente();
        String username = sessione.getUserName();
        Visibilita v = c.getVisibilita();
        return v.equals(Visibilita.PUBBLICO)
                || c.getAutore().equals(username)
                || v.equals(Visibilita.CLASSE) && utente.puo(Permessi.VISUALIZZARE_CONTRIBUTI_CLASSE)
                || v.equals(Visibilita.DOCENTE) && utente.puo(Permessi.VISUALIZZARE_CONTRIBUTI_DOCENTE);
    }
}
