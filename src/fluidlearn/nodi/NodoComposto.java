package fluidlearn.nodi;

import fluidlearn.Corso;
import fluidlearn.Risorsa;
import java.util.List;

public class NodoComposto extends Nodo {

    private List<Nodo> nodiFigli;

    public NodoComposto(List<Nodo> nodiFigli, int id, String titolo, String testo, Corso corso, List<Risorsa> risorse) {
        super(id, titolo, testo, corso, risorse);
        this.nodiFigli = nodiFigli;
    }

    public void addFiglio(Nodo figlio) {
        nodiFigli.add(figlio);
    }

    public void delFiglio(Nodo figlio) {
        nodiFigli.remove(figlio);
    }
}
