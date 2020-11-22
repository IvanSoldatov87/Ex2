package MBank.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MBank.core.ActionClient;
import MBank.core.Client;
import MBank.core.MBankST;

public class ClientLogin extends JDialog implements ActionListener{
	ClientFrame parent;
	JTextField usr;
	JTextField pss;
	Client client;
	
	public ClientLogin(JFrame parent)
	{
		super(parent,"Login", true);
		this.parent=(ClientFrame)parent;
		JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p1.add(new JLabel("user name:"));
        p1.add((usr = new JTextField(12) ) );
	    p2.add(new JLabel("password:"));
	    p2.add((pss = new JTextField(12) ) );
	    JButton ok = new JButton("Ok");
	    p3.add(ok);
	    this.getContentPane().add(p1, BorderLayout.NORTH);
	    this.getContentPane().add(p2, BorderLayout.CENTER);
	    this.getContentPane().add(p3, BorderLayout.SOUTH);
	    ok.addActionListener(this);
	    addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	        	handleCloseOperation();
	        }});
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    setSize(250, 150);
	    setLocation(250,200);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ActionClient act = MBankST.getInstance().login(usr.getText(), pss.getText());	
    	if (act == null){
    		JOptionPane.showMessageDialog(this, "Wrong user name or password");
    		return;
        }
    	parent.setActionClient(act);
        setVisible(false);
		
	}
	public Client getClient()
	{
		return this.client;
	}
	private void handleCloseOperation()
	{
		if(JOptionPane.showConfirmDialog(null, "Click Ok to Leave application", "MBank Login", 
	    		  JOptionPane.OK_CANCEL_OPTION) == 0 ) {
	    	   JOptionPane.showMessageDialog(null, "Leaving Application", "MBank Login", 1);
	    	   System.exit(0);
	    	 }
	    	 else {
	    		   JOptionPane.showMessageDialog(null, "Please Login..","MBank Login", 1);
	    	 }
	}

}
