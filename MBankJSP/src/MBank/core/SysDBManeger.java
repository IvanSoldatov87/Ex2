package MBank.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SysDBManeger {
	Connection conn;
	public SysDBManeger(Connection conn)
	{
		this.conn=conn;
	}
	public SysDBManeger()
	{
	}
	public boolean login(String name,String pass)throws SQLException
	{

		String sql = "SELECT * FROM sysproperties WHERE admin_username =? AND admin_password =?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setString(1, name);
		prest.setString(2, pass);
		ResultSet rs = null;
		rs=prest.executeQuery();
		Client c=new Client();
		while (rs.next())
		{
			return true;
		}
		return false;
		
	}
	public SysProperties getProperties() throws SQLException
	{
		String sql = "SELECT * FROM sysproperties";
		PreparedStatement prest = conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = prest.executeQuery();
		SysProperties sys=new SysProperties();
		while (rs.next()) {
			sys.setRegular_deposit_rate(rs.getInt("regular_deposit_rate"));
			sys.setGold_deposit_rate(rs.getInt("gold_deposit_rate"));
			sys.setPlatinum_deposit_rate(rs.getInt("platinum_deposit_rate"));
			sys.setRegular_deposit_commission(rs.getDouble("regular_deposit_commission"));
			sys.setGold_deposit_commission(rs.getDouble("gold_deposit_commission"));
			sys.setPlatinum_deposit_commission(rs.getDouble("platinum_deposit_commission"));
			sys.setRegular_credit_limit(rs.getInt("regular_credit_limit"));
			sys.setGold_credit_limit(rs.getInt("gold_credit_limit"));
			sys.setPlatinum_credit_limit(rs.getInt("platinum_credit_limit"));
			sys.setCommision_rate(rs.getDouble("commision_rate"));
			sys.setRegular_daily_interest(rs.getString("regular_daily_interest"));
			sys.setGold_daily_interest(rs.getString("gold_daily_interest"));
			sys.setPlatinum_daily_interest(rs.getString("platinum_daily_interest"));
			sys.setPre_open_free(rs.getDouble("pre_open_free"));
			sys.setAdminUsername(rs.getString("admin_username"));
			sys.setAdminPassword(rs.getString("admin_password"));
		}
		return sys;
	}
	public void updateSysProperties(SysProperties sys) throws SQLException {

		String sqlUpdate = "UPDATE sysproperties SET regular_deposit_rate=?,gold_deposit_rate=?,platinum_deposit_rate=?,"
		+"regular_deposit_commission =?,gold_deposit_commission=?,platinum_deposit_commission=?,"
		+"regular_credit_limit=?,gold_credit_limit=?,platinum_credit_limit=?,"
		+"commision_rate=?,regular_daily_interest=?,gold_daily_interest=?,platinum_daily_interest=?,"
		+"pre_open_free=?,admin_username=?,admin_password=? WHERE admin_username";

		PreparedStatement update = conn.prepareStatement(sqlUpdate);
		update.setInt(1,sys.getRegular_deposit_rate());
		update.setInt(2,sys.getGold_deposit_rate());
		update.setInt(3,sys.getPlatinum_deposit_rate());
		update.setDouble(4, sys.getRegular_deposit_commission());
		update.setDouble(5, sys.getGold_deposit_commission());
		update.setDouble(6, sys.getPlatinum_deposit_commission());
		update.setInt(7, sys.getRegular_credit_limit());
		update.setInt(8, sys.getGold_credit_limit());
		update.setInt(9, sys.getPlatinum_credit_limit());
		update.setDouble(10,sys.getCommision_rate());
		update.setString(11, sys.getRegular_daily_interest());
		update.setString(12, sys.getGold_daily_interest());
		update.setString(13, sys.getPlatinum_daily_interest());
		update.setDouble(14, sys.getPre_open_free());
		update.setString(15, sys.getAdminUsername());
		update.setString(16, sys.getAdminPassword());
		update.executeUpdate();

	}

}
