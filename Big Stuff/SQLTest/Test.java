import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Test {
public static void main(String[] args) {
      try {
        int i=0;
        //Connection.useSSL() = false;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
         // now we can get the connection from the DriverManager
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root","shepherd");
        
        // try and create a java.sql.Statement so we can run queries
        Statement[] s = new Statement[9];
        ResultSet[] rs ;
        rs = new ResultSet[9];
        for(int x = 0; x < 9; x++){
        s[x] = con.createStatement();
    }
        // select the data from the table
        // replace XXX with the column(s) and table you want to use
        s[0].execute("SELECT p.first_name, p.last_name, f.team_name, p.fantasy_points_total FROM player_table p, fantasy_team_table f WHERE f.team_id = p.fantasy_team_table_team_id ORDER BY p.fantasy_points_total desc;");
         rs [0] = s[0].getResultSet(); // get any ResultSet that came from our query
        s[1].execute("SELECT p.first_name, p.last_name, p.position, p.fantasy_points_total FROM player_table p WHERE p.fantasy_team_table_team_id = 1 ORDER BY p.fantasy_points_total desc;");
         rs[1] = s[1].getResultSet();
         s[2].execute("SELECT t2.week, t1.team_name AS home, t3.team_name AS away FROM fantasy_team_table t1, game_table t2, fantasy_team_table t3 WHERE t3.team_id = t2.away_team && t1.team_id = t2.home_team;"); 
         rs[2] = s[2].getResultSet();
         s[3].execute("INSERT INTO player_table Values(11, 'Jimmy', 'TwoTimes', 15, 1, 'RB')");  

        ResultSet rs3 = s[3].getResultSet();
         s[4].execute("INSERT INTO user_table VALUES (0, 'The', 'League', 'NotanEmail@notanemail.com', 1)"); 
        ResultSet rs4 = s[4].getResultSet();
         s[5].execute("DELETE FROM player_table WHERE player_id = 11"); 
        ResultSet rs5 = s[5].getResultSet();
         s[6].execute("DELETE FROM user_table WHERE user_id= 0"); 
        ResultSet rs6 = s[6].getResultSet();
         s[7].execute("UPDATE player_table SET first_name = 'bob' WHERE player_id = 1"); 
        ResultSet rs7 = s[7].getResultSet();
         s[8].execute("UPDATE fantasy_team_table SET team_name = 'Best Team Ever' WHERE team_id = 2"); 
        ResultSet rs8 = s[8].getResultSet();
         
        for(int b = 0; b < 9; b++){
            i=0;
            if(b < 3){
                System.out.println();
                System.out.println("Result set for Statement " + (b+1));
        }
        else
        System.out.println("Result set for Statement " + (b+1) + " = NA for INSERT/DELETE/UPDATE.");
        System.out.println();
         if (rs[b] != null) // if rs == null, then there is no ResultSet to view
        
        while ( rs[b].next() ) // this will step through our data row-by-row
                            // each iteration is for one row
        {
            if(b < 2){
            /* the next line will get the first column in our current row's ResultSet 
            as a String ( getString( columnNumber) ) and output it to the screen */
            i++; 
            System.out.println("The first column of Row " + i + " is : " + rs[b].getString(1) );
            System.out.println("The second column of Row " + i + " is : " + rs[b].getString(2) );
            System.out.println("The third column of Row " + i + " is : " + rs[b].getString(3) );
            System.out.println("The fourth column of Row " + i + " is  : " + rs[b].getString(4) );
            System.out.println();
        }
        else{
            /* the next line will get the first column in our current row's ResultSet 
            as a String ( getString( columnNumber) ) and output it to the screen */
            i++; 
             System.out.println("The first column of Row " + i + ": " + rs[b].getString(1) );
            System.out.println("The second column of Row " + i + ": " + rs[b].getString(2) );
            System.out.println("The third column of Row " + i + ": " + rs[b].getString(3) );
            System.out.println();
        }
    
        
        }
    }
        for(int x = 0; x < 9; x++){
            s[x].close(); // close the Statement to let the database know we're done with it
        }
        con.close(); // close the Connection to let the database know we're done with it
    }

        catch (Exception err) {
        System.out.println("ERROR: " + err);
   }
 }
}