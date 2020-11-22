package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MBank.core.Account;
import MBank.core.Client;
import MBank.core.Deposit;
import MBank.core.MBankST;

public class DepositToAccount extends JInternalFrame implements ActionListener{
	
	private ClientFrame parentFrame;
	
	private JLabel lbDeposit;
	private JLabel lbBalance;
	
	private JTextField txtDeposit;
	private JTextField txtBalance;
	private double balance;
	
	Client client;
	Deposit deposit = new Deposit();
	Account account = new Account();
	public DepositToAccount(ClientFrame parentFrame,String title,Client client)
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
		balance=Integer.parseInt(txtDeposit.getText());
		deposit.setBalance(balance);
		deposit.setClient_id(client.getClient_id());
		deposit.setType(client.getType());
		try {
			MBankST.getInstance().getActionClient().depositToAccount(deposit, account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		account =MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
		txtBalance.setText(String.valueOf(account.getBalance()));
		txtDeposit.setText("");
		repaint();
	}
}
