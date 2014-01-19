package fluidlearn.nodi;

import fluidlearn.Corso;
import fluidlearn.Risorsa;
import fluidlearn.Uda;
import java.util.LinkedList;
import java.util.List;

public abstract class Nodo {

    protected int id;
    protected String titolo;
    protected String testo;
    protected Corso corso;
    protected Uda uda;
    protected List<Risorsa> risorse;

    public Nodo(){
        this.risorse = new LinkedList<Risorsa>();
    }
    public Nodo(int id, String titolo, String testo, Corso corso, List<Risorsa> risorse) {
        this.id = id;
        this.titolo = titolo;
        this.testo = testo;
        this.corso = corso;
        this.risorse = risorse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Risorsa> getRisorse() {
        return risorse;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void addRisorsa(Risorsa r) {
        risorse.add(r);
    }

    ;
    public void delRisorsa(Risorsa r) {
        risorse.remove(r);
    }

    ;

    public Uda getUda() {
        return uda;
    }

    public void setUda(Uda uda) {
        this.uda = uda;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Nodo)) return false;
        return this.id==((Nodo)o).getId();
    }
}
