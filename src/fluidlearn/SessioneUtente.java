package fluidlearn;

import fluidlearn.db.DBBroker;
import fluidlearn.utenti.Docente;
import fluidlearn.utenti.Moderatore;
import fluidlearn.utenti.Partecipante;
import fluidlearn.utenti.PartecipanteImpl;
import fluidlearn.utenti.Studente;
import fluidlearn.utenti.Utente;
import java.util.List;

public class SessioneUtente {

    private static SessioneUtente instance;
    private Utente utente;
    private int userID;
    private String userName;
    private boolean isLogged;
    private Uda currentUda;
    private Corso currentCorso;

    private SessioneUtente() {
        isLogged = false;
        utente = new Utente();
    }

    public static SessioneUtente getInstance() {
        if (instance == null) {
            instance = new SessioneUtente();
        }

        return instance;
    }
    
    public void reset() {
        instance = new SessioneUtente();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public Corso getCurrentCorso() {
        return currentCorso;
    }

    public void setCurrentCorso(Corso currentCorso) {
        this.currentCorso = currentCorso;
    }

    public Uda getCurrentUda() {
        return currentUda;
    }

    public void setCurrentUda(Uda currentUda) {
        this.currentUda = currentUda;
    }

    public Utente getUtente() {
        return utente;
    }

    public void getRuoliUtente() {
        if (!isLogged) {
            return;
        }
        List<String> ruoli = DBBroker.getRuoliCorso(userID, this.currentCorso.getId());

        if (ruoli.isEmpty()) {
            utente = new Utente();
        } else {
            utente = addRuolo(new PartecipanteImpl(), ruoli);
        }
    }

    private Partecipante addRuolo(Partecipante p, List<String> ruoli) {
        if (ruoli.isEmpty()) {
            return p;
        }
        String ruolo = ruoli.remove(0);
        if (ruolo.equals("studente")) {
            return new Studente(addRuolo(p, ruoli));
        } else if (ruolo.equals("docente")) {
            return new Docente(addRuolo(p, ruoli));
        } else if (ruolo.equals("moderatore")) {
            return new Moderatore(addRuolo(p, ruoli));
        } else {
            return null;
        }
    }
}
