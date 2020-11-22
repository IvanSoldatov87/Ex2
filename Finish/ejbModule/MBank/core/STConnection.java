package MBank.core;

import java.sql.*;

public final class STConnection {
	
	private static Connection conn;
	public static STConnection db;
	private STConnection() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "mbankdb";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "admin";
        try {
            Class.forName(driver).newInstance();
            
            conn = DriverManager.getConnection(url + dbName, userName,
                    password);
        } catch (Exception sqle) {
            System.out.println("let's go babe");
            sqle.printStackTrace();
        }     
    }
	public synchronized static   STConnection getInstance() {
        if (db == null) {
            db = new STConnection();
        }
        return db;
    }
    public Connection getConn() {
        return conn;
    }
    public static void setConn(Connection conn) {
    	STConnection.conn = conn;
    }

}
