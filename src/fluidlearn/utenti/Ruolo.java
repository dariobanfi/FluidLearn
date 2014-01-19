package fluidlearn.utenti;

import fluidlearn.Permessi;

public abstract class Ruolo extends Partecipante{
    protected Partecipante part;
    
    public Ruolo(Partecipante part){
        super();
        this.part=part;
    }
    
    public boolean puo(Permessi p){
        return part.puo(p)||super.puo(p);
    }
}
