package fluidlearn.utenti;

import fluidlearn.Permessi;

public abstract class Partecipante extends Utente{
    public Partecipante(){
        super();
        permessi.put(Permessi.CREARE_POST, true);
        permessi.put(Permessi.COMMENTARE, true);
        permessi.put(Permessi.VISUALIZZARE_CONTRIBUTI_CLASSE, true);
    }
}
