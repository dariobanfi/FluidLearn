package fluidlearn;


import fluidlearn.db.DBBroker;
import fluidlearn.db.DBCreator;
import fluidlearn.gui.Gui;
import fluidlearn.nodi.Nodo;
import java.util.List;

/**
 *
 * @author eddy dario leo
 */
public class FluidLearn {

    public static void main(String[] args) {

        Gui g = new Gui();
	//DBCreator.creaCommentoTabella();
       // DBCreator.creaCompitoTabella();
	//DBCreator.printQuery("insert into commento values(null, 'Leo',  'Io posso!',  1,  'PUBBLICO',  '1,2,',  'false',  'asdas,asdada,' ,  '06-06-2013 22:22:51',  'Eddy',  12)");
	//DBCreator.creaValutazioneTabella();
	//DBCreator.printQuery("select * from compito");
	/*DBCreator.setDebugMode(true);
	DBCreator.creaCommentoTabella();
	DBCreator.creaCompitoTabella();
	DBCreator.creaCorsoTabella();
	DBCreator.creaNodoTabella();
	DBCreator.creaPostTabella();
	DBCreator.creaRispostaTabella();
	DBCreator.creaRuoloTabella();
	DBCreator.creaUdaTabella();
	DBCreator.creaUtenteTabella();
	DBCreator.creaValutazioneTabella();
	DBCreator.setDebugMode(true);
	DBCreator.printQuery("select * from sqlite_master WHERE type='table'");*/
    }
    

}
