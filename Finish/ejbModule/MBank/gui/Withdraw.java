package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MBank.core.Account;
import MBank.core.Client;
import MBank.core.MBankST;

public class Withdraw extends JInternalFrame implements ActionListener {

	private ClientFrame parentFrame;
	
	private JLabel lbWithdraw;
	private JLabel lbBalance;
	
	private JTextField txtWithdraw;
	private JTextField txtBalance;
	private double balance;
	
	Client client;
	Account account = new Account();
	public Withdraw(ClientFrame parentFrame, String title,Client client)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		this.client=client;
		
		account =MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
		
		JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
		
		lbWithdraw = new JLabel("Withdraw");
		txtWithdraw = new JTextField(20);
		p1.add(lbWithdraw);
		p1.add(txtWithdraw);
		
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
		balance=Double.valueOf(txtWithdraw.getText());
		MBankST.getInstance().getActionClient().withdrawAcc(balance,account);
		account =MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
		txtBalance.setText(String.valueOf(account.getBalance()));
		repaint();
		
	}

}
