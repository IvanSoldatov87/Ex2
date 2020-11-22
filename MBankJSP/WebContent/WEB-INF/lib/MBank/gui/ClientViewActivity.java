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

import MBank.core.Activity;
import MBank.core.Client;
import MBank.core.MBankST;

public class ClientViewActivity extends JInternalFrame{

	private ClientFrame parentFrame;
	private JTable tbActivity=new JTable();;
	private JPanel p1= new JPanel();
	private String[] columnActivity ={"id","Client id","amount","Activity date"," Commissions","Description"};
	private ArrayList<Activity> array = new ArrayList<Activity>();
	
	public ClientViewActivity (ClientFrame parentFrame,String title,Client client)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		array=MBankST.getInstance().getActionClient().clientActivities(client.getClient_id());
		
		p1.setLayout(new FlowLayout());
		tbActivity.setModel(myDataModel);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myDataModel);
		tbActivity.setRowSorter(sorter);
		
		p1.setLayout(new FlowLayout());
		p1.add(tbActivity);
		p1.add(new JScrollPane(tbActivity));
		
		this.setLayout(new GridLayout(1,1));
		this.add(p1);
		this.setSize(660, 600);
		this.setVisible(true);
		
	}
	TableModel myDataModel = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return columnActivity.length; }
		@Override
		  public int getRowCount() { return array.size();}
		@Override
		  public Object getValueAt(int row, int col) {
		    Activity activity = (Activity) array.get(row);
		    switch (col) {
		      case 0: return String.valueOf(activity.getId());
		      case 1: return String.valueOf(activity.getClient_id());
		      case 2: return String.valueOf(activity.getAmount());
		      case 3: return String.valueOf(activity.getActivity_date());
		      case 4: return String.valueOf(activity.getCommission());
		      case 5: return activity.getDescription();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) {return columnActivity[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};
}
