package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MBank.core.Account;
import MBank.core.MBankST;



public class AccountDetals extends JInternalFrame implements ActionListener{
	
	private AdminFrame parentFrame;
	private JTextField txtClient_id;
	private JLabel lbCiet_id;
	
	private JTable tableAccount;
	private JPanel p2= new JPanel();
	private String[] columnNamesAccount ={"Account id","Client id","Balance","Credit limit","Comment"};
	private Account account= new Account();
	public AccountDetals(AdminFrame parentFrame, String title)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		JPanel p1= new JPanel();
		p1.setLayout(new FlowLayout());
		lbCiet_id= new JLabel("Client id");
		txtClient_id=new JTextField(20);
		JButton jbOK=new JButton("OK");
		jbOK.addActionListener(this);
		p1.add(lbCiet_id);
		p1.add(txtClient_id);
		p1.add(jbOK);
		
		tableAccount = new JTable();
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(accountModel);
		tableAccount.setRowSorter(sorter);
		
		p2.setLayout(new FlowLayout());
		p2.add(tableAccount);
		p2.add(new JScrollPane(tableAccount));
		

		this.setLayout(new GridLayout(5,1));
		this.add(p1);
		this.add(p2);
		this.setSize(660, 600);
		this.setVisible(true);
	

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int client_id = Integer.parseInt(txtClient_id.getText());
		account=MBankST.getInstance().getAction().getAccount(client_id);
		tableAccount.setModel(accountModel);
		repaint();
		
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
	
