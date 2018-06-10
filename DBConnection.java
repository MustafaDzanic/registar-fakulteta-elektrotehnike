package dbconnection;

import java.sql.*;

public class DBConnection {
	
  protected Connection con;
  protected Statement st;
  protected ResultSet rs;
  
  public DBConnection() {
	  try {
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectDB","root","");
		  st = con.createStatement();
	      }
	  catch (Exception ex) {System.out.println("Error : "+ex);}
	  
  }
  
 
  public void getData() {
	  try {
		  String query = "select * from person";
		  rs = st.executeQuery(query);
		  String ispis = rs.getString();
		  System.out.println(ispis);
		  
		  }
	  catch (Exception ex) {System.out.println(ex);}
  }
	  
	  }
