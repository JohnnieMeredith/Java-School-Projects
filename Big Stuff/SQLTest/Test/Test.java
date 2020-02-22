
import java.sql.*;
public class Test {
public static void main(String[] args) {
      try {
       	int i=0;

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
         // now we can get the connection from the DriverManager
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/northwind?user=root&password=shepherd");
        
        // try and create a java.sql.Statement so we can run queries
        Statement s = con.createStatement();
		
		// select the data from the table
		// replace XXX with the column(s) and table you want to use
        s.execute("select * from customers"); 
        ResultSet rs = s.getResultSet(); // get any ResultSet that came from our query
        
        if (rs != null) // if rs == null, then there is no ResultSet to view
        
        while ( rs.next() ) // this will step through our data row-by-row
							// each iteration is for one row
        {
            /* the next line will get the first column in our current row's ResultSet 
            as a String ( getString( columnNumber) ) and output it to the screen */
            i++; 
            System.out.println("The first column of Row " + i + ": " + rs.getString(1) );
            System.out.println("The second column of Row " + i + ": " + rs.getString(2) );
            System.out.println("The third column of Row " + i + ": " + rs.getString(3) );
        }

        s.close(); // close the Statement to let the database know we're done with it
        con.close(); // close the Connection to let the database know we're done with it
    }

        catch (Exception err) {
        System.out.println("ERROR: " + err);
   }
 }
}
