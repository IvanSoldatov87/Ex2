package MBank.core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

public class ActionClient extends Action{
	Connection conn= STConnection.getInstance().getConn();
	Client client;
	Account account= new Account();
	Deposit deposit;
	double balance;
	public ActionClient(Client client)
	{
		this.client=client;
	}
	public ActionClient()
	{
	}
	public Account getAccount(int client_id)
	{
		AccountDBManager accoutn = new AccountDBManager(conn);
		
		try {
			return accoutn.selectAccount(client_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public Client login(String name,String pass)
	{
		ClientDBManager clientDB = new ClientDBManager(conn);
		try {
			this.client=clientDB.login(name, pass);
			return clientDB.login(name, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void setAccount(Account account)
	{	
		AccountDBManager accountDB=new AccountDBManager(conn);
		try {
			accountDB.updateAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void withdrawAcc(double mony,Account account)
	{
		this.account=account;
		AccountDBManager acc = new AccountDBManager(conn);
		SysDBManeger sysDB =new SysDBManeger(conn);
		
		SysProperties sys=new SysProperties();
		try {
			sys = sysDB.getProperties();
			if((account.getBalance()-sys.getCommision_rate()-mony)>(-(account.getCredit_limit())))
			{
				double balanc=account.getBalance();
				balanc=(balanc-sys.getCommision_rate())-mony;
				this.account.setBalance(balanc);
				setAccount(this.account);
				ActivityDBMeneger act=new ActivityDBMeneger(conn);
				activity.setActivity_date(Calendar.getInstance().getTime());
				activity.setAmount(account.getBalance());
				activity.setClient_id(client.getClient_id());
				activity.setCommission(sys.getCommision_rate());
				activity.setDescription("Withdraw from account");
				act.newActivity(activity);
			}
			else
			{
				System.out.println("No mony");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void depositToAccount(Deposit deposit,Account account) throws SQLException
	{
		SysProperties sys=new SysProperties();
		SysDBManeger sysDB =new SysDBManeger(conn);
		sys= sysDB.getProperties();
		AccountDBManager accountDB=new AccountDBManager(conn);
		ActivityDBMeneger act=new ActivityDBMeneger(conn);
		this.account=account;
		
		double balance=account.getBalance();
		balance=balance+(deposit.getBalance()-sys.getCommision_rate());
		this.account.setBalance(balance);
		setAccount(this.account);
		
		accountDB.updateAccount(account);
		activity.setActivity_date(Calendar.getInstance().getTime());
		activity.setAmount(account.getBalance());
		activity.setClient_id(client.getClient_id());
		activity.setCommission(sys.getCommision_rate());
		activity.setDescription("Deposit to Account");
		act.newActivity(activity);
		
	}
	public void newDeposit(Deposit deposit,Account account,Client client) throws SQLException
	{
		ClientDBManager clientDB= new ClientDBManager(conn);
		DepositDBMeneger depositDB = new DepositDBMeneger(conn);
		ActivityDBMeneger act=new ActivityDBMeneger(conn);
		this.deposit = deposit;
		double balanse=this.deposit.getBalance();	
		if(client.getType().equals("Regular"))
		{
			balanse=balanse*1.05;
			this.deposit.setBalance(balanse);
			depositDB.newDeposit(this.deposit);
			
			
			activity.setActivity_date(Calendar.getInstance().getTime());
			activity.setAmount(account.getBalance());
			activity.setClient_id(client.getClient_id());
			activity.setDescription("New Deposit");
			act.newActivity(activity);
		}
		if(client.getType().equals("Gold"))
		{
			balanse=balanse*1.07;
			this.deposit.setBalance(balanse);
			depositDB.newDeposit(this.deposit);
			
			activity.setActivity_date(Calendar.getInstance().getTime());
			activity.setAmount(account.getBalance());
			activity.setClient_id(client.getClient_id());
			activity.setDescription("New Deposit");
			act.newActivity(activity);
		}
		if(client.getType().equals("Platinum"))
		{
			balanse=balanse*1.08;
			this.deposit.setBalance(balanse);
			depositDB.newDeposit(this.deposit);
			
			activity.setActivity_date(Calendar.getInstance().getTime());
			activity.setAmount(account.getBalance());
			activity.setClient_id(client.getClient_id());
			activity.setDescription("New Deposit");
			act.newActivity(activity);
		}	
		
	}
	public void pre_openDeposit(Deposit deposit,Client client) throws SQLException
	{
		AccountDBManager accountDB=new AccountDBManager(conn);
		DepositDBMeneger depositDB = new DepositDBMeneger(conn);
		ActivityDBMeneger act=new ActivityDBMeneger(conn);
		SysProperties sys=new SysProperties();
		SysDBManeger sysDB =new SysDBManeger(conn);
		sys= sysDB.getProperties();
		this.deposit=deposit;
		if(deposit.getType().endsWith("Short"))
		{
			System.out.println("ERROR");
		}else{
			if(deposit.getClient_id()==client.getClient_id())
			{
				account=accountDB.selectAccount(deposit.getClient_id());
				balance= deposit.getBalance()-(deposit.getBalance()/100);
				balance=balance+accountDB.selectAccount(deposit.getClient_id()).getBalance();
				account.setBalance(balance);
				accountDB.updateAccount(account);
				depositDB.deleteDiposit(this.deposit.getDeposit_id());
				
				
				activity.setActivity_date(Calendar.getInstance().getTime());
				activity.setAmount(account.getBalance());
				activity.setCommission(sys.getPre_open_free());
				activity.setClient_id(client.getClient_id());
				activity.setDescription("Pre opening Deposit");
				act.newActivity(activity);
			}
		}
	}


}
