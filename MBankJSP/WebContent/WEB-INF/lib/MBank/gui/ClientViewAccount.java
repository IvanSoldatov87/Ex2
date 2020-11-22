package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MBank.core.Account;
import MBank.core.AccountDBManager;
import MBank.core.Client;
import MBank.core.MBankST;

public class ClientViewAccount extends JInternalFrame
{
	private ClientFrame parentFrame;
	private JTable tableAccount;
	private JPanel p3= new JPanel();
	private String[] columnNamesAccount ={"Account id","Client id","Balance","Credit limit","Comment"};
	private Account account;
	private Client client;
	
	public ClientViewAccount(ClientFrame parentFrame, String title,Client client)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;	
		this.account=MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
		
		tableAccount = new JTable();
		tableAccount.setModel(accountModel);
		p3.setLayout(new FlowLayout());
		p3.add(tableAccount);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(accountModel);
		tableAccount.setRowSorter(sorter);
		
		p3.add(new JScrollPane(tableAccount));

		this.setLayout(new GridLayout(5,1));
		this.add(p3);
		this.setSize(660, 300);
		this.setVisible(true);
		
	}
	TableModel accountModel = new AbstractTableModel() {
		@Override
		  public int getColumnCount() 
		{ return columnNamesAccount.length; }
		@Override
		  public int getRowCount() 
		{ return 1;}
		@Override
		  public Object getValueAt(int row, int col) {
		    switch (col) {
		      case 0: return String.valueOf(account.getAccount_id());
		      case 1: return String.valueOf(account.getClient_id());
		      case 2: return String.valueOf(account.getBalance());
		      case 3: return String.valueOf(account.getCredit_limit());
		      case 4: return account.getComment();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) 
			{ return columnNamesAccount[column];	}
		@Override
		  public boolean isCellEditable(int row, int col) 
		{return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) 
		{}
		  @Override
		  public Class getColumnClass(int c) 
		  {return (String.class);}
	};
	
}
