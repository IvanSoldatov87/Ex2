package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import MBank.core.Activity;
import MBank.core.Deposit;
import MBank.core.MBankST;

public class ClientActivity extends JInternalFrame implements ActionListener{
	private AdminFrame parentFrame;
	private JTextField txtClient_id;
	private JLabel lbCiet_id;
	
	private JTable tbActivity;
	private JPanel p2= new JPanel();
	private String[] columnActivity ={"id","Client id","amount","Activity date"," Commissions","Description"};
	ArrayList<Activity> array = new ArrayList<Activity>();
	
	public ClientActivity(AdminFrame parentFrame, String title)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		JPanel p1= new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		lbCiet_id= new JLabel("Client id");
		txtClient_id=new JTextField(20);
		JButton jbOK=new JButton("OK");
		jbOK.addActionListener(this);
		p1.add(lbCiet_id);
		p1.add(txtClient_id);
		p1.add(jbOK);
		
		tbActivity = new JTable();
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myDataModel);
		tbActivity.setRowSorter(sorter);
		
		p2.add(tbActivity);
		p2.add(new JScrollPane(tbActivity));
		

		this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		this.add(p1);
		this.add(p2);
		this.setSize(660, 600);
		this.setVisible(true);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		int client_id = Integer.parseInt(txtClient_id.getText());
		array=MBankST.getInstance().getAction().clientActivities(client_id);
		tbActivity.setModel(myDataModel);
		repaint();
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
