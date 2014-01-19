package fluidlearn.contributi;

import fluidlearn.Risorsa;
import fluidlearn.Valutazione;
import fluidlearn.Visibilita;
import fluidlearn.corpo.Corpo;
import fluidlearn.nodi.Nodo;
import java.util.Date;
import java.util.List;

public class Risposta extends Reazione{
    private Compito azione;
    private Valutazione valutazione;
    
    public Risposta(){
        super();
    }
    
    public Risposta(int id, String autore, String titolo, Corpo corpo, Date data, Visibilita visibilita, boolean draft, Compito azione, List<Nodo> nodi, List<Risorsa> risorse) {
        super(id, autore, titolo, corpo, data, visibilita, azione, nodi, risorse, draft);
        this.azione = azione;
    }

    @Override
    public Compito getAzione() {
        return azione;
    }

    public void setAzione(Compito azione) {
        this.azione = azione;
    }

    public Valutazione getValutazione() {
        return valutazione;
    }

    public void setValutazione(Valutazione valutazione) {
        this.valutazione = valutazione;
    }
    
}
