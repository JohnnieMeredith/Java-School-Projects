import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class RSteams extends JFrame {

  private JButton getteamButton,
                  insertteamButton,
                  deleteteamButton,
                  updateteamButton,
                  nextButton,
                  previousButton,
                  lastButton,
                  firstButton,
                  gotoButton,
                  freeQueryButton;
  private JList   teamNumberList;
  private JTextField teamIDText,
                     teamnameText,
                     standingsText,
                     tsText,
                     activeTSText, 
                     gotoText,
                     freeQueryText;
  private JTextArea  errorText;

  private Connection connection;
  private Statement  statement;
  private ResultSet  rs;

  public RSteams() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    } catch (Exception  e) {
      System.err.println("Unable to find and load driver");
      System.exit(1);
    }
  }

  private void loadteams() {
    Vector v = new Vector();
    try {
      rs = statement.executeQuery("SELECT * FROM new_schema.fantasy_team_table");

      while(rs.next()) {
        v.addElement(rs.getString("team_id"));
      }
    } catch(SQLException e) { 
      displaySQLErrors(e);
    }
    teamNumberList.setListData(v);
  }

  private void buildGUI() {
    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    teamNumberList = new JList();
    loadteams();
    teamNumberList.setVisibleRowCount(2);
    JScrollPane teamNumberListScrollPane = new JScrollPane(teamNumberList);

    gotoText = new JTextField(3);
    freeQueryText = new JTextField(40);
       
    //Do Get team Button
    getteamButton = new JButton("Get Team");
    getteamButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            rs.beforeFirst();
            while (rs.next()) {
              if (rs.getString("team_id").equals(teamNumberList.getSelectedValue())) 
                break;
            }
            if (!rs.isAfterLast()) {           
              teamIDText.setText(rs.getString("team_id"));
              teamnameText.setText(rs.getString("team_name"));
              standingsText.setText(rs.getString("standings"));
              tsText.setText(rs.getString("user_table_user_id"));
              activeTSText.setText(rs.getString("league_table_league_id"));
            }
          } catch(SQLException selectException) {
            displaySQLErrors(selectException);
          }
        }
      }
    );

    //Do Insert team Button
    insertteamButton = new JButton("Insert Team");
    insertteamButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            Statement statement = connection.createStatement();
            String cmd = "INSERT INTO new_schema.fantasy_team_table VALUES(" +
              teamIDText.getText() + ", " + "'"  +
              teamnameText.getText() + "', " + "'" +
              standingsText.getText() + "', " + "'" +
              tsText.getText() + "', " + "'" +
              activeTSText.getText() + "')" ;
               errorText.append(cmd);
            int i = statement.executeUpdate(cmd);
            errorText.append("Inserted " + i + " rows successfully");
            teamNumberList.removeAll();
            loadteams();
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );

    //Do Delete team Button
    deleteteamButton = new JButton("Delete Team");
    deleteteamButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM new_schema.fantasy_team_table WHERE team_id = " +
              teamNumberList.getSelectedValue());
            errorText.append("Deleted " + i + " rows successfully");
            teamNumberList.removeAll();
            loadteams();
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );

    //Do Update team Button
    updateteamButton = new JButton("Update Team");
    updateteamButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            Statement statement = connection.createStatement();
            
            String cmd = "UPDATE fantasy_team_table " +
              "SET team_name='" + teamnameText.getText() + "', " +
              "standings='" + standingsText.getText() + "', " +
              "league_table_league_id ='" + activeTSText.getText()  + "' " +
              "WHERE team_id = " + teamNumberList.getSelectedValue()+ ";";
            
              errorText.append(cmd);
              
            int i = statement.executeUpdate(cmd) ;
            errorText.append("Updated " + i + " rows successfully");
            teamNumberList.removeAll();
            loadteams();
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );

    //Do Next Button
    nextButton = new JButton(">");
    nextButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
             if (!rs.isLast()) {
               rs.next();
               teamIDText.setText(rs.getString("team_id"));
               teamnameText.setText(rs.getString("team_name"));
               standingsText.setText(rs.getString("standings"));
               tsText.setText(rs.getString("user_table_user_id"));
               activeTSText.setText(rs.getString("league_table_league_id"));
             } 
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );

    //Do Next Button
    previousButton = new JButton("<");
    previousButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
             if (!rs.isFirst()) {
               rs.previous();
               teamIDText.setText(rs.getString("team_id"));
               teamnameText.setText(rs.getString("team_name"));
               standingsText.setText(rs.getString("standings"));
               tsText.setText(rs.getString("user_table_user_id"));
               activeTSText.setText(rs.getString("league_table_league_id"));
             }
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );


    //Do last Button
    lastButton = new JButton(">|");
    lastButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            rs.last();
            teamIDText.setText(rs.getString("team_id"));
            teamnameText.setText(rs.getString("team_name"));
            standingsText.setText(rs.getString("standings"));
            tsText.setText(rs.getString("user_table_user_id"));
            activeTSText.setText(rs.getString("league_table_league_id"));
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );


    //Do first Button
    firstButton = new JButton("|<");
    firstButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            rs.first();
            teamIDText.setText(rs.getString("team_id"));
            teamnameText.setText(rs.getString("team_name"));
            standingsText.setText(rs.getString("standings"));
            tsText.setText(rs.getString("user_table_user_id"));
            activeTSText.setText(rs.getString("league_table_league_id"));
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );

    //Do gotoButton
    gotoButton = new JButton("Goto");
    gotoButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            rs.absolute(Integer.parseInt(gotoText.getText()));
            teamIDText.setText(rs.getString("team_id"));
            teamnameText.setText(rs.getString("team_name"));
            standingsText.setText(rs.getString("standings"));
            tsText.setText(rs.getString("user_table_user_id"));
            activeTSText.setText(rs.getString("league_table_league_id"));
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );

    //Do freeQueryButton
    freeQueryButton = new JButton("Execute Query");
    freeQueryButton.addActionListener (
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            if (freeQueryText.getText().toUpperCase().indexOf("SELECT") >= 0) {
              rs = statement.executeQuery(freeQueryText.getText());
              if (rs.next()) {
                teamIDText.setText(rs.getString("team_id"));
                teamnameText.setText(rs.getString("team_name"));
                standingsText.setText(rs.getString("standings"));
                tsText.setText(rs.getString("user_table_user_id"));
                activeTSText.setText(rs.getString("league_table_league_id"));
              }
            } else {
              int i = statement.executeUpdate(freeQueryText.getText());
              errorText.append("Rows affected = " + i);
              loadteams();
            }
          } catch(SQLException insertException) {
            displaySQLErrors(insertException);
          }
        }
      }
    );


    JPanel first = new JPanel(new GridLayout(5,1));
    first.add(teamNumberListScrollPane);
    first.add(getteamButton);
    first.add(insertteamButton);
    first.add(deleteteamButton);
    first.add(updateteamButton);

    teamIDText = new JTextField(15);
    teamnameText = new JTextField(25);
    standingsText = new JTextField(15);
    tsText = new JTextField(15);
    activeTSText = new JTextField(15);
    errorText = new JTextArea(5, 15);
    errorText.setEditable(false);

    JPanel second = new JPanel();
    second.setLayout(new GridLayout(6,1));
    second.add(teamIDText);
    second.add(teamnameText);
    second.add(standingsText);
    second.add(tsText);
    second.add(activeTSText);

    JPanel third = new JPanel();
    third.add(new JScrollPane(errorText));

    JPanel fourth = new JPanel();
    fourth.add(firstButton);
    fourth.add(previousButton);
    fourth.add(nextButton);
    fourth.add(lastButton);
    fourth.add(gotoText);
    fourth.add(gotoButton);
    

    JPanel fifth = new JPanel();
    fifth.add(freeQueryText);

    c.add(first);
    c.add(second);
    c.add(third);
    c.add(fourth);
    c.add(fifth);
    c.add(freeQueryButton); 
    setSize(500,500);
    show();
  }

  public void connectToDB() {
    try {
      connection = DriverManager.getConnection(
        "jdbc:mysql://localhost/new_schema?user=root&password=shepherd");
      statement = connection.createStatement();

    } catch(SQLException connectException) {
      System.out.println(connectException.getMessage());
      System.out.println(connectException.getSQLState());
      System.out.println(connectException.getErrorCode());
      System.exit(1);
    }
   }

  private void displaySQLErrors(SQLException e) {
    errorText.append("SQLException: " + e.getMessage() + "\n");
    errorText.append("SQLState:     " + e.getSQLState() + "\n");
    errorText.append("VendorError:  " + e.getErrorCode() + "\n");   
  }

  private void init() {
    connectToDB();
  }

  public static void main(String[] args) {
     RSteams teams = new RSteams();
   
     teams.addWindowListener(
       new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
           System.exit(0);
         }
       }
     );

     teams.init();
     teams.buildGUI();   
  }
}