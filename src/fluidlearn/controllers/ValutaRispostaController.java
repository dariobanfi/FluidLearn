package fluidlearn.controllers;

import fluidlearn.Valutazione;
import fluidlearn.contributi.Risposta;
import fluidlearn.db.DBBroker;

public class ValutaRispostaController {
    
    public void valuta(Risposta r, Integer voto, String commento){
        if(voto==null && commento==null) throw new IllegalArgumentException();
        Valutazione v = new Valutazione(voto, commento);
        r.setValutazione(v);
        DBBroker.salvaValutazione(r);
    }
    
    public void cancellaValutazione(Risposta r){
        DBBroker.cancellaValutazione(r);
    }
}
