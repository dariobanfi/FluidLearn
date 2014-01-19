package fluidlearn;

public class Valutazione {

    private String testo;
    private Integer voto;
    private boolean pubblicata;

    public Valutazione() {
        this.pubblicata=false;
    }

    public Valutazione(Integer voto, String testo) {
        this.voto = voto;
        this.testo = testo;
        this.pubblicata=false;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public boolean isPubblicata() {
        return pubblicata;
    }

    public void setPubblicata(boolean pubblicata) {
        this.pubblicata = pubblicata;
    }
}
