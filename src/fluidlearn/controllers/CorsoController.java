package fluidlearn.controllers;

import fluidlearn.Corso;
import fluidlearn.SessioneUtente;
import fluidlearn.Uda;
import fluidlearn.db.DBBroker;
import fluidlearn.nodi.Nodo;
import java.util.List;


public class CorsoController {

    public List<Uda> getUda(){
        SessioneUtente sessione = SessioneUtente.getInstance();
        Corso corso = sessione.getCurrentCorso();
        return DBBroker.getUda(corso);
    }
    
    public List<Nodo> getNodi(){
        SessioneUtente sessione = SessioneUtente.getInstance();
        Corso corso = sessione.getCurrentCorso();
        return DBBroker.getNodi(corso);
    }
}
