package MBank.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Action {
	Client client= new Client();
	Account account =new Account();
	Deposit deposite=new Deposit();
	Activity activity=new Activity();
	Connection conn= STConnection.getInstance().getConn();
	//String[] columnDeposit ={"Deposit ID","Client ID","Balanse","Type","estimated_balance","estimated_balance","closing_date"};
	//ArrayList array =new ArrayList();
	public void updateClient(Client client)
	
	{
		ClientDBManager cdb = new ClientDBManager(conn);
		try {
			
			cdb.updateClient(client);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Client getClient(int id)
	{
		ClientDBManager cdb = new ClientDBManager(conn);
		try {
			client=cdb.selectClient(id);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	public ArrayList clientDetails(int id)
	{
		ClientDBManager cdb = new ClientDBManager(conn);
		
		ArrayList array= new ArrayList();
		try {
			array.add(cdb.selectClient(id));
			array.add(accountDetails(id));
			array.add(clientDeposits(id));
			array.add(clientActivities(id));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Account accountDetails(int id)
	{
		AccountDBManager adb= new AccountDBManager(conn);
		try {
			return adb.selectAccount(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Deposit> clientDeposits(int id)
	{
		DepositDBMeneger ddb=new DepositDBMeneger(conn);
		return ddb.selectAllClientDeposits(id);
	}
	public Deposit clientDeposits(long id)
	{
		DepositDBMeneger ddb=new DepositDBMeneger(conn);
		try {
			return ddb.selectDeposit(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Deposit> allDeposits()
	{
		DepositDBMeneger ddb=new DepositDBMeneger(conn);
		return ddb.selectAllDeposits();
	}
	
	public ArrayList<Activity> clientActivities(int id)
	{
	ActivityDBMeneger adb = new ActivityDBMeneger(conn);
	return adb.selectClientActivitys(id);
	}
	
	
	
	public SysProperties getSysProperty()
	{
		SysDBManeger sysDBM= new SysDBManeger(conn);
		try {
			return sysDBM.getProperties();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateSysProperty(SysProperties sys)
	{
		SysDBManeger sysDBM= new SysDBManeger(conn);
		try {
			sysDBM.updateSysProperties(sys);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setActivity(Activity act)
	{
		ActivityDBMeneger actDB = new ActivityDBMeneger(conn);
		try {
			actDB.newActivity(act);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	TableModel depositsModel = new AbstractTableModel() {
//		@Override
//		  public int getColumnCount() { return columnDeposit.length; }
//		@Override
//		  public int getRowCount() { return array.size();}
//		@Override
//		  public Object getValueAt(int row, int col) {
//		    Deposit deposit = (Deposit) array.get(row);
//		    switch (col) {
//		      case 0: return deposit.deposit_id();
//		      case 1: return deposit.getClient_id();
//		      case 2: return deposit.getBalance();
//		      case 3: return deposit.getType();
//		      case 4: return deposit.getEstimated_balanse();
//		      case 5: return deposit.getOpen_date();
//		      case 6: return deposit.getClose_date();
//		      default: return "";
//		    }
//		  }
//		@Override
//		  public String getColumnName(int column) {return columnNames[column];}
//		@Override
//		  public boolean isCellEditable(int row, int col) {return false;}
//		@Override
//		  public void setValueAt(Object aValue, int row, int column) {}
//		  @Override
//		  public Class getColumnClass(int c) {return (String.class);}
//	};

}
