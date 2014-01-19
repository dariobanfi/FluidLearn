package fluidlearn.controllers;

import fluidlearn.Risorsa;
import fluidlearn.SessioneUtente;
import fluidlearn.Uda;
import fluidlearn.Visibilita;
import fluidlearn.contributi.Post;
import fluidlearn.corpo.Testo;
import fluidlearn.db.DBBroker;
import fluidlearn.nodi.Nodo;
import fluidlearn.plugin.Plugin;
import java.util.Date;
import java.util.List;

public class GestisciPostController {

    public Post creaPost(Plugin plugin) {
        SessioneUtente sessione = SessioneUtente.getInstance();
        Post p = new Post();
        p.setAutore(sessione.getUserName());
        p.setUda(sessione.getCurrentUda());
        if (plugin == null) {
            p.setCorpo(new Testo());
        } else {
            p.setCorpo(plugin.creaArtefatto());
        }
        return p;
    }
    
    private void setDatiPostBase(Post p, String titolo, Visibilita visibilita,
            List<Nodo> nodi, List<Risorsa> risorse){
        p.setTitolo(titolo);
        p.setVisibilita(visibilita);
        p.getNodi().clear();
        for (Nodo nodo : nodi) {
            p.addNodo(nodo);
        }
        p.getRisorse().clear();
        for (Risorsa risorsa : risorse) {
            p.addRisorsa(risorsa);
        }
    }

    public void setDatiPost(Post p, String titolo, String testo,
            Visibilita visibilita, List<Nodo> nodi, List<Risorsa> risorse) {
        ((Testo) p.getCorpo()).setTesto(testo);
        setDatiPostBase(p,titolo,visibilita,nodi,risorse);
    }
    
    public void setDatiPostPlugin(Post p, String titolo, Visibilita visibilita,
            List<Nodo> nodi, List<Risorsa> risorse) {
        setDatiPostBase(p,titolo,visibilita,nodi,risorse);
    }
    
    public void setUDA(Post p, Uda uda){
        p.setUda(uda);
    }

    public void salvaPost(Post p, boolean draft) {
        
        if(p.isDraft())
            new BozzeController().cancellaBozza(p);
        
        p.setDraft(draft);
        p.setData(new Date());
        DBBroker.salvaPost(p);
    }
    
    public void cancellaPost(Post p){
        DBBroker.cancellaPost(p);
    }
}
