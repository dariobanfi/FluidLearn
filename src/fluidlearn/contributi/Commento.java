package fluidlearn.contributi;

import fluidlearn.Risorsa;
import fluidlearn.Visibilita;
import fluidlearn.corpo.Corpo;
import fluidlearn.nodi.Nodo;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Commento extends Reazione {

    protected Post azione;

    public Commento() {
        super();
    }

    public Commento(int id, String autore, String titolo, Corpo corpo,
            Date data, Visibilita visibilita, Post azione, List<Nodo> nodi,
            List<Risorsa> risorse) {
        super(id, autore, titolo, corpo, data, visibilita, azione, nodi,
                risorse, false);
        this.azione = azione;
    }

    @Override
    public Post getAzione() {
        return azione;
    }

    public void setAzione(Post azione) {
        this.azione = azione;
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
