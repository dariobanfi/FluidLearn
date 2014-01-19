package fluidlearn.corpo;

public class Testo implements Corpo{
    
    private String string;
    
    public Testo(){
    }
    
    public Testo(String string) {
        this.string = string;
    }
    
    public void setTesto(String string){
	this.string = string;
    }
    
    @Override
    public String getTesto(){
	return this.string;
    }
}
