package MBank.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import MBank.core.ActionClient;
import MBank.core.Client;
import MBank.core.MBankST;

//import com.jgoodies.looks.plastic.theme.*;

public class ClientFrame extends JFrame implements ActionListener{
	private JDesktopPane desktop;
	private final String MENU_CMD_CLT_UPDATE = "Update Client";
	private final String MENU_CMD_CLT_WITH = "Withdraw from account";
	private final String MENU_CMD_CLT_DEPOSIT = "Deposit to account";
	private final String MENU_CMD_NEW_DEPOSIT = "Create new deposit";
	private final String MENU_CMD_PRE_OPEN = "Pre-open deposit";
	
	private final String MENU_CMD_CLT_DETALS = "View client detals";
	private final String MENU_CMD_ACC_DETALS = "View account detals";
	private final String MENU_CMD_DEP_DETALS = "View client deposits";
	private final String MENU_CMD_ACT_DETALS = "View client activity";
	private final String MENU_CMD_SYS_DETALS = "View system property";
	
	private final String MENU_CMD_ABOUT="About this Application";
	private final String MENU_CMD_EXIT="Exit Application";
	private Client client;
	private ActionClient cAction;
	
	public ClientFrame()
	{
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			this.setDefaultLookAndFeelDecorated(true);
			
	
		
		desktop =new javax.swing.JDesktopPane()
		{
			ImageIcon icon = new ImageIcon("img/palmi.jpg");
			Image image = icon.getImage();
			Image newimage = image.getScaledInstance(750,650, Image.SCALE_SMOOTH);
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(newimage,0,0, this);
			}
		};	
		

		this.getContentPane().add(desktop,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,700);
		this.setLocation(200,200);
		this.setTitle("Client window");
		this.setJMenuBar(createMenuBar());
		
		this.setVisible(true);
		ClientLogin login = new ClientLogin(this);
		login.setLocation(350,350);
		login.setVisible(true);
		this.client=MBankST.getInstance().getMClient();
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();
		JInternalFrame iframe=null;
		if ( cmd.equals( MENU_CMD_CLT_UPDATE) ) {
			iframe = new UpdateClientClient(this,MENU_CMD_CLT_UPDATE,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_CLT_WITH) ) {
			iframe = new Withdraw(this,MENU_CMD_CLT_WITH,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_CLT_DEPOSIT) ) {
			iframe = new DepositToAccount(this,MENU_CMD_CLT_DEPOSIT,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_NEW_DEPOSIT) ) {
			iframe = new NewDeposit(this,MENU_CMD_NEW_DEPOSIT,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_PRE_OPEN) ) {
			iframe = new PreOpen(this,MENU_CMD_PRE_OPEN,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_CLT_DETALS) ) {
			iframe = new ClientViewClient(this,MENU_CMD_CLT_DETALS,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_ACC_DETALS) ) {
			iframe = new ClientViewAccount(this,MENU_CMD_ACC_DETALS,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_DEP_DETALS) ) {
			iframe = new ClientViewDeposit(this,MENU_CMD_DEP_DETALS,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_ACT_DETALS) ) {
			iframe = new ClientViewActivity(this,MENU_CMD_ACT_DETALS,client);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_SYS_DETALS) ) {
			iframe = new ClientViewSys(this,MENU_CMD_SYS_DETALS,client);
			desktop.add(iframe);
		}	
		if ( cmd.equals( MENU_CMD_ABOUT) ) {
			JOptionPane.showMessageDialog(this, "MBank version 13.4.14", "MBank Application", 1);
		}
		if ( cmd.equals( MENU_CMD_EXIT) ) {
			JOptionPane.showMessageDialog(this, "Leaving Application", "MBank Application", 1);
			System.exit(0);
		}
		
		
	}
	public JMenuBar createMenuBar()
	{
		JMenuBar bar =new JMenuBar();
		bar.add(client());
		bar.add(detals());
		bar.add(createMenuHelp());
		return bar;
	}
	public JMenu client()
	{
		JMenu cmenu = new JMenu("Client");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_CLT_UPDATE);
		item1.addActionListener(this); 
		cmenu.add(item1);
		
		cmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_CLT_WITH);
		item1.addActionListener(this); 
		cmenu.add(item1);
		
		cmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_CLT_DEPOSIT);
		item1.addActionListener(this); 
		cmenu.add(item1);
		
		cmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_NEW_DEPOSIT);
		item1.addActionListener(this); 
		cmenu.add(item1);
		
		cmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_PRE_OPEN);
		item1.addActionListener(this); 
		cmenu.add(item1);
		return cmenu;
		
	}
	public JMenu detals()
	{
		JMenu amenu = new JMenu("Detals");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_CLT_DETALS);
		item1.addActionListener(this); 
		amenu.add(item1);
		
		amenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_ACC_DETALS);
		item1.addActionListener(this); 
		amenu.add(item1);
		
		amenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_DEP_DETALS);
		item1.addActionListener(this); 
		amenu.add(item1);
		
		amenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_ACT_DETALS);
		item1.addActionListener(this); 
		amenu.add(item1);
		
		amenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_SYS_DETALS);
		item1.addActionListener(this); 
		amenu.add(item1);

		return amenu;
	}
	public JMenu createMenuHelp()
	{
		JMenu mmenu = new JMenu("Help");
		JMenuItem item1=new JMenuItem(MENU_CMD_ABOUT);
		item1.addActionListener(this); 
		mmenu.add(item1);
		mmenu.addSeparator();
		item1 = new JMenuItem(MENU_CMD_EXIT);
		item1.addActionListener(this);
		mmenu.add(item1);
		return mmenu;
	}
	public JDesktopPane getDesktopClient() {
		return desktop;
	}
	public MBank.core.ActionClient getActionClient() {
		return cAction;
	}
	public void setActionClient(MBank.core.ActionClient act)
	{
		cAction = act;
	}

}
