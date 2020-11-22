package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

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

import MBank.core.Deposit;
import MBank.core.MBankST;

public class AllDeposits extends JInternalFrame{

	private AdminFrame parentFrame;
	
	private String[] columnNamesDeposit ={"Deposit id","Client id","Balance","Type","Estimated balanse","Open Date","Close Date"};
	ArrayList<Deposit> array = new ArrayList<Deposit>();
	
	public AllDeposits (AdminFrame parentFrame, String title)
	{	
		super(title, true, true, true, true);
		array=MBankST.getInstance().getAction().allDeposits();
		this.parentFrame = parentFrame;
		
		JPanel p1= new JPanel();
		p1.setLayout(new FlowLayout()); 
		
		JTable tbDeposit = new JTable();
		tbDeposit.setModel(myDataModel);
		p1.setLayout(new FlowLayout());

		p1.add(new JScrollPane(tbDeposit));
		//JScrollBar js = new JScrollBar();
		//js.add(tbDeposit);
		p1.add(tbDeposit);
		
		

		this.setLayout(new GridLayout(5,1));
		this.add(p1);
		this.setVisible(true);
		this.setSize(660, 300);
	}
	TableModel myDataModel = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return columnNamesDeposit.length; }
		@Override
		  public int getRowCount() { return array.size();}
		@Override
		  public Object getValueAt(int row, int col) {
		    Deposit deposit = (Deposit) array.get(row);
		    switch (col) {
		      case 0: return deposit.getDeposit_id();
		      case 1: return deposit.getClient_id();
		      case 2: return deposit.getBalance();
		      case 3: return deposit.getType();
		      case 4: return deposit.getEstimated_balanse();
		      case 5: return deposit.getOpen_date();
		      case 6: return deposit.getClose_date();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) {return columnNamesDeposit[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};
}
