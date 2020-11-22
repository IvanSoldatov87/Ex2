package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import MBank.core.Activity;
import MBank.core.MBankST;
import MBank.core.SysProperties;

public class ViewSys extends JInternalFrame{
	private AdminFrame parentFrame;
	private JTable tbSys1;
	private JTable tbSys2;
	private JTable tbSys3;
	private JTable tbSys4;
	private JPanel p1= new JPanel();
	private JPanel p2= new JPanel();
	private String[] column1={"Regular Deposit rate","Gold Deposit rate","Platinum Deposit rate","Regular Deposit commission"};
	private String[] column2={" Gold Deposit commission","Platimun Deposit commission","Regular Deposit limit","Gold Deposit limit"};
	private String[] column3={"Platinum Deposit limit","Commision rate","Regular daily interest","Gold daily interest"};
	private String[] column4={"Platinum daily interest","Pre opening free","Admin username","Admin password"};
	
	SysProperties sys = new SysProperties();
	public ViewSys (AdminFrame parentFrame, String title)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		JPanel p1= new JPanel();
		p1.setLayout(new FlowLayout());
		JPanel p2= new JPanel();
		p2.setLayout(new FlowLayout());
		
		sys=MBankST.getInstance().getAction().getSysProperty();
		
		tbSys1 = new JTable();
		tbSys2 = new JTable();
		tbSys3 = new JTable();
		tbSys4 = new JTable();
		
		tbSys1.setModel(model1);
		tbSys2.setModel(model2);
		tbSys3.setModel(model3);
		tbSys4.setModel(model4);
		
		p1.add(new JScrollPane(tbSys1));
		p1.add(new JScrollPane(tbSys2));
		p2.add(new JScrollPane(tbSys3));
		p2.add(new JScrollPane(tbSys4));
		
		this.setLayout(new GridLayout(5,1));
		this.add(p1);
		this.add(p2);
		this.setSize(950, 500);
		this.setVisible(true);
	}

	TableModel model1 = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return column1.length; }
		@Override
		  public int getRowCount() { return 4;}
		@Override
		  public Object getValueAt(int row, int col) {
		    switch (col) {
		      case 0: return sys.getRegular_deposit_rate();
		      case 1: return sys.getGold_deposit_rate();
		      case 2: return sys.getPlatinum_deposit_rate();
		      case 3: return sys.getRegular_deposit_commission();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) {return column1[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};
	TableModel model2 = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return column2.length; }
		@Override
		  public int getRowCount() { return 4;}
		@Override
		  public Object getValueAt(int row, int col) {
		    switch (col) {
		      case 0: return sys.getGold_deposit_commission();
		      case 1: return sys.getPlatinum_deposit_commission();
		      case 2: return sys.getRegular_credit_limit();
		      case 3: return sys.getGold_credit_limit();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) {return column2[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};
	TableModel model3 = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return column3.length; }
		@Override
		  public int getRowCount() { return 4;}
		@Override
		  public Object getValueAt(int row, int col) {
		    switch (col) {
		      case 0: return sys.getPlatinum_credit_limit();
		      case 1: return sys.getCommision_rate();
		      case 2: return sys.getRegular_daily_interest();
		      case 3: return sys.getGold_daily_interest();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) {return column3[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};
	TableModel model4 = new AbstractTableModel() {
		@Override
		  public int getColumnCount() { return column4.length; }
		@Override
		  public int getRowCount() { return 4;}
		@Override
		  public Object getValueAt(int row, int col) {
		    switch (col) {
		      case 0: return sys.getPlatinum_daily_interest();
		      case 1: return sys.getPre_open_free();
		      case 2: return sys.getAdminUsername();
		      case 3: return sys.getAdminPassword();
		      default: return "";
		    }
		  }
		@Override
		  public String getColumnName(int column) {return column4[column];}
		@Override
		  public boolean isCellEditable(int row, int col) {return false;}
		@Override
		  public void setValueAt(Object aValue, int row, int column) {}
		  @Override
		  public Class getColumnClass(int c) {return (String.class);}
	};
	
}
