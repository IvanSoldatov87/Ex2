package MBank.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PropertiesDBManeger {
	Connection conn;
	public ArrayList getSysProperties()
	{
		String sql = "SELECT * FROM sysproperties";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList array = new ArrayList();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
