package fluidlearn.controllers;

import fluidlearn.Risorsa;
import fluidlearn.SessioneUtente;
import fluidlearn.contributi.Commento;
import fluidlearn.contributi.Post;
import fluidlearn.corpo.Testo;
import fluidlearn.db.DBBroker;
import fluidlearn.nodi.Nodo;
import fluidlearn.plugin.Plugin;
import java.util.Date;
import java.util.List;

public class CommentaPostController {

    public Commento creaCommento(Post p) {
        Commento c = new Commento();
        c.setAzione(p);
	c.setCorpo(new Testo());
        c.setAutore(SessioneUtente.getInstance().getUserName());
        return c;
    }
    private void salvaCommentoBase(Commento c, String titolo,
            List<Nodo> nodi, List<Risorsa> risorse){
        c.setTitolo(titolo);
        for (Nodo nodo : nodi) {
            c.addNodo(nodo);
        }
        for (Risorsa risorsa : risorse) {
            c.addRisorsa(risorsa);
        }
        c.setData(new Date());
        c.setVisibilita(c.getAzione().getVisibilita());
        c.setDraft(false);
        DBBroker.salvaCommento(c);
    }

    public void salvaCommento(Commento c, String titolo, String testo,
            List<Nodo> nodi, List<Risorsa> risorse) {
        ((Testo) c.getCorpo()).setTesto(testo);
        salvaCommentoBase(c,titolo,nodi,risorse);
    }
    
    public void salvaCommentoPlugin(Commento c, String titolo,
            List<Nodo> nodi, List<Risorsa> risorse) {
        salvaCommentoBase(c,titolo,nodi,risorse);
    }
}
