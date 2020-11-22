package MBank.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import MBank.core.Client;
import MBank.core.ClientDBManager;
import MBank.core.MBankST;
import MBank.core.STConnection;

public class AllClients extends JInternalFrame{
	
	
	private AdminFrame parentFrame;
	
	ArrayList<Client> array =new ArrayList<Client>();
	String[] columnNames ={"ID","Client name","Type","Email","Password","Address","Phone","Comment"};
	
	
	public AllClients(AdminFrame parentFrame, String title)
	{
		
		super(title, true, true, true, true);
		array= MBankST.getInstance().getAction().viewAllClients();
		this.parentFrame = parentFrame;
		JPanel p1= new JPanel();
		p1.setLayout(new FlowLayout()); 
		JTable table=new JTable();
		table.setModel(myDataModel);
		p1.add(table);
		p1.add(new JScrollPane(table));
		
		
		this.add(p1);
		this.setVisible(true);
		this.setSize(660, 300);
	}
	TableModel myDataModel = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return columnNames.length; }
		@Override
		  public int getRowCount() { return array.size();}
		@Override
		  public Object getValueAt(int row, int col) {
		    Client client = (Client) array.get(row);
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
		  public String getColumnName(int column) {return columnNames[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};
	
	

}
