package fluidlearn.contributi;

import fluidlearn.nodi.Nodo;
import fluidlearn.Risorsa;
import fluidlearn.Visibilita;
import fluidlearn.corpo.Corpo;
import fluidlearn.corpo.Testo;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Contributo {

    protected int id;
    protected Testo titolo;
    protected Visibilita visibilita;
    protected boolean draft;
    protected List<Nodo> nodi;
    protected Corpo corpo;
    protected Date data;
    protected String autore;
    protected List<Risorsa> risorse;

    public Contributo() {
        nodi = new LinkedList<Nodo>();
        risorse = new LinkedList<Risorsa>();
        titolo = new Testo();
    }

    public Contributo(int id, String titolo, Visibilita visibilita, boolean draft, List<Nodo> nodi, Corpo corpo, Date data, String autore, List<Risorsa> risorse) {
        this.id = id;
        this.titolo = new Testo(titolo);
        this.visibilita = visibilita;
        this.draft = draft;
        this.nodi = nodi;
        this.corpo = corpo;
        this.data = data;
        this.autore = autore;
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

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCorpo(Corpo corpo) {
        this.corpo = corpo;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public void setTitolo(String titolo) {
        this.titolo.setTesto(titolo);
    }

    public void setVisibilita(Visibilita visibilita) {
        this.visibilita = visibilita;
    }

    public Corpo getCorpo() {
        return corpo;
    }

    public boolean isDraft() {
        return draft;
    }

    public List<Nodo> getNodi() {
        return nodi;
    }

    public String getTitolo() {
        return titolo.getTesto();
    }

    public Visibilita getVisibilita() {
        return visibilita;
    }

    public void addNodo(Nodo n) {
        nodi.add(n);
    }

    public void delNodo(Nodo n) {
        this.nodi.remove(n);
    }

    public void addRisorsa(Risorsa r) {
        risorse.add(r);
    }

    public void delRisorsa(Risorsa r) {
        this.risorse.remove(r);
    }
}
