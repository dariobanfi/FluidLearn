package fluidlearn.utenti;

import fluidlearn.Permessi;

public class Moderatore extends Ruolo{
    public Moderatore(Partecipante p){
        super(p);
        permessi.put(Permessi.CANCELLARE_POST, true);
        permessi.put(Permessi.VISUALIZZARE_CONTRIBUTI_DOCENTE, true);
    }
    
}
