package MBank;

import java.util.Calendar;
import java.util.Date;

//import com.jgoodies.looks.plastic.theme.SkyBlue;

import MBank.gui.AdminFrame;


public class AdminMain {
	public static void main(String[] args)  {
		 

		AdminFrame f = new AdminFrame();

		
		/* test
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt);
		c.add(Calendar.DATE, +0);
		dt = c.getTime();
		System.out.println(dt);
		 */
		 /* String driver = "com.mysql.jdbc.Driver"; 
		  String dbName ="/MbankDB;create=true;"; 
		  String connectionURL ="jdbc:mysql://localhost:3306" + dbName; 
		  Connection conn = null; try {
		  Class.forName(driver); conn =
		  DriverManager.getConnection(connectionURL);
		  
		  } catch (java.lang.ClassNotFoundException | SQLException e) {
		  e.printStackTrace(); }
		*/ 


		  

		
		/* String CREATE_TABLE_SQL_Client = "Create table Clients (" +
		 "client_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT," 
	    //+"(START WITH 1, INCREMENT BY 1),"
		 + "client_name VARCHAR(30)," +
		 "password VARCHAR(30)," + "type VARCHAR(30)," +
		 "address VARCHAR(30)," + "email VARCHAR(30)," + "phone VARCHAR(30),"
		 + "comment VARCHAR(50))";
		 stmt.executeUpdate(CREATE_TABLE_SQL_Client);
		*/
		
		/*  String Create_Table_Accounts = "create table Accounts (" +
		  "account_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT," + "client_id Int," +
		  "balance double" + "credit_limit double" + "comment varchar(30))";
		  stmt.executeUpdate(Create_Table_Accounts);
		*/
		  /*String Create_Table_Deposits = "CREATE TABLE Deposits(" +
		  "deposit_id NTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT," + "client_id Int," +
		  "balance double," + "type VARCHAR(30)," + "estimated_balance int," +
		  "openening_date date()," + "closing_date date())";
		  stmt.executeUpdate(Create_Table_Deposits);
		  String Create_Table_Activity = "CREATE TABLE Activity(" +
		  "id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT," + "client_id int," +
		  "amount double()," + "activity_date date()," + "commision double(),"
		  + "description varchar(30))";
		  stmt.executeUpdate(Create_Table_Activity);
		  
		  String Create_Table_Properties = "CREATE TABLE Properties(" +
		  "prop_key INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT," + "prop_value varchar(30))";
		  stmt.executeUpdate(Create_Table_Properties);
*/
	}

}
