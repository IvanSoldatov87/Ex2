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
import MBank.core.MBankST;

public class NewAccount extends JInternalFrame implements ActionListener{
	private AdminFrame parentFrame;
	Account account = new Account();
	private JButton btnSubmit;
	
	private JLabel lbClient_id;
	private JLabel lbBalance;
	private JLabel lbCredit_limit;
	private JLabel lbComment;
	
	private JTextField txtClient_id;
	private JTextField txtBalance;
	private JTextField txtCredit_limit;
	private JTextField txtComment;
	
	public NewAccount(AdminFrame parentFrame, String title)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        p5.setLayout(new FlowLayout());
		
        //line 1
      	lbClient_id = new JLabel("Client ID");
      	txtClient_id = new JTextField(20);
     	p1.add(lbClient_id);
    	p1.add(txtClient_id);
   		//line 2
    	lbBalance = new JLabel("Balance");
      	txtBalance = new JTextField(20);
  		p2.add(lbBalance);
  		p2.add(txtBalance);
      	//line 3
  		lbCredit_limit = new JLabel("Credit limit");
  		txtCredit_limit = new JTextField(20);
      	p3.add(lbCredit_limit);
      	p3.add(txtCredit_limit);	
      	//line 4
      	lbComment = new JLabel("Comment   ");
      	txtComment = new JTextField(20);
  		p4.add(lbComment);
  		p4.add(txtComment);
  		//line 5
  		btnSubmit = new JButton("Save");
		btnSubmit.addActionListener(this);
		p5.add(btnSubmit);
		p5.add(new JLabel() );

		this.setLayout(new GridLayout(5,2));
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.setVisible(true);
		this.setSize(650, 250);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		account.setClient_id(Integer.parseInt(txtClient_id.getText()));
		account.setBalance(Double.parseDouble(txtBalance.getText()));
		account.setCredit_limit(Integer.parseInt(txtCredit_limit.getText()));
		account.setComment(txtComment.getText());
		MBankST.getInstance().getAction().newAccount(account);
	}
}
