package MBank.core;

import java.sql.*;
import java.util.ArrayList;

public class ClientDBManager {
	Connection conn;

	public ClientDBManager(Connection conn) {
		this.conn = conn;
	}
	public ClientDBManager() {
	}
	public Client login(String name,String pass)throws SQLException
	{

		String sql = "SELECT * FROM clients WHERE client_name =? AND password =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setString(1, name);
		prest.setString(2, pass);
		ResultSet rs = null;
		rs=prest.executeQuery();
		Client c=new Client();
		while (rs.next()) 
		{
			c.setClient_id(rs.getInt("client_id"));
			c.setUsername(rs.getString("client_name"));
			c.setPassword(rs.getString("password"));
			c.setType(rs.getString("type"));
			c.setAddress(rs.getString("address"));
			c.setEmail(rs.getString("email"));
			c.setPhone(rs.getString("phone"));
			c.setComment(rs.getString("comment"));
		return c;
		}
		return null;
		
	}
	

	public void newClient(Client c1) throws SQLException

	{

		String sqlInsert = "INSERT INTO clients"
				+ "(client_name,password,type,address,email,phone,comment)  VALUES"
				+ "(?,?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(sqlInsert);

		stmt.setString(1, c1.getUsername());
		stmt.setString(2, c1.getPassword());
		stmt.setString(3, c1.getType());
		stmt.setString(4, c1.getAddress());
		stmt.setString(5, c1.getEmail());
		stmt.setString(6, c1.getPhone());
		stmt.setString(7, c1.getComment());

		stmt.executeUpdate();

	}

	public ArrayList<Client> selectAllClients() 
	{
		ArrayList<Client> array = new ArrayList<Client>();
        try {
			Connection con = conn;

			String sqlSelect = "SELECT * FROM clients";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			while (rs.next()) {
				    Client c=new Client();
				    c.setClient_id(rs.getInt("client_id"));
					c.setUsername(rs.getString("client_name"));
					c.setPassword(rs.getString("password"));
					c.setType(rs.getString("type"));
					c.setAddress(rs.getString("address"));
					c.setEmail(rs.getString("email"));
					c.setPhone(rs.getString("phone"));
					c.setComment(rs.getString("comment"));
					array.add(c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;

	}

	public Client selectClient(Integer client_id) throws SQLException

	{

		String sql = "SELECT * FROM clients WHERE client_id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setLong(1, client_id);

		ResultSet rs = null;

		rs = prest.executeQuery();
		Client c=new Client();
		while (rs.next()) {
			c.setClient_id(rs.getInt("client_id"));
			c.setUsername(rs.getString("client_name"));
			c.setPassword(rs.getString("password"));
			c.setType(rs.getString("type"));
			c.setAddress(rs.getString("address"));
			c.setEmail(rs.getString("email"));
			c.setPhone(rs.getString("phone"));
			c.setComment(rs.getString("comment"));

		}
		return c;

	}

	public void deleteClient(int client_id) throws SQLException

	{

		String sql = "DELETE FROM clients WHERE client_id =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setInt(1, client_id);
		prest.executeUpdate();

	}

	public void updateClient(Client c1) throws SQLException {

		String sqlUpdate = "UPDATE clients SET type=?,address=?, email=?,phone=?,comment=?,password=?, client_name=? WHERE client_id=? ";

		PreparedStatement update = conn.prepareStatement(sqlUpdate);
		update.setString(1, c1.getType());
		update.setString(2, c1.getAddress());
		update.setString(3, c1.getEmail());
		update.setString(4, c1.getPhone());
		update.setString(5, c1.getComment());
		update.setString(6, c1.getPassword());
		update.setString(7, c1.getUsername());
		update.setInt(8, c1.getClient_id());

		update.executeUpdate();

	}
}
