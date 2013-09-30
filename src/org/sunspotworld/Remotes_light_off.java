import java.sql.*;

public class Remotes_light_off {

	  public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //need to change the database file directory//
	      c = DriverManager.getConnection("jdbc:sqlite:file:/Users/XXXX.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      //will use the remote which IP address is ended by 765E//
	      String sql = "UPDATE OURDATA set ONOFF = '0' where ID='0014.4F01.0000.765E'";
	      stmt.executeUpdate(sql);
	      c.commit();

	      ResultSet rs = stmt.executeQuery( "SELECT * FROM OURDATA;" );
	      while ( rs.next() ) {
	         String  id = rs.getString("ID");
	         String  state = rs.getString("ONOFF");

	         System.out.println( "ID = " + id );
	         System.out.println( "STATE = " +state  );


	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	  }
	}
