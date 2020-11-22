package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MBank.core.Account;
import MBank.core.Client;
import MBank.core.MBankST;

public class AllAccounts extends JInternalFrame{
private AdminFrame parentFrame;
	
	ArrayList<Account> array =new ArrayList<Account>();
	private JTable tableAccount;
	private JPanel p1= new JPanel();
	private String[] columnNamesAccount ={"Account id","Client id","Balance","Credit limit","Comment"};
	
	
	public AllAccounts(AdminFrame parentFrame, String title)
	{
		
		super(title, true, true, true, true);
		array= MBankST.getInstance().getAction().viewAllAccount();
		this.parentFrame = parentFrame;
		JPanel p1= new JPanel();
		p1.setLayout(new FlowLayout()); 
		JTable table=new JTable();
		table.setModel(myDataModel);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myDataModel);
		table.setRowSorter(sorter);
		
		p1.add(table);
		p1.add(new JScrollPane(table));
		
		this.setLayout(new GridLayout(1,1));
		this.add(p1);
		this.setVisible(true);
		this.setSize(660, 300);
	}
	TableModel myDataModel = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return columnNamesAccount.length; }
		@Override
		  public int getRowCount() { return array.size();}
		@Override
		  public Object getValueAt(int row, int col) {
		    Account account = (Account) array.get(row);
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
		  public String getColumnName(int column) {return columnNamesAccount[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};

}
