
package fluidlearn.controllers;

import fluidlearn.SessioneUtente;
import fluidlearn.Uda;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Post;
import fluidlearn.db.DBBroker;
import java.util.List;


public class BozzeController {

    public List<Post> getBozzePost(){
	SessioneUtente sessione = SessioneUtente.getInstance();
	Uda uda = sessione.getCurrentUda();
	String username = sessione.getUserName();
	return DBBroker.getBozzePost(username, uda);
    }
    
    public List<Compito> getBozzeCompito(){
	SessioneUtente sessione = SessioneUtente.getInstance();
	Uda uda = sessione.getCurrentUda();
	String username = sessione.getUserName();
	return DBBroker.getBozzeCompito(username, uda);
    }
    
    public void cancellaBozza(Post p){
        DBBroker.cancellaPost(p);
    }
    
    public void cancellaBozza(Compito c){
        DBBroker.cancellaCompito(c);
    }
    
}
