package fluidlearn.utenti;

import fluidlearn.Permessi;
import java.util.EnumMap;
import java.util.Map;

public class Utente {
    Map<Permessi, Boolean> permessi = new EnumMap<Permessi,Boolean>(Permessi.class);
    
    public Utente(){
        for(Permessi p : Permessi.values()){
            permessi.put(p, false);
        }
    }
    
    public boolean puo(Permessi p) {
        return permessi.get(p);
    }
}
