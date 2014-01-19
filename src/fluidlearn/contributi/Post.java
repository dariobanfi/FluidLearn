package fluidlearn.contributi;

import fluidlearn.Risorsa;
import fluidlearn.Uda;
import fluidlearn.Visibilita;
import fluidlearn.corpo.Corpo;
import fluidlearn.nodi.Nodo;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Post extends Azione {

    private List<Commento> reazioni;

    public Post() {
        super();
        reazioni = new LinkedList<Commento>();
    }

    public Post(int id, String autore, String titolo, Corpo corpo, Date data,
            Visibilita visibilita, Uda uda, List<Nodo> nodi,
            List<Risorsa> risorse, boolean draft) {
        super(uda, id, titolo, visibilita, draft, nodi, corpo, data, autore,
                risorse);
        this.reazioni = new LinkedList<Commento>();
    }

    @Override
    public List<Commento> getReazioni() {
        return reazioni;
    }

    public void delReazione(Commento r) {
        reazioni.remove(r);
    }

    public void addReazione(Commento r) {
        reazioni.add(r);
    }
    
    public void setReazioni(List<Commento> reazioni){
	this.reazioni = reazioni;
    }

    public List<String> toStringList() {
        List<String> l = new LinkedList<String>();
        Format dataFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        l.add(titolo.getTesto());
        l.add(dataFormat.format(data));
        l.add(corpo.getTesto());
        if (!risorse.isEmpty()) {
            l.add("risorse: ");
            for (Risorsa r : risorse) {
                l.add("\t"+r.getLink());
            }
        }
        if (!nodi.isEmpty()) {
            String s = "nodi: [";
            for (Nodo n : nodi) {
                s += n.getTitolo() + ",";
            }
            s+="]";
            l.add(s);
        }
        return l;
    }
}
