package MBank.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MBank.core.Account;
import MBank.core.ActionClient;
import MBank.core.Activity;
import MBank.core.ActivityDBMeneger;
import MBank.core.Client;
import MBank.core.MBankST;

public class UpdateClientClient extends JInternalFrame implements ActionListener{
	private JButton btSave;
	
	private JLabel lbID;
	private JLabel lbName;
	private JLabel lbType;
	private JLabel lbEmail;
	private JLabel lbPass;
	private JLabel lbAdress;
	private JLabel lbPhone;
	private JLabel lbComment;
	
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtType;
	private JTextField txtEmail;
	private JTextField txtPass;
	private JTextField txtAdress;
	private JTextField txtPhone;
	private JTextField txtComment;
	
	private ClientFrame parentFrame;
	
	Client client= new Client();
	Account account =new Account();
	
	
	public UpdateClientClient(ClientFrame parentFrame,String title,Client client)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		JPanel idp = new JPanel();
		idp.setLayout(new FlowLayout());
		this.client=client;
		
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
        
		lbName = new JLabel("Client Name");
		txtName = new JTextField(20);
		txtName.setText(String.valueOf(client.getClient_id()));
		p1.add(lbName);
		p1.add(txtName);
		//line 2
		lbPass = new JLabel("Password");
		txtPass = new JTextField(20);
		txtPass.setText(client.getPassword());
		p2.add(lbPass);
		p2.add(txtPass);
		//line 3
		lbType = new JLabel("Client Type  ");
		txtType = new JTextField(20);
		txtType.setText(client.getType());
		p3.add(lbType);
		p3.add(txtType);
		
		//line 4
		lbAdress = new JLabel("Adress     ");
		txtAdress = new JTextField(20);
		txtAdress.setText(client.getAddress());
		p4.add(lbAdress);
		p4.add(txtAdress);
		
		//line 5
		lbEmail = new JLabel("      Email      ");
		txtEmail = new JTextField(20);
		txtEmail.setText(client.getEmail());
		p5.add(lbEmail);
		p5.add(txtEmail);
		
		//line 6
		lbPhone = new JLabel("Phone      ");
		txtPhone = new JTextField(20);
		txtPhone.setText(client.getPhone());
		p6.add(lbPhone);
		p6.add(txtPhone);
		//line 7
		lbComment = new JLabel("Comment    ");
		txtComment = new JTextField(20);
		txtComment.setText(client.getComment());
		p7.add(lbComment);
		p7.add(txtComment);
		//line 8
		btSave = new JButton("Save");
		btSave.addActionListener(this);
		p8.add(btSave);
		p8.add(new JLabel() );
        

        this.setLayout(new GridLayout(5,2));
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		//this.add(p7);
		this.add(p8);
		this.setVisible(true);
		this.setSize(650, 250);
 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//client.setPassword(txtPass.getText());
		//client.setUsername(txtName.getText());
		//client.setType(txtType.getText());
		client.setEmail(txtEmail.getText());
		client.setAddress(txtAdress.getText());
		client.setPhone(txtPhone.getText());
		//client.setComment(txtComment.getText());
		//client.setClient_id(Integer.parseInt(txtID.getText()));
		MBankST.getInstance().getActionClient().updateClient(client);
		Activity act = new Activity();
		act.setClient_id(client.getClient_id());
		act.setActivity_date(Calendar.getInstance().getTime());
		act.setDescription(super.getTitle());
		MBankST.getInstance().getActionClient().setActivity(act);
		
	}
}
