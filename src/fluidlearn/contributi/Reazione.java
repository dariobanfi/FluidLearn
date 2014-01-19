package fluidlearn.contributi;

import fluidlearn.Risorsa;
import fluidlearn.Visibilita;
import fluidlearn.corpo.Corpo;
import fluidlearn.nodi.Nodo;
import java.util.Date;
import java.util.List;

public abstract class Reazione extends Contributo {

    protected Azione azione;

    public Reazione() {
        super();
    }

    public Reazione(int id, String autore, String titolo, Corpo corpo,
            Date data, Visibilita visibilita, Azione azione, List<Nodo> nodi,
            List<Risorsa> risorse, boolean draft) {
        super(id, titolo, visibilita, draft, nodi, corpo, data, autore,
                risorse);
        this.azione = azione;
    }

    public Azione getAzione() {
        return azione;
    }

    public void setAzione(Azione azione) {
        this.azione = azione;
    }
}
