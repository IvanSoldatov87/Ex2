package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import MBank.core.Activity;
import MBank.core.MBankST;


public class AllActivity extends JInternalFrame{
	
	private AdminFrame parentFrame;
	private JTextField txtClient_id;
	private JLabel lbCiet_id;
	
	private JTable tbActivity= new JTable();;
	private JPanel p1= new JPanel();
	private String[] columnActivity ={"id","Client id","amount","Activity date"," Commissions","Description"};
	private ArrayList<Activity> array = new ArrayList<Activity>();
	
	public AllActivity(AdminFrame parentFrame, String title)
	{

		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		array=MBankST.getInstance().getAction().viewAllActivities();
		p1.setLayout(new FlowLayout());
		tbActivity.setModel(myDataModel);
		p1.setLayout(new FlowLayout());
		p1.add(tbActivity);
		p1.add(new JScrollPane(tbActivity));
		
		this.setLayout(new GridLayout(5,1));
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
		      case 0: return activity.getId();
		      case 2: return activity.getClient_id();
		      case 3: return activity.getAmount();
		      case 4: return activity.getAmount();
		      case 5: return activity.getActivity_date();
		      case 6: return activity.getCommission();
		      case 7: return activity.getDescription();
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
