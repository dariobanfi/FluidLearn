package fluidlearn.utenti;

import fluidlearn.Permessi;

public class Studente extends Ruolo{
    public Studente(Partecipante p){
        super(p);
        permessi.put(Permessi.CONSEGNARE_COMPITI, true);
    }
}
