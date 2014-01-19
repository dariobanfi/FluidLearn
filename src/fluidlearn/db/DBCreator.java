
package fluidlearn.db;

import fluidlearn.Corso;
import fluidlearn.Risorsa;
import fluidlearn.Uda;
import fluidlearn.contributi.Commento;
import fluidlearn.contributi.Post;
import fluidlearn.nodi.Nodo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DBCreator {

    private static String dbname = "jdbc:sqlite:database.db" ;
	
    public static void setDebugMode(boolean debug){
	if(debug)
	    dbname = "jdbc:sqlite:database_debug.db" ;
	else
	    dbname =  "jdbc:sqlite:database.db";
    }
    

    public static void resetDB(){
        String prevdbname = dbname;
        setDebugMode(true);
        creaCommentoTabella();
	creaCompitoTabella();
	creaCorsoTabella();
	creaNodoTabella();
	creaPostTabella();
	creaRispostaTabella();
	creaRuoloTabella();
	creaUdaTabella();
	creaUtenteTabella();
	creaValutazioneTabella();
        dbname=prevdbname;
    }
   
    public static void creaPostTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists post");
          statement.executeUpdate("create table post (id integer primary key autoincrement , titolo string,"
                  + "testo string, uda int, visibilita string, nodi string, bozza string, risorsa string, "
                  + "data string, utente string, pluginid int)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
    
     public static void creaCompitoTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists compito");
          statement.executeUpdate("create table compito (id integer primary key autoincrement , titolo string,"
                  + "testo string, uda int, visibilita string, nodi string, bozza string, risorsa string, "
                  + "data string, utente int, scadenza string, pluginid string)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
    
    public static void creaUtenteTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists utente");
          statement.executeUpdate("create table utente (id integer primary key autoincrement , nome string,"
                  + "password string)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
    
      public static void creaNodoTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists nodo");
          statement.executeUpdate("create table nodo (id integer primary key autoincrement , titolo string,"
                  + "testo string, corso int, risorsa string)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
	
    }
      
    public static void creaRuoloTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists ruolo");
          statement.executeUpdate("create table ruolo (id integer primary key autoincrement , utente int,"
                  + "corso int, ruolo string)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
	
    }
  
    public static void creaRuolo(int utente, int corso, String ruolo){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

           statement.executeUpdate("insert into ruolo values(null, " + utente + " , " + corso + " , '" + ruolo + "')");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
	
    }
    
        public static void creaCorsoTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists corso");
          statement.executeUpdate("create table corso (id integer primary key autoincrement , nome string)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
    }
    
    public static void creaUtente(String nome, String password){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("insert into utente values(null, '" + nome + "' , '" + password + "')");

        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
    }
    
        public static void creaCorso(String corso){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("insert into corso values(null, '" + corso + "')");

        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
    }
	
    public static void printQuery(String sql){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    ResultSet rs = statement.executeQuery(sql);
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int numberOfColumns = rsmd.getColumnCount();
	    
	    while (rs.next()) {
	      for (int i = 1; i <= numberOfColumns; i++) {
		if (i > 1) System.out.print(",  ");
		String columnValue = rs.getString(i);
		System.out.print(columnValue);
	      }
	      System.out.println("");  
	    }

        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
    }
    
   

    public static void creaUdaTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists uda");
          statement.executeUpdate("create table uda (id integer primary key autoincrement , nome string,"
                  + "corso int)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }

public static void creaUda(String nome, int corso){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

	statement.executeUpdate("insert into uda values(null, '" + nome + "' , " + corso + ")");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
public static void creaNodo(String titolo, String testo, String corso){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

	statement.executeUpdate("insert into nodo values(null, '" + titolo + "' , '" + testo + "' , '" + corso +  "' , '' )");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
    public static void creaCommentoTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
	  statement.executeUpdate("drop table if exists commento");
          statement.executeUpdate("create table commento (id integer primary key autoincrement , titolo string,"
                  + "testo string, uda int, visibilita string, nodi string, bozza string, risorsa string, "
                  + "data string, utente int, post int)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
    
    public static void creaRispostaTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
	  statement.executeUpdate("drop table if exists risposta");
          statement.executeUpdate("create table risposta (id integer primary key autoincrement , titolo string,"
                  + "testo string, uda int, visibilita string, nodi string, bozza string, risorsa string, "
                  + "data string, utente int, compito int)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
    
    public static void creaValutazioneTabella(){
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(DBCreator.class.getName()).log(Level.SEVERE, null, ex);
	}

        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection(dbname);
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
	  statement.executeUpdate("drop table if exists valutazione");
          statement.executeUpdate("create table valutazione (id integer primary key autoincrement , testo string,"
                  + "voto int, compito int, pubblicata int)");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
    }
}
