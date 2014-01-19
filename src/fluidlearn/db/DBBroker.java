package fluidlearn.db;

import fluidlearn.Corso;
import fluidlearn.Risorsa;
import fluidlearn.Uda;
import fluidlearn.Valutazione;
import fluidlearn.Visibilita;
import fluidlearn.contributi.Commento;
import fluidlearn.contributi.Compito;
import fluidlearn.contributi.Post;
import fluidlearn.contributi.Reazione;
import fluidlearn.contributi.Risposta;
import fluidlearn.corpo.Testo;
import fluidlearn.nodi.Nodo;
import fluidlearn.nodi.NodoSemplice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBroker {

    private static String dbname = "jdbc:sqlite:database.db";

    public static void setDebugMode(boolean debug) {
	if (debug) {
	    dbname = "jdbc:sqlite:database_debug.db";
	} else {
	    dbname = "jdbc:sqlite:database.db";
	}
    }

    public static List<Risorsa> getRisorse(String risorse_string) {
	List<Risorsa> risorse = new ArrayList();
	StringTokenizer tokens = new StringTokenizer(risorse_string, ",");
	while (tokens.hasMoreElements()) {
	    risorse.add(new Risorsa((String) tokens.nextElement()));
	}
	return risorse;
    }

    public static List<Nodo> getNodi(String nodi_string) {
	List<Nodo> nodi = new ArrayList();
	StringTokenizer tokens = new StringTokenizer(nodi_string, ",");
	while (tokens.hasMoreElements()) {
	    nodi.add(getNodo(Integer.parseInt((String) tokens.nextElement())));
	}
	return nodi;
    }

    public static String getNomeUtente(int utente) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from utente where id=" + utente);
	    String nome;
	    nome = "";

	    while (rs.next()) {
		nome = rs.getString("nome");
	    }

	    return nome;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return null;
    }

    public static List<Corso> getCorsi() {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List corsiList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from corso");


	    while (rs.next()) {
		corsiList.add(new Corso(rs.getInt("id"), rs.getString("nome")));
	    }

	    return corsiList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return corsiList;
    }

    public static List<String> getRuoliCorso(int utente, int corso) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List<String> ruoli = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from ruolo where utente=" + utente + " and corso=" + corso);


	    while (rs.next()) {
		String ruoli_string = rs.getString("ruolo");
		StringTokenizer tokens = new StringTokenizer(ruoli_string, ",");
		while (tokens.hasMoreElements()) {
		    ruoli.add((String) tokens.nextElement());
		}
	    }

	    return ruoli;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return ruoli;
    }

    public static Corso getCorso(String corso) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from corso where id =" + corso);

	    Corso c = null;

	    while (rs.next()) {
		c = new Corso(rs.getInt("id"), rs.getString("nome"));
	    }

	    return c;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return null;
    }

    public static List<Uda> getUda(Corso corso) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List udaList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from uda where corso=" + corso.getId());


	    while (rs.next()) {
		Corso c = getCorso(rs.getString("corso"));
		udaList.add(new Uda(rs.getInt("id"), rs.getString("nome"), c));
	    }

	    return udaList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return udaList;
    }

    public static List<Nodo> getNodi(Corso corso) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List nodoList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from nodo where corso=" + corso.getId());


	    while (rs.next()) {
		Corso c = getCorso(rs.getString("corso"));
		List<Risorsa> risorse = new ArrayList();
		String risorse_string = rs.getString("risorsa");
		StringTokenizer tokens = new StringTokenizer(risorse_string, ",");
		while (tokens.hasMoreElements()) {
		    risorse.add(new Risorsa((String) tokens.nextElement()));
		}

		nodoList.add(new NodoSemplice(rs.getInt("id"), rs.getString("titolo"), rs.getString("testo"), c, risorse));
	    }

	    return nodoList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return nodoList;
    }

    public static Valutazione getValutazione(Risposta r) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from valutazione where compito=" + r.getId());

	    Valutazione val = null;
	    while (rs.next()) {
		val = new Valutazione();
		val.setVoto(rs.getInt("voto"));
		val.setTesto(rs.getString("testo"));
		val.setPubblicata(rs.getInt("pubblicata") == 1);
	    }

	    return val;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return null;
    }

    public static Nodo getNodo(int nodo) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from nodo where id=" + nodo);
	    Nodo nodo_return = null;

	    while (rs.next()) {
		Corso c = getCorso(rs.getString("corso"));
		List risorse = getRisorse(rs.getString("risorsa"));
		nodo_return = new NodoSemplice(rs.getInt("id"), rs.getString("titolo"), rs.getString("testo"), c, risorse);
	    }

	    return nodo_return;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return null;
    }

    public static int getIDUtente(String nome, String password) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from utente where (nome = '" + nome + "' and password='" + password + "' )");
	    int id = -1;
	    while (rs.next()) {
		id = rs.getInt("id");
	    }
	    if (id != -1) {
		return id;
	    }

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return -1;
    }

    public static void salvaPost(Post p) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    String nodi = "";
	    String risorse = "";
	    for (Nodo nodo : p.getNodi()) {
		nodi = nodi + nodo.getId() + ',';
	    }
	    for (Risorsa risorsa : p.getRisorse()) {
		risorse = risorse + risorsa.getLink() + ',';
	    }
	    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String data;
	    data = formatter.format(p.getData());
	    statement.executeUpdate("insert into post  values(null, '" + p.getTitolo() + "' , '" + p.getCorpo().getTesto()
		    + "' , '" + p.getUda().getId() + "' , '" + p.getVisibilita() + "' , '" + nodi + "' , '" + p.isDraft()
		    + "' , '" + risorse + "' , '" + data + "' , '" + p.getAutore() + "' , null )");


	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
    }

    public static void cancellaPost(Post p) {
	for (Commento c : p.getReazioni()) {
	    cancellaCommento(c);
	}
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    statement.executeUpdate("delete from post where id=" + p.getId());


	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
    }

    public static void cancellaCompito(Compito c) {
	for (Risposta r : c.getReazioni()) {
	    cancellaRisposta(r);
	}
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    statement.executeUpdate("delete from compito where id=" + c.getId());


	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
    }

    public static void cancellaCommento(Commento c) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    statement.executeUpdate("delete from commento where id=" + c.getId());


	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
    }

    public static void cancellaRisposta(Risposta r) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	if (r.getValutazione() != null) {
	    cancellaValutazione(r);
	}
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    statement.executeUpdate("delete from risposta where id=" + r.getId());


	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
    }

    public static void cancellaValutazione(Risposta r) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    statement.executeUpdate("delete from valutazione where compito=" + r.getId());


	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
    }

    public static List<Post> getPost(Uda uda) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List<Post> postList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from post where (uda=" + uda.getId() + " and bozza='false') order by id desc");


	    while (rs.next()) {
		boolean draft = false;
		if (rs.getString("bozza").equals("true")) {
		    draft = true;
		} else if (rs.getString("bozza").equals("false")) {
		    draft = false;
		}
		Date data = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
		    data = dateFormat.parse(rs.getString("data"));
		} catch (ParseException ex) {
		    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<Nodo> nodi = getNodi(rs.getString("nodi"));
		Post post = new Post(rs.getInt("id"), rs.getString("utente"), rs.getString("titolo"), new Testo(rs.getString("testo")), data,
			Visibilita.valueOf(rs.getString("visibilita")), uda, nodi, getRisorse(rs.getString("risorsa")), draft);
		post.setReazioni(getCommenti(post));
		postList.add(post);

	    }

	    return postList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return postList;
    }

    public static List<Post> getBozzePost(String autore, Uda uda) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List<Post> bozzeList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from post where (uda=" + uda.getId() + " and bozza='true' and utente='" + autore + "') order by id desc");


	    while (rs.next()) {
		boolean draft = false;
		if (rs.getString("bozza").equals("true")) {
		    draft = true;
		} else if (rs.getString("bozza").equals("false")) {
		    draft = false;
		}
		Date data = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
		    data = dateFormat.parse(rs.getString("data"));
		} catch (ParseException ex) {
		    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<Nodo> nodi = getNodi(rs.getString("nodi"));
		bozzeList.add(new Post(rs.getInt("id"), rs.getString("utente"), rs.getString("titolo"), new Testo(rs.getString("testo")), data,
			Visibilita.valueOf(rs.getString("visibilita")), uda, nodi, getRisorse(rs.getString("risorsa")), draft));
	    }

	    return bozzeList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return bozzeList;
    }

    public static List<Compito> getBozzeCompito(String autore, Uda uda) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List<Compito> bozzeList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from compito where (uda=" + uda.getId() + " and bozza='true' and utente='" + autore + "') order by id desc");


	    while (rs.next()) {
		boolean draft = false;
		if (rs.getString("bozza").equals("true")) {
		    draft = true;
		} else if (rs.getString("bozza").equals("false")) {
		    draft = false;
		}
		Date data = null;
		Date consegna = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
		    data = dateFormat.parse(rs.getString("data"));
		    consegna = dateFormat.parse(rs.getString("scadenza"));
		} catch (ParseException ex) {
		    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
		}


		List<Nodo> nodi = getNodi(rs.getString("nodi"));
		Compito compito = new Compito(rs.getInt("id"), rs.getString("utente"), rs.getString("titolo"), new Testo(rs.getString("testo")), data,
			Visibilita.valueOf(rs.getString("visibilita")), uda, nodi, getRisorse(rs.getString("risorsa")), draft, consegna, rs.getString("pluginid"));
		compito.setReazioni(getRisposte(compito));
		bozzeList.add(compito);
	    }

	    return bozzeList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return bozzeList;
    }

    public static void salvaCommento(Commento c) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    String nodi = "";
	    String risorse = "";
	    for (Nodo nodo : c.getNodi()) {
		nodi = nodi + nodo.getId() + ',';
	    }
	    for (Risorsa risorsa : c.getRisorse()) {
		risorse = risorse + risorsa.getLink() + ',';
	    }
	    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String data;
	    String consegna;
	    data = formatter.format(c.getData());

	    statement.executeUpdate("insert into commento values(null, '" + c.getTitolo() + "' , '" + c.getCorpo().getTesto()
		    + "' , '" + c.getAzione().getUda().getId() + "' , '" + c.getVisibilita() + "' , '" + nodi + "' , '"
		    + c.isDraft() + "' , '" + risorse + "' , '" + data + "' , '" + c.getAutore() + "' , '"
		    + c.getAzione().getId() + "')");
	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}

    }

    public static List<Commento> getCommenti(Post post) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List commentoList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from commento where post=" + post.getId());


	    while (rs.next()) {
		boolean draft = false;
		if (rs.getString("bozza").equals("true")) {
		    draft = true;
		} else if (rs.getString("bozza").equals("false")) {
		    draft = false;
		}
		Date data = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
		    data = dateFormat.parse(rs.getString("data"));
		} catch (ParseException ex) {
		    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<Nodo> nodi = getNodi(rs.getString("nodi"));
		commentoList.add(new Commento(rs.getInt("id"), rs.getString("utente"), rs.getString("titolo"), new Testo(rs.getString("testo")), data, Visibilita.valueOf(rs.getString("visibilita")), post, nodi, getRisorse(rs.getString("risorsa"))));
	    }

	    return commentoList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return commentoList;
    }

    public static List<Risposta> getRisposte(Compito compito) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List risposteList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from risposta where compito=" + compito.getId());


	    while (rs.next()) {
		boolean draft = false;
		if (rs.getString("bozza").equals("true")) {
		    draft = true;
		} else if (rs.getString("bozza").equals("false")) {
		    draft = false;
		}
		Date data = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
		    data = dateFormat.parse(rs.getString("data"));
		} catch (ParseException ex) {
		    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<Nodo> nodi = getNodi(rs.getString("nodi"));
		Risposta risposta = new Risposta(rs.getInt("id"), rs.getString("utente"), rs.getString("titolo"),
			new Testo(rs.getString("testo")), data,
			Visibilita.valueOf(rs.getString("visibilita")), draft,
			compito, nodi, getRisorse(rs.getString("risorsa")));
		risposta.setValutazione(getValutazione(risposta));
		risposteList.add(risposta);
	    }

	    return risposteList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return risposteList;
    }

    public static void salvaCompito(Compito c) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    String nodi = "";
	    String risorse = "";
	    for (Nodo nodo : c.getNodi()) {
		nodi = nodi + nodo.getId() + ',';
	    }
	    for (Risorsa risorsa : c.getRisorse()) {
		risorse = risorse + risorsa.getLink() + ',';
	    }
	    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String data;
	    String consegna = null;
	    data = formatter.format(c.getData());
	    if (c.getConsegna() != null) {
		consegna = formatter.format(c.getConsegna());
	    }
	    statement.executeUpdate("insert into compito values(null, '" + c.getTitolo() + "' , '" + c.getCorpo().getTesto()
		    + "' , '" + c.getUda().getId() + "' , '" + c.getVisibilita() + "' , '" + nodi + "' , '" + c.isDraft()
		    + "' , '" + risorse + "' , '" + data + "' , '" + c.getAutore() + "' , '" + consegna + "' , '" + c.getPluginId() + "')");


	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
    }

    public static List<Compito> getCompiti(Uda uda) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
	}
	List<Compito> compitoList = new ArrayList();
	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery("select * from compito where uda=" + uda.getId() + " and bozza='false'");


	    while (rs.next()) {
		boolean draft = false;
		if (rs.getString("bozza").equals("true")) {
		    draft = true;
		} else if (rs.getString("bozza").equals("false")) {
		    draft = false;
		}
		Date data = null;
		Date scadenza = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
		    data = dateFormat.parse(rs.getString("data"));
		    if (!rs.getString("scadenza").equals("null")) {
			scadenza = dateFormat.parse(rs.getString("scadenza"));
		    }
		} catch (ParseException ex) {
		    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
		}
		List<Nodo> nodi = getNodi(rs.getString("nodi"));
		String pluginid = rs.getString("pluginid");
		if (pluginid.equals("null")) {
		    pluginid = null;
		}
		Compito compito = new Compito(rs.getInt("id"), rs.getString("utente"),
			rs.getString("titolo"), new Testo(rs.getString("testo")), data,
			Visibilita.valueOf(rs.getString("visibilita")), uda, nodi,
			getRisorse(rs.getString("risorsa")), draft, scadenza,
			pluginid);
		compito.setReazioni(getRisposte(compito));
		compitoList.add(compito);
	    }

	    return compitoList;

	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}
	return compitoList;
    }

    public static void salvaRisposta(Risposta r) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    String nodi = "";
	    String risorse = "";
	    for (Nodo nodo : r.getNodi()) {
		nodi = nodi + nodo.getId() + ',';
	    }
	    for (Risorsa risorsa : r.getRisorse()) {
		risorse = risorse + risorsa.getLink() + ',';
	    }
	    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String data;
	    String consegna;
	    data = formatter.format(r.getData());

	    statement.executeUpdate("insert into risposta values(null, '" + r.getTitolo() + "' , '" + r.getCorpo().getTesto()
		    + "' , '" + r.getAzione().getUda().getId() + "' , '" + r.getVisibilita() + "' , '" + nodi + "' , '"
		    + r.isDraft() + "' , '" + risorse + "' , '" + data + "' , '" + r.getAutore() + "' , '"
		    + r.getAzione().getId() + "')");
	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}

    }

    public static void salvaValutazione(Risposta r) {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

	Connection connection = null;
	Valutazione v = r.getValutazione();
	try {
	    // create a database connection
	    connection = DriverManager.getConnection(dbname);
	    Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    int voto;
	    if (v.getVoto() == null) {
		voto = -1;
	    } else {
		voto = v.getVoto();
	    }
	    statement.executeUpdate("insert into valutazione values(null, '" + v.getTesto() + "' , '" + voto
		    + "' , '" + r.getId() + "', " + (v.isPubblicata() ? 1 : 0) + ")");
	} catch (SQLException e) {
	    System.err.println(e.getMessage());
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (SQLException e) {
		// connection close failed.
		System.err.println(e);
	    }
	}

    }
}
