package fluidlearn.controllers;

import fluidlearn.SessioneUtente;
import fluidlearn.db.DBBroker;


public class LoginController {

    public void login(String usr, String pwd) {
        int userID = DBBroker.getIDUtente(usr, pwd);
        if(userID != -1) {
            SessioneUtente sess = SessioneUtente.getInstance();
            sess.setUserID(userID);
            sess.setUserName(usr);
            sess.setIsLogged(true);
        }
    }

    public void loginGuest() {
        SessioneUtente sess = SessioneUtente.getInstance();
        sess.setUserName("Ospite");
        sess.setIsLogged(false);
    }
    
    public void logout() {
        SessioneUtente.getInstance().reset();
    }
    
}
