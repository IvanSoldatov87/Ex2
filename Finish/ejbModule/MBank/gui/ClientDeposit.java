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

import MBank.core.Account;
import MBank.core.Client;
import MBank.core.Deposit;
import MBank.core.MBankST;

public class ClientDeposit extends JInternalFrame implements ActionListener{
	private AdminFrame parentFrame;
	private JTextField txtClient_id;
	private JLabel lbCiet_id;
	
	private JTable tbDeposit;
	private JPanel p2= new JPanel();
	private String[] columnNamesDeposit ={"Deposit id","Client id","Balance","Type","Estimated balanse","Open Date","Close Date"};
	ArrayList<Deposit> array = new ArrayList<Deposit>();
	
	public ClientDeposit (AdminFrame parentFrame, String title)
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
		
		tbDeposit = new JTable();
		p2.setLayout(new FlowLayout());
		p2.add(tbDeposit);
		p2.add(new JScrollPane(tbDeposit));
		

		this.setLayout(new GridLayout(5,1));
		this.add(p1);
		this.add(p2);
		this.setSize(660, 600);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int client_id = Integer.parseInt(txtClient_id.getText());
		array=MBankST.getInstance().getAction().clientDeposits(client_id);
		tbDeposit.setModel(myDataModel);
		repaint();
		
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
