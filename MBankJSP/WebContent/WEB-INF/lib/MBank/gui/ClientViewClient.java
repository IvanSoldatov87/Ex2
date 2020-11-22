package MBank.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import MBank.core.Client;

public class ClientViewClient extends JInternalFrame{

	private ClientFrame parentFrame;
	private JTable tableClient;
	private JPanel p2= new JPanel();
	private Client client= new Client();
	private String[] columnNamesClient ={"ID","Client name","Password","Address","Email","Phone","Type","Comment"};
	public ClientViewClient (ClientFrame parentFrame,String title,Client client)
	{

		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		this.client=client;
		
		tableClient = new JTable();
		p2.setLayout(new FlowLayout());
		p2.add(tableClient);
		p2.add(new JScrollPane(tableClient));
		tableClient.setModel(clientModel);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(clientModel);
		tableClient.setRowSorter(sorter);
		
		this.add(p2);
		this.setSize(600, 300);
		this.setVisible(true);
		
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
		      case 0: return String.valueOf(client.getClient_id());
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
	
}
