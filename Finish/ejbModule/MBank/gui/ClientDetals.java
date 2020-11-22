package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import MBank.core.Account;
import MBank.core.Client;
import MBank.core.MBankST;

public class ClientDetals extends JInternalFrame implements ActionListener{
	private AdminFrame parentFrame;
	private JTextField txtClient_id;
	private JLabel lbCiet_id;
	private JTable tableClient;
	private JPanel p2= new JPanel();
	private Client client= new Client();
	private String[] columnNamesClient ={"ID","Client name","Password","Type","Email","Address","Phone","Comment"};

	private JTable tableAccount;
	private JPanel p3= new JPanel();
	private String[] columnNamesAccount ={"Account id","Client id","Balance","Credit limit","Comment"};
	private Account account= new Account();
	
	public ClientDetals(AdminFrame parentFrame, String title)
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
		
		tableClient = new JTable();
		p2.setLayout(new FlowLayout());
		p2.add(tableClient);
		p2.add(new JScrollPane(tableClient));
		
		tableAccount = new JTable();
		p3.setLayout(new FlowLayout());
		p3.add(tableAccount);
		p3.add(new JScrollPane(tableAccount));
		
		
		
		this.setLayout(new GridLayout(5,1));
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setSize(660, 600);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
			int client_id = Integer.parseInt(txtClient_id.getText());
			client=MBankST.getInstance().getAction().getClient(client_id);
			account=MBankST.getInstance().getAction().getAccount(client_id);
			tableClient.setModel(clientModel);
			tableAccount.setModel(accountModel);
			repaint();			
	}
	TableModel clientModel = new AbstractTableModel() {
		@Override
		  public int getColumnCount() 
		{ return columnNamesClient.length; }
		@Override
		  public int getRowCount() 
		{ return 1;}
		@Override
		  public Object getValueAt(int row, int col) {
		    switch (col) {
		      case 0: return client.getClient_id();
		      case 1: return client.getUsername();
		      case 2: return client.getPassword();
		      case 3: return client.getAddress();
		      case 4: return client.getEmail();
		      case 5: return client.getPhone();
		      case 6: return client.getType();
		      case 7: return client.getComment();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) 
			{ return columnNamesClient[column];	}
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
		      case 0: return account.getAccount_id();
		      case 1: return account.getClient_id();
		      case 2: return account.getBalance();
		      case 3: return account.getCredit_limit();
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
