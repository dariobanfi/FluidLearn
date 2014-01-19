package fluidlearn.utenti;

import fluidlearn.Permessi;

public class Docente extends Ruolo{
    public Docente(Partecipante p){
        super(p);
        permessi.put(Permessi.VALUTARE_COMPITI, true);
        permessi.put(Permessi.CREARE_COMPITI, true);
        permessi.put(Permessi.VISUALIZZARE_CONTRIBUTI_DOCENTE, true);
    }
}
