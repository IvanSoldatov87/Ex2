package MBank.core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ActivityDBMeneger {
	Connection conn;
	public ActivityDBMeneger(Connection conn)
	{
		this.conn=conn;
	}
	public ActivityDBMeneger(){
	}
	public void newActivity(Activity a1) throws SQLException

	{
		long timeNow = Calendar.getInstance().getTimeInMillis();
		java.sql.Date ts = new java.sql.Date(timeNow);
		
		String sqlInsert = "INSERT INTO activity"
				+ "(client_id,amount,activity_date,commision,description)  VALUES"
				+ "(?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sqlInsert);

		stmt.setInt(1, a1.getClient_id());
		stmt.setDouble(2, a1.getAmount());
		stmt.setDate(3, ts);
		stmt.setDouble(4, a1.getCommission());
		stmt.setString(5, a1.getDescription());


		stmt.executeUpdate();

	}
	public ArrayList selectAllActivitys() 
	{
		ArrayList<Activity> array = new ArrayList<Activity>();
        try {
			Connection con = conn;

			String sqlSelect = "SELECT * FROM activity";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			while (rs.next()) {
				Activity a1=new Activity();
				    a1.setId(rs.getLong("id"));
				    a1.setClient_id(rs.getInt("client_id"));
				    a1.setAmount(rs.getDouble("amount"));
				    a1.setActivity_date(rs.getDate("activity_date"));
				    a1.setCommission(rs.getDouble("commision"));
				    a1.setDescription(rs.getString("description"));
					array.add(a1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
	public Activity selectActivity(long id) throws SQLException
	{
		String sql = "SELECT * FROM activity WHERE id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setLong(1, id);

		ResultSet rs = null;

		rs = prest.executeQuery();
		Activity a1=new Activity();
		while (rs.next()) {
			a1.setId(rs.getLong("id"));
		    a1.setClient_id(rs.getInt("client_id"));
		    a1.setAmount(rs.getDouble("amount"));
		    a1.setActivity_date(rs.getDate("activity_date"));
		    a1.setCommission(rs.getDouble("commision"));
		    a1.setDescription(rs.getString("description"));

		}
		return a1;
	}
	public ArrayList selectClientActivitys(int client_id) 
	{
		 ArrayList<Activity> array = new ArrayList<Activity>();
		 try {
			String sqlSelect = "SELECT * FROM activity WHERE client_id =?";
			PreparedStatement prest = conn.prepareStatement(sqlSelect );
			prest.setLong(1, client_id);
			ResultSet rs = null;
			rs = prest.executeQuery();
			
			while (rs.next()) {
				Activity a1=new Activity();
				    a1.setId(rs.getLong("id"));
				    a1.setClient_id(rs.getInt("client_id"));
				    a1.setAmount(rs.getDouble("amount"));
				    a1.setActivity_date(rs.getDate("activity_date"));
				    a1.setCommission(rs.getDouble("commision"));
				    a1.setDescription(rs.getString("description"));
					array.add(a1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}

}
