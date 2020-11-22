package MBank.core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DepositDBMeneger {
	Connection conn;
	
	public DepositDBMeneger(Connection conn)
	{
		this.conn=conn;
	}
	public DepositDBMeneger(){
	}
	public void newDeposit(Deposit d1) throws SQLException

	{
		String sqlInsert = "INSERT INTO deposits"
				+ "(client_id,balance,type,estimated_balance,openening_date,closing_date)  VALUES"
				+ "(?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sqlInsert);
		
		long timeNow = d1.getOpen_date().getTime();
		java.sql.Date sqlOpTime = new java.sql.Date(timeNow);
		
		long cloTime = d1.close_date.getTime();
		java.sql.Date sqlCloTime = new java.sql.Date(cloTime);

		stmt.setInt(1, d1.getClient_id());
		stmt.setDouble(2, d1.getBalance());
		stmt.setString(3, d1.getType());
		stmt.setLong(4, d1.getEstimated_balanse());
		stmt.setDate(5, sqlOpTime);
		stmt.setDate(6, sqlCloTime);

		stmt.executeUpdate();

	}
	public ArrayList selectAllDeposits() 
	{
		ArrayList<Deposit> array = new ArrayList<Deposit>();
        try {
			String sqlSelect = "SELECT * FROM deposits";
			PreparedStatement prest = conn.prepareStatement(sqlSelect);
			ResultSet rs = null;
			rs=prest.executeQuery();
			while (rs.next()) {
				Deposit d1=new Deposit();
			    d1.setDeposit_id(rs.getLong("deposit_id"));
			    d1.setClient_id(rs.getInt("client_id"));
			    d1.setBalance(rs.getDouble("balance"));
			    d1.setType(rs.getString("type"));
			    d1.setEstimated_balanse(rs.getLong("estimated_balance"));
			    d1.setOpen_date(rs.getDate("openening_date"));
			    d1.setClose_date(rs.getDate("closing_date"));
				array.add(d1);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;

	}
	public ArrayList selectAllClientDeposits(int client_id) 
	{
		ArrayList<Deposit> array = new ArrayList<Deposit>();
        try {
			String sqlSelect = "SELECT * FROM deposits WHERE client_id =?";
			PreparedStatement prest = conn.prepareStatement(sqlSelect);
			prest.setLong(1, client_id);
			ResultSet rs = null;
			rs=prest.executeQuery();
			
			while (rs.next()) {
					Deposit d1=new Deposit();
				    d1.setDeposit_id(rs.getLong("deposit_id"));
				    d1.setClient_id(rs.getInt("client_id"));
				    d1.setBalance(rs.getDouble("balance"));
				    d1.setType(rs.getString("type"));
				    d1.setEstimated_balanse(rs.getLong("estimated_balance"));
				    d1.setOpen_date(rs.getDate("openening_date"));
				    d1.setClose_date(rs.getDate("closing_date"));
					array.add(d1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;

	}
	public Deposit selectDeposit(long deposit_id) throws SQLException
	{
		String sql = "SELECT * FROM deposits WHERE deposit_id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setLong(1, deposit_id);

		ResultSet rs = null;

		rs = prest.executeQuery();
		Deposit d1=new Deposit();
		while (rs.next()) {
			d1.setDeposit_id(rs.getLong("deposit_id"));
		    d1.setClient_id(rs.getInt("client_id"));
		    d1.setBalance(rs.getDouble("balance"));
		    d1.setType(rs.getString("type"));
		    d1.setEstimated_balanse(rs.getLong("estimated_balance"));
		    d1.setOpen_date(rs.getDate("openening_date"));
		    d1.setClose_date(rs.getDate("closing_date"));

		}
		return d1;
	}
	public void deleteDiposit(long deposit_id) throws SQLException
	{
		String sql = "DELETE FROM deposits WHERE deposit_id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setLong(1, deposit_id);
		prest.executeUpdate();
	}
	public void deleteClaentDiposits(int client_id) throws SQLException
	{
		String sql = "DELETE FROM deposits WHERE client_id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setLong(1, client_id);
		prest.executeUpdate();
	}
//	public void updateDeposit(Deposit d1) throws SQLException {
//
//		String sqlUpdate = "UPDATE deposits SET balance=?,type=?,estimated_balance=?,closing_date=? WHERE deposit_id=? ";
//
//		PreparedStatement update = conn.prepareStatement(sqlUpdate);
//		update.setDouble(1, d1.getBalance());
//		update.setString(2, d1.getType());
//		update.setDouble(3,d1.getEstimated_balanse());
//		update.setDate(3, (Date) d1.getClose_date());
//
//		update.executeUpdate();
//
//	}
}
