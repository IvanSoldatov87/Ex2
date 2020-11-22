package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MBank.core.Account;
import MBank.core.Client;
import MBank.core.Deposit;
import MBank.core.MBankST;

public class NewDeposit extends JInternalFrame implements ActionListener{
	
	private JButton btnSubmit;
	
	private JLabel lbBalance;
	private JLabel lbDeposit;
	private JLabel lbDate;
	
	private JTextField txtBalance;
	private JTextField txtDeposit;
	private JTextField txtDate;
	
	private ClientFrame parentFrame;
	private Client client= new Client();
	private Account account=new Account();
	private Deposit deposit = new Deposit();
	private double balance;
	private JComboBox cbYear;
	private JComboBox cbMons;
	
	private String[] numYears={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"
			,"18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40"};
	
	private String[] numMounts={"1","2","3","4","5","6","7","8","9","10","11"};
	public NewDeposit(ClientFrame parentFrame,String title,Client client)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		this.client=client;
		
		account =MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
		
		JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        
		lbDeposit = new JLabel("Deposit");
		txtDeposit = new JTextField(20);
		p1.add(lbDeposit);
		p1.add(txtDeposit);
		
		p1.add(new JLabel("Years"));
		cbYear = new JComboBox(numYears);
		p1.add(cbYear);
		
		p1.add(new JLabel("Mounts"));
		cbMons = new JComboBox(numMounts);
		p1.add(cbMons);
		
		
		
		lbBalance = new JLabel("Balance");
		txtBalance = new JTextField(20);
		JButton jb = new JButton("Send");
		jb.addActionListener(this);
		p2.add(jb);
		txtBalance.setText(String.valueOf(account.getBalance()));
		p2.add(lbBalance);
		p2.add(txtBalance);
		
		

		this.setLayout(new GridLayout(5,2));
		this.add(p1);
		this.add(p2);
		this.setVisible(true);
		this.setSize(650, 250);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Date op_date = new Date();

		
		Date clo_date = new Date();
		Calendar cal= Calendar.getInstance();
		
		cal.add(Calendar.YEAR, cbYear.getSelectedIndex());
		cal.add(Calendar.MONTH, cbMons.getSelectedIndex()+1);
		clo_date= cal.getTime();

		
		balance=Double.valueOf(txtDeposit.getText());
		deposit.setBalance(balance);
		deposit.setClient_id(client.getClient_id());
		deposit.setOpen_date(op_date);
		deposit.setClose_date(cal.getTime());
		deposit.setClose_date(clo_date);
		MBankST.getInstance().getActionClient().withdrawAcc(balance,account);
		account =MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
		txtBalance.setText(String.valueOf(account.getBalance()));
		
		txtDeposit.setText("");
		try {
			JOptionPane.showMessageDialog(null, "New Deposit");
			MBankST.getInstance().getActionClient().newDeposit(deposit, account,client);
			JOptionPane.showMessageDialog(null, "New Deposit created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		repaint();
		
	}
	
	
}
