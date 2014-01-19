package fluidlearn;

public class Uda {
    private int id;
    private String nome;
    private Corso corso;

    public Uda(int id, String nome, Corso corso) {
	this.id = id;
	this.nome = nome;
	this.corso = corso;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Uda)) return false;
        return this.id==((Uda)o).getId();
    }
}
