package MBank.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDBManager {
	Connection conn;
	public AccountDBManager(Connection conn)
	{
		this.conn=conn;
	}
	public AccountDBManager(){
	}

	public void newAccount(Account a1) throws SQLException

	{

		String sqlInsert = "INSERT INTO accounts"
				+ "(client_id,balance,credit_limit,comment)  VALUES"
				+ "(?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sqlInsert);

		stmt.setInt(1, a1.getClient_id());
		stmt.setDouble(2, a1.getBalance());
		stmt.setDouble(3, a1.getCredit_limit());
		stmt.setString(4, a1.getComment());


		stmt.executeUpdate();

	}
	public ArrayList<Account> selectAllAccounts() 
	{
		ArrayList<Account> array = new ArrayList<Account>();
        try {
			Connection con = conn;

			String sqlSelect = "SELECT * FROM accounts";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			while (rs.next()) {
					Account a1=new Account();
				    a1.setAccount_id(rs.getLong("account_id"));
				    a1.setClient_id(rs.getInt("client_id"));
					a1.setBalance(rs.getDouble("balance"));
					a1.setCredit_limit(rs.getDouble("credit_limit"));
					a1.setComment(rs.getString("comment"));
					array.add(a1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;

	}
	public Account selectAccount(int client_id) throws SQLException
	{
		String sql = "SELECT * FROM accounts WHERE client_id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setLong(1, client_id);

		ResultSet rs = null;

		rs = prest.executeQuery();
		Account a1=new Account();
		while (rs.next()) {
			a1.setAccount_id(rs.getLong("account_id"));
		    a1.setClient_id(rs.getInt("client_id"));
			a1.setBalance(rs.getDouble("balance"));
			a1.setCredit_limit(rs.getDouble("credit_limit"));
			a1.setComment(rs.getString("comment"));

		}
		return a1;
	}
	public void deleteAccount(int client_id) throws SQLException
	{
		String sql = "DELETE FROM accounts WHERE client_id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setInt(1, client_id);
		prest.executeUpdate();
	}
	public void updateAccount(Account a1) throws SQLException {

		String sqlUpdate = "UPDATE accounts SET account_id=?,balance=?,credit_limit=?,comment=? WHERE client_id=? ";
		PreparedStatement update = conn.prepareStatement(sqlUpdate);
		update.setLong(1, a1.getAccount_id());
		update.setDouble(2, a1.getBalance());
		update.setDouble(3,a1.getCredit_limit());
		update.setString(4, a1.getComment());
		update.setLong(5, a1.getClient_id());

		update.executeUpdate();

	}
	
	
	
}
