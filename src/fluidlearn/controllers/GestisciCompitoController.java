package fluidlearn.controllers;

import fluidlearn.Risorsa;
import fluidlearn.SessioneUtente;
import fluidlearn.Valutazione;
import fluidlearn.Visibilita;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Risposta;
import fluidlearn.corpo.Testo;
import fluidlearn.db.DBBroker;
import fluidlearn.nodi.Nodo;
import fluidlearn.plugin.Plugin;
import java.util.Date;
import java.util.List;

public class GestisciCompitoController {

    public Compito creaCompito(Plugin plugin) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Compito c = new Compito();
        c.setAutore(sessione.getUserName());
        c.setUda(sessione.getCurrentUda());
        if (plugin == null) {
            c.setCorpo(new Testo());
        } else {
            c.setCorpo(plugin.creaArtefatto());
            c.setPluginId(plugin.getId());
        }
        return c;
    }

    private void setDatiCompitoBase(Compito c, String titolo,
            Visibilita visibilita, List<Nodo> nodi, List<Risorsa> risorse,
            Date consegna, String pluginId) {
        c.setTitolo(titolo);
        c.setVisibilita(visibilita);
        for (Nodo nodo : nodi) {
            c.addNodo(nodo);
        }
        for (Risorsa risorsa : risorse) {
            c.addRisorsa(risorsa);
        }
        c.setConsegna(consegna);
        c.setPluginId(pluginId);
    }
    
    public void setDatiCompito(Compito c, String titolo, String testo,
            Visibilita visibilita, List<Nodo> nodi, List<Risorsa> risorse,
            Date consegna) {
        ((Testo) c.getCorpo()).setTesto(testo);
        setDatiCompitoBase(c, titolo, visibilita, nodi, risorse, consegna, null);
    }
    
    public void setDatiCompitoPlugin(Compito c, String titolo,
            Visibilita visibilita, List<Nodo> nodi, List<Risorsa> risorse,
            Date consegna, String pluginId){
        setDatiCompitoBase(c, titolo, visibilita, nodi, risorse, consegna, pluginId);
    }

    public void salvaCompito(Compito c, boolean draft) {

        if (c.isDraft()) {
            new BozzeController().cancellaBozza(c);
        }

        c.setDraft(draft);
        c.setData(new Date());
        DBBroker.salvaCompito(c);
    }

    public void cancellaCompito(Compito c) {
        DBBroker.cancellaCompito(c);
    }

    public void pubblicaValutazioni(Compito c) {
        for (Risposta r : c.getReazioni()) {
            Valutazione v = r.getValutazione();
            if (v != null) {
                v.setPubblicata(true);
                DBBroker.cancellaValutazione(r);
                DBBroker.salvaValutazione(r);
            }
        }
    }
}
