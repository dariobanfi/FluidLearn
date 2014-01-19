package fluidlearn.nodi;

import fluidlearn.Corso;
import fluidlearn.Risorsa;
import java.util.List;

public class NodoSemplice extends Nodo {
    public NodoSemplice(){
        super();
    }
    public NodoSemplice(int id, String titolo, String testo, Corso corso, List<Risorsa> risorse) {
        super(id, titolo, testo, corso, risorse);
    }
}
