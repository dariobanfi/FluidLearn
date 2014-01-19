package fluidlearn.contributi;

import fluidlearn.Risorsa;
import fluidlearn.Uda;
import fluidlearn.Visibilita;
import fluidlearn.corpo.Corpo;
import fluidlearn.nodi.Nodo;
import java.util.Date;
import java.util.List;

public abstract class Azione extends Contributo {

    protected Uda uda;

    public Azione() {
        super();
    }

    public Azione(Uda uda, int id, String titolo, Visibilita visibilita, boolean draft, List<Nodo> nodi, Corpo corpo, Date data, String autore, List<Risorsa> risorse) {
        super(id, titolo, visibilita, draft, nodi, corpo, data, autore, risorse);
        this.uda = uda;
    }

    public void setUda(Uda uda) {
        this.uda = uda;
    }

    public Uda getUda() {
        return uda;
    }

    abstract public List getReazioni();
}
