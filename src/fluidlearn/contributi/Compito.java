package fluidlearn.contributi;

import fluidlearn.Risorsa;
import fluidlearn.Uda;
import fluidlearn.Visibilita;
import fluidlearn.corpo.Corpo;
import fluidlearn.nodi.Nodo;
import fluidlearn.utenti.Utente;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Compito extends Azione{
    private List<Risposta> reazioni;
    private Date consegna;
    private String pluginId;

    public Compito(){
        reazioni = new LinkedList<Risposta>();
    }
    public Compito(int id, String autore, String titolo, Corpo corpo, Date data, Visibilita visibilita, Uda uda, List<Nodo> nodi, List<Risorsa> risorse, boolean draft, Date consegna, String pluginId) {
	super(uda, id, titolo, visibilita, draft, nodi, corpo, data, autore, risorse);
	this.consegna = consegna;
	this.pluginId = pluginId;
    }
    
    
    
    @Override
    public List<Risposta> getReazioni() {
        return reazioni;
    }
    
    public void delReazione(Risposta r) {
        reazioni.remove(r);
    }
    
    public void addReazione(Risposta r){
        reazioni.add(r);
    }
    
    public void setReazioni(List<Risposta> risp){
	this.reazioni = risp;
    }

    public Date getConsegna() {
        return consegna;
    }

    public void setConsegna(Date consegna) {
        this.consegna = consegna;
    }

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }
}
