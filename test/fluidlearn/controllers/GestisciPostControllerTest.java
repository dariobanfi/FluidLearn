package fluidlearn.controllers;

import fluidlearn.db.DBCreator;
import java.util.Date;
import fluidlearn.nodi.NodoSemplice;
import java.util.LinkedList;
import fluidlearn.corpo.Artefatto;
import fluidlearn.plugin.PluginBook;
import fluidlearn.Corso;
import fluidlearn.corpo.Testo;
import fluidlearn.SessioneUtente;
import fluidlearn.Risorsa;
import fluidlearn.Uda;
import fluidlearn.Visibilita;
import fluidlearn.contributi.Post;
import fluidlearn.db.DBBroker;
import fluidlearn.nodi.Nodo;
import fluidlearn.plugin.Plugin;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestisciPostControllerTest {

    public GestisciPostControllerTest() {
    }
    SessioneUtente sessione;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        DBBroker.setDebugMode(true);
        DBCreator.setDebugMode(true);
        DBCreator.resetDB();
        DBCreator.creaCorso("CorsoTest");
        DBCreator.creaNodo("nodo", "test", "1");
        DBCreator.creaUda("UdaTest", 1);


        sessione = SessioneUtente.getInstance();
        sessione.setUserID(1);
        sessione.setUserName("Test");
        sessione.setCurrentCorso(new Corso(1, "CorsoTest"));
        sessione.setCurrentUda(new Uda(1, "UdaTest", sessione.getCurrentCorso()));

    }

    @After
    public void tearDown() {
    }

    private Post creaPostPieno() {
        Post p = new Post(111, sessione.getUserName(), "kkk", new Testo("ciao"), new Date(), Visibilita.DOCENTE, sessione.getCurrentUda(), new LinkedList<Nodo>(), new LinkedList<Risorsa>(), false);
        p.addNodo(new NodoSemplice(1, "nodo", "test", sessione.getCurrentCorso(), new LinkedList<Risorsa>()));
        return p;
    }

    /**
     * Test of creaPost method, of class GestisciPostController.
     */
    @Test
    public void testCreaPost() {
        System.out.println("creaPost");
        Plugin plugin = null;
        GestisciPostController gpc = new GestisciPostController();
        Post result = gpc.creaPost(plugin);
        assertEquals(sessione.getUserName(), result.getAutore());
        assertEquals(sessione.getCurrentUda(), result.getUda());
        assert (result.getCorpo() instanceof Testo);
    }

    /**
     * Test of creaPost method, of class GestisciPostController, invoked with a plugin.
     */
    @Test
    public void testCreaPostPlugin() {
        System.out.println("creaPostPlugin");
        Plugin plugin = new PluginBook();
        GestisciPostController gpc = new GestisciPostController();
        Post result = gpc.creaPost(plugin);
        assertEquals(sessione.getUserName(), result.getAutore());
        assertEquals(sessione.getCurrentUda(), result.getUda());
        assert (result.getCorpo() instanceof Artefatto);
    }

    /**
     * Test of setDatiPost method, of class GestisciPostController.
     */
    @Test
    public void testSetDatiPost() {
        System.out.println("setDatiPost");
        Post p = new Post();
        p.setCorpo(new Testo());
        String titolo = "titolo";
        String testo = "testo";
        Visibilita visibilita = Visibilita.PRIVATO;
        List<Nodo> nodi = new LinkedList<Nodo>();
        nodi.add(new NodoSemplice());
        List<Risorsa> risorse = new LinkedList<Risorsa>();
        risorse.add(new Risorsa("link"));

        GestisciPostController gpc = new GestisciPostController();
        gpc.setDatiPost(p, titolo, testo, visibilita, nodi, risorse);
        assertEquals(titolo, p.getTitolo());
        assertEquals(testo, p.getCorpo().getTesto());
        assertEquals(visibilita, p.getVisibilita());
        assertEquals(nodi, p.getNodi());
        assertEquals(risorse, p.getRisorse());
    }

    /**
     * Test of setDatiPostPlugin method, of class GestisciPostController.
     */
    @Test
    public void testSetDatiPostPlugin() {
        System.out.println("setDatiPostPlugin");
        Post p = new Post();
        p.setCorpo(new Artefatto("test"));
        String titolo = "titolo";
        Visibilita visibilita = Visibilita.PRIVATO;
        List<Nodo> nodi = new LinkedList<Nodo>();
        nodi.add(new NodoSemplice());
        List<Risorsa> risorse = new LinkedList<Risorsa>();
        risorse.add(new Risorsa("link"));

        GestisciPostController gpc = new GestisciPostController();
        gpc.setDatiPostPlugin(p, titolo, visibilita, nodi, risorse);
        assertEquals(titolo, p.getTitolo());
        assertEquals(visibilita, p.getVisibilita());
        assertEquals(nodi, p.getNodi());
        assertEquals(risorse, p.getRisorse());
    }

    /**
     * Test of setUDA method, of class GestisciPostController.
     */
    @Test
    public void testSetUDA() {
        System.out.println("setUDA");
        Post p = new Post();
        Uda uda = new Uda(123, "test", new Corso(321, "testc"));
        GestisciPostController gpc = new GestisciPostController();
        gpc.setUDA(p, uda);
        assertEquals(uda, p.getUda());
    }

    /**
     * Test of salvaPost method, of class GestisciPostController.
     */
    @Test
    public void testSalvaPost() {
        System.out.println("salvaPost");
        Post p1 = creaPostPieno();
        boolean draft = false;
        GestisciPostController gpc = new GestisciPostController();
        
        Date prima = new Date();
        prima.setTime(prima.getTime() - 1000);
        gpc.salvaPost(p1, draft);
        Date dopo = new Date();
        dopo.setTime(dopo.getTime() + 1000);

        Post p2 = DBBroker.getPost(sessione.getCurrentUda()).get(0);
        
        assertEquals(p1.getAutore(), p2.getAutore());
        assertEquals(p1.getCorpo().getTesto(), p2.getCorpo().getTesto());
        assertEquals(p1.getNodi(), p2.getNodi());
        assertEquals(p1.getReazioni(), p2.getReazioni());
        assertEquals(p1.getRisorse(), p2.getRisorse());
        assertEquals(p1.getTitolo(), p2.getTitolo());
        assertEquals(p1.getUda(), p2.getUda());
        assertEquals(p1.getVisibilita(), p2.getVisibilita());
        assertEquals(draft, p2.isDraft());
        assert (p2.getData().after(prima));
        assert (p2.getData().before(dopo));
    }

    /**
     * Test of salvaPost method, of class GestisciPostController, saving a draft.
     */
    @Test
    public void testSalvaPostBozza() {

        DBBroker.setDebugMode(true);
        System.out.println("salvaPostBozza");
        Post p1 = creaPostPieno();
        boolean draft = true;
        GestisciPostController gpc = new GestisciPostController();
        
        Date prima = new Date();
        prima.setTime(prima.getTime() - 1000);
        gpc.salvaPost(p1, draft);
        Date dopo = new Date();
        dopo.setTime(dopo.getTime() + 1000);
        
        Post p2 = DBBroker.getBozzePost(sessione.getUserName(), sessione.getCurrentUda()).get(0);
        
        assertEquals(p1.getAutore(), p2.getAutore());
        assertEquals(p1.getCorpo().getTesto(), p2.getCorpo().getTesto());
        assertEquals(p1.getNodi(), p2.getNodi());
        assertEquals(p1.getReazioni(), p2.getReazioni());
        assertEquals(p1.getRisorse(), p2.getRisorse());
        assertEquals(p1.getTitolo(), p2.getTitolo());
        assertEquals(p1.getUda(), p2.getUda());
        assertEquals(p1.getVisibilita(), p2.getVisibilita());
        assertEquals(draft, p2.isDraft());
        assert (p2.getData().after(prima));
        assert (p2.getData().before(dopo));
    }

    /**
     * Test of cancellaPost method, of class GestisciPostController.
     */
    @Test
    public void testCancellaPost() {
        System.out.println("cancellaPost");
        Post p = creaPostPieno();
        GestisciPostController gpc = new GestisciPostController();
        gpc.salvaPost(p, false);
        try {
            p = DBBroker.getPost(sessione.getCurrentUda()).get(0);
        } catch (NullPointerException e) {
            System.out.println("salvaPost failed");
            fail();
        }
        gpc.cancellaPost(p);
        assert(DBBroker.getPost(sessione.getCurrentUda()).isEmpty());
    }
}
