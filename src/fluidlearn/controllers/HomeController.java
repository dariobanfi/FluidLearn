package fluidlearn.controllers;

import fluidlearn.Corso;
import fluidlearn.db.DBBroker;
import java.util.List;


public class HomeController {

    public List<Corso> getCorsi(){
        return DBBroker.getCorsi();
    }
    
}
