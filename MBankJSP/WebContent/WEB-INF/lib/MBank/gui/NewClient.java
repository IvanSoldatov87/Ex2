package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MBank.core.Account;
import MBank.core.Client;
import MBank.core.ClientDBManager;
import MBank.core.MBankST;
import MBank.core.STConnection;



public class NewClient extends JInternalFrame implements ActionListener,KeyListener{
	
	private JButton btnSubmit;

	private JLabel lbName;
	private JLabel lbBalanse;
	private JLabel lbEmail;
	private JLabel lbPass;
	private JLabel lbAdress;
	private JLabel lbPhone;
	private JLabel lbComment;
	
	private JTextField txtName;
	private JTextField txtBalanse;
	private JTextField txtEmail;
	private JTextField txtPass;
	private JTextField txtAdress;
	private JTextField txtPhone;
	private JTextField txtComment;
	
	private String[] typeName = {"Regular","Gold","Platinum"};
	private JComboBox cbType;
	
	private AdminFrame parentFrame;
	
	Client client= new Client();
	Account account = new Account();
	
	public NewClient(AdminFrame parentFrame, String title)
	{
		
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;

		JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        p5.setLayout(new FlowLayout());
        p6.setLayout(new FlowLayout());
        p7.setLayout(new FlowLayout());
        p8.setLayout(new FlowLayout());
		//line 1
		lbName = new JLabel("Client Name");
		txtName = new JTextField(20);
		txtName.addKeyListener(this);
		p1.add(lbName);
		p1.add(txtName);
		
		//line 2
		lbPass = new JLabel("Password");
		txtPass = new JTextField(20);
		txtPass.addKeyListener(this);
		p2.add(lbPass);
		p2.add(txtPass);
		
		//line 3
		lbBalanse = new JLabel("Balanse");
		txtBalanse = new JTextField(20);
		p3.add(lbBalanse);
		p3.add(txtBalanse);
		
		//line 4
		lbAdress = new JLabel("Adress     ");
		txtAdress = new JTextField(20);
		p4.add(lbAdress);
		p4.add(txtAdress);
		
		//line 5
		lbEmail = new JLabel("      Email      ");
		txtEmail = new JTextField(20);
		p5.add(lbEmail);
		p5.add(txtEmail);
		
		//line 6
		lbPhone = new JLabel("Phone      ");
		txtPhone = new JTextField(20);
		p6.add(lbPhone);
		p6.add(txtPhone);
		//line 7
		lbComment = new JLabel("Comment    ");
		txtComment = new JTextField(20);
		p7.add(lbComment);
		p7.add(txtComment);
		//line 8
		btnSubmit = new JButton("Save");
		btnSubmit.addActionListener(this);
		
//		cbType = new JComboBox(typeName);
//		p8.add(cbType);
//		
		p8.add(btnSubmit);
//		p8.add(new JLabel() );
		
		
		if(txtName.getText().equals(""))
		{
			btnSubmit.setVisible(false);
		}
		

		this.setLayout(new GridLayout(4,2));
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p7);
		this.add(p8);
		this.setVisible(true);
		this.setSize(650, 250);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			client.setPassword(txtPass.getText());
			client.setUsername(txtName.getText());
			//client.setType(String.valueOf(cbType.getSelectedItem()));
			client.setEmail(txtEmail.getText());
			client.setAddress(txtAdress.getText());
			client.setPhone(txtPhone.getText());
			client.setComment(txtComment.getText());
			if (0<Double.valueOf( txtBalanse.getText()) && Double.valueOf( txtBalanse.getText())<100)
			{
				client.setType("Regular");
			}
			if (100<Double.valueOf( txtBalanse.getText()) && Double.valueOf( txtBalanse.getText())<1000)
			{
				client.setType("Gold");
			}
			if (1000<Double.valueOf( txtBalanse.getText()))
			{
				client.setType("Platinum");
			}
			
			account=MBankST.getInstance().getAction().NewClient(client);
			JOptionPane.showMessageDialog(null, "New client created");
			
			account=MBankST.getInstance().getAction().getAccount(account.getClient_id());
			
			System.out.println(account.getClient_id());
			
			account.setBalance(Double.valueOf(txtBalanse.getText()));
			MBankST.getInstance().getAction().updateAccount(account);
					
			txtPass.setText("");
			txtName.setText("");
			txtBalanse.setText("");
			txtEmail.setText("");
			txtAdress.setText("");
			txtPhone.setText("");
			txtComment.setText("");
			
	}
	@Override
	public void keyPressed(KeyEvent e) {				
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			btnSubmit.setVisible(true);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
