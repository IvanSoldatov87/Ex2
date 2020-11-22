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

import MBank.core.MBankST;

public class DeleteAccount extends JInternalFrame implements ActionListener{
	private JButton ok;
	private JButton cencel;
	
	private JLabel lb;
	private JTextField txtid;
	private AdminFrame parentFrame;
	public DeleteAccount(AdminFrame parentFrame,String title)
	{
		super(title,true, true, true, true);	
		this.parentFrame = parentFrame;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(new FlowLayout());
		    lb = new JLabel("Enter client ID");
			txtid = new JTextField(20);
			p1.add(lb);
			p1.add(txtid);
		p2.setLayout(new FlowLayout());
			ok= new JButton("OK");
			ok.addActionListener(this);
			cencel=new JButton("Cancel");
			cencel.addActionListener(this);
			p2.add(ok);
			p2.add(cencel);
		this.setLayout(new GridLayout(5,1));
		this.add(p1);
		this.add(p2);
		this.setSize(400,200);
		this.setVisible(true);
		 
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("OK"))
		{
			int client_id = Integer.parseInt(txtid.getText());
			MBankST.getInstance().getAction().removeAccount(client_id);
		}
	}

}
