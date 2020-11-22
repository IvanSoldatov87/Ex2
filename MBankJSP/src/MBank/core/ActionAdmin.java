package MBank.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument.BranchElement;

public class ActionAdmin extends Action{
Connection conn= STConnection.getInstance().getConn();
Client client= new Client();
public boolean login(String name,String pass)
{
	SysDBManeger sysdb = new SysDBManeger(conn);
	try {
		return sysdb.login(name, pass);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
	
}
	public Account NewClient(Client client)
	{
		ArrayList<Client> array = new ArrayList<Client>();
		Account account =new Account();
		ClientDBManager clientDB= new ClientDBManager(conn);
		
		boolean new_client=true;
		try {
			array=clientDB.selectAllClients();
			for (int i=0;i<array.size();i++) 
			{
			
				if((array.get(i).getUsername().equals(client.getUsername()))&&(array.get(i).getPassword().equals(client.getPassword())))
				{
					System.out.println("Error");
					new_client=false;
				}
			}
			if(new_client)	
			{
				clientDB.newClient(client);
				array = clientDB.selectAllClients();
				for (int i=0;i<array.size();i++)
				{
					if((array.get(i).getUsername().equals(client.getUsername())) && (array.get(i).getPassword().equals(client.getPassword())))
					{
						this.client=array.get(i);
					}
				}
			
				AccountDBManager accountDB= new AccountDBManager(conn);
				SysDBManeger sysDB= new SysDBManeger(conn);
				account.setClient_id(this.client.getClient_id());
				if(this.client.getType().equals("Regular"))
				{
					account.setCredit_limit(sysDB.getProperties().getRegular_credit_limit());
				}
				if(this.client.getType().equals("Gold"))
				{
					account.setCredit_limit(sysDB.getProperties().getGold_credit_limit());
				}
				if(this.client.getType().equals("Platinum"))
				{
					account.setCredit_limit(sysDB.getProperties().getPlatinum_credit_limit());
				}
				account.setComment(client.getComment());
				accountDB.newAccount(account);
				return account;
			}	
		} 
		catch (SQLException e) 
		{

				e.printStackTrace();
		}
		return account;
	
	}
			
		
	public void removeClient(int client_id)
	{
		ClientDBManager clientDB= new ClientDBManager(conn);
		AccountDBManager accountDB= new AccountDBManager(conn);
		DepositDBMeneger depositDB=new DepositDBMeneger(conn);
		try {
			
			clientDB.deleteClient(client_id);
			accountDB.deleteAccount(client_id);
			depositDB.deleteClaentDiposits(client_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void newAccount(Account account)
	{
		ArrayList<Account> array= new ArrayList<Account>();
		AccountDBManager accountDB= new AccountDBManager(conn);
		boolean new_account=true;
		boolean new_client=false;
		array=accountDB.selectAllAccounts();
		
		ArrayList<Client> carray=new ArrayList<Client>();
		ClientDBManager clientDB= new ClientDBManager(conn);
		carray=clientDB.selectAllClients();
		

			for (int i=0;array.size()>i;i++) 
			{
			
				if((array.get(i).getClient_id())==(account.getClient_id()))
				{
					new_account=false;
				}
			}
			for (int j=0;carray.size()>j;j++) 
			{
					
				if(carray.get(j).getClient_id()== account.getClient_id())
				{
					new_client=true;
				}		
			}
			if((new_account) && (new_client))
			{
				try {
					
					accountDB.newAccount(account);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	public void removeAccount(int client_id)
	{
		AccountDBManager accountDB= new AccountDBManager(conn);
		try {
			if(accountDB.selectAccount(client_id).getBalance()<0)
			{
				String s="no mony";
				JOptionPane.showMessageDialog(null, "No mony");
			}else{
				accountDB.deleteAccount(client_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Client> viewAllClients()
	{
		ClientDBManager clientDB= new ClientDBManager(conn);
		
		return clientDB.selectAllClients();
	}
	public ArrayList<Account> viewAllAccount()
	{
		AccountDBManager accountDB= new AccountDBManager(conn);
		return accountDB.selectAllAccounts();
	}
	public ArrayList<Deposit> viewAllDeposits()
	{
		DepositDBMeneger depositDB =new DepositDBMeneger(conn);
		return depositDB.selectAllDeposits();
		
	}
	public ArrayList<Activity> viewAllActivities()
	{
		ActivityDBMeneger activityDB =new ActivityDBMeneger(conn);
		return activityDB.selectAllActivitys();
	}
	public void updateAccount(Account account)
	{	
		AccountDBManager accountDB=new AccountDBManager(conn);
		try {
			accountDB.updateAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Account getAccount(int client_id)
	 {
		 AccountDBManager accountDB =new AccountDBManager(conn);
		 
		 try {
			return accountDB.selectAccount(client_id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error ActionAdmin.getAccount");
		}
		return null;
	 }
	
	public SysProperties getSys()
	 {
		 SysDBManeger sys =new SysDBManeger(conn);
		 try {
			return sys.getProperties();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	 }
	public void updateSys(SysProperties newSys)
	 {
		 SysDBManeger sys =new SysDBManeger(conn);
		 try {
			sys.updateSysProperties(newSys);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	public void deleteDeposit(Deposit deposit){
		DepositDBMeneger dbDeposit=new DepositDBMeneger(conn);
		try {
			dbDeposit.deleteDiposit(deposit.getDeposit_id());
			JOptionPane.showMessageDialog(null, "Client ID:"+deposit.getClient_id()+" Deposit time out,deposit id:"+deposit.getDeposit_id()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
