package fluidlearn.controllers;

import fluidlearn.Risorsa;
import fluidlearn.SessioneUtente;
import fluidlearn.Visibilita;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Risposta;
import fluidlearn.corpo.Testo;
import fluidlearn.db.DBBroker;
import fluidlearn.nodi.Nodo;
import fluidlearn.plugin.Plugin;
import java.util.Date;
import java.util.List;

public class ConsegnaRispostaController {

    public static class TooLateException extends Exception {

        public TooLateException() {
        }
        
    }
    public Risposta creaRisposta(Compito c) throws TooLateException{
        if(c.getConsegna()!=null && new Date().after(c.getConsegna())){
            throw new TooLateException();
        }
        Risposta r = new Risposta();
        r.setAzione(c);
        r.setAutore(SessioneUtente.getInstance().getUserName());
        
        if(c.getPluginId()!=null){
            
            r.setCorpo(new PluginController().getPlugin(c.getPluginId()).creaArtefatto());
        }
        else{
            r.setCorpo(new Testo());
        }
        return r;
    }
    
    private void setDatiRispostaBase(Risposta r, String titolo, Visibilita visibilita,
            List<Nodo> nodi, List<Risorsa> risorse){
        
        r.setTitolo(titolo);
        r.setVisibilita(visibilita);
        
        for (Nodo nodo : nodi) 
            r.addNodo(nodo);
        
        for (Risorsa risorsa : risorse) 
            r.addRisorsa(risorsa);
        
        r.setData(new Date());
        
	DBBroker.salvaRisposta(r);
    }
    
    public void setDatiRisposta(Risposta r, String titolo, String testo, Visibilita visibilita,
            List<Nodo> nodi, List<Risorsa> risorse){
        r.setCorpo(new Testo(testo));
        setDatiRispostaBase(r, titolo, visibilita, nodi, risorse);
    }
    
    public void setDatiRispostaPlugin(Risposta r, String titolo, Visibilita visibilita,
            List<Nodo> nodi, List<Risorsa> risorse){
        setDatiRispostaBase(r, titolo, visibilita, nodi, risorse);
    }
}
