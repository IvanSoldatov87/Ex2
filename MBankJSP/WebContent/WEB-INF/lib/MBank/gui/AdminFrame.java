package MBank.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminFrame extends JFrame implements ActionListener{
	private JDesktopPane desktop;
	
	private final String MENU_CMD_CLT_NEW = "New Client";
	private final String MENU_CMD_CLT_UPDATE = "Update Client";
	private final String MENU_CMD_CLT_DELETE = "Delete Client";
	
	private final String MENU_CMD_ACC_NEW = "Create new Account";
	private final String MENU_CMD_ACC_DELETE = "Delete Account";
	
	private final String MENU_CMD_CLT_VIEW = "Client Details Retrieve";
	private final String MENU_CMD_ALLCLT_VIEW = "All client Details Retrieve";
	private final String MENU_CMD_ACC_VIEW = "Account Details Retrieve";
	private final String MENU_CMD_ALLACC_VIEW = "All account Details Retrieve";
	
	private final String MENU_CMD_VIEW_DEP = "View client deposite";
	private final String MENU_CMD_VIEW_ALLDEP = "View all deposite";
	
	private final String MENU_CMD_VIEW_ACT = "View client activity";
	private final String MENU_CMD_VIEW_ALLACT = "View all activity";
	
	private final String MENU_CMD_VIEW_SYS = "View System property";
	private final String MENU_CMD_UP_SYS = "Update System property";
	
	
	private final String MENU_CMD_ABOUT="About this Application";
	private final String MENU_CMD_EXIT="Exit Application";
	private MBank.core.ActionAdmin action;
	
	public AdminFrame()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
			
		this.setDefaultLookAndFeelDecorated(true);
		
	
	
	desktop =new javax.swing.JDesktopPane()
	{
		ImageIcon icon = new ImageIcon("img/les.jpg");
		Image image = icon.getImage();
		Image newimage = image.getScaledInstance(600, 570, Image.SCALE_SMOOTH);
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(newimage, 70, 50, this);
		}
	};	
		this.getContentPane().add(desktop,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,700);
		this.setLocation(200,200);
		this.setTitle("Admin window");
		this.setJMenuBar(createMenuBar()); //< menu
		
		this.setVisible(true);
		LoginDialog login = new LoginDialog(this);
		login.setLocation(350,350);
		login.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();
		JInternalFrame iframe=null;
		if ( cmd.equals( MENU_CMD_CLT_NEW) ) {
			iframe = new NewClient(this,MENU_CMD_CLT_NEW);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_CLT_UPDATE) ) {
			iframe = new UpdateClient(this,MENU_CMD_CLT_UPDATE);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_CLT_DELETE) ) {
			iframe = new DeleteClient(this,MENU_CMD_CLT_DELETE);
			desktop.add(iframe);
			
		}
		if ( cmd.equals( MENU_CMD_ACC_NEW) ) {
			iframe = new NewAccount(this,MENU_CMD_ACC_NEW);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_ACC_DELETE) ) {
			iframe = new DeleteAccount(this,MENU_CMD_ACC_DELETE);
			desktop.add(iframe);
		}
		
		
		if ( cmd.equals( MENU_CMD_CLT_VIEW) ) {
			iframe = new ClientDetals(this,MENU_CMD_CLT_VIEW);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_ALLCLT_VIEW) ) {
			iframe = new AllClients(this,MENU_CMD_ALLCLT_VIEW);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_ACC_VIEW) ) {
			iframe = new AccountDetals(this,MENU_CMD_ACC_VIEW);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_ALLACC_VIEW) ) {
			iframe = new AllAccounts(this,MENU_CMD_ALLACC_VIEW);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_VIEW_DEP) ) {
			iframe = new ClientDeposit(this,MENU_CMD_VIEW_DEP);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_VIEW_ALLDEP) ) {
			iframe = new AllDeposits(this,MENU_CMD_VIEW_ALLDEP);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_VIEW_ACT) ) {
			iframe = new ClientActivity(this,MENU_CMD_VIEW_ACT);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_VIEW_ALLACT) ) {
			iframe = new AllActivity(this,MENU_CMD_VIEW_ACT);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_VIEW_SYS) ) {
			iframe = new ViewSys(this,MENU_CMD_VIEW_SYS);
			desktop.add(iframe);
		}
		if ( cmd.equals( MENU_CMD_UP_SYS) ) {
			iframe = new UpdateSys(this,MENU_CMD_UP_SYS);
			desktop.add(iframe);
		}
		
		
		if ( cmd.equals( MENU_CMD_ABOUT) ) {
			JOptionPane.showMessageDialog(this, "MBank Demo Appluication", "MBank Application", 1);
		}
		if ( cmd.equals( MENU_CMD_EXIT) ) {
			JOptionPane.showMessageDialog(this, "Leaving Application", "MBank Application", 1);
			System.exit(0);
		}
		
	}
//	public void dealogDelete()
//	{
//		JLabel lb = new JLabel("Enter client ID");
//		String s=JOptionPane.showInputDialog(lb);
//	}
	public JMenuBar createMenuBar()
	{
		JMenuBar bar =new JMenuBar();
		bar.add(client());
		bar.add(detals());
		bar.add(account());
		bar.add(deposit());
		bar.add(activity());
		bar.add(sys());
		bar.add(createMenuHelp());
		return bar;
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
	
	public JMenu client()
	{
		JMenu cmenu = new JMenu("Client");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_CLT_NEW);
		item1.addActionListener(this); 
		cmenu.add(item1);
		
		cmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_CLT_UPDATE);
		item1.addActionListener(this); 
		cmenu.add(item1);
		
		cmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_CLT_DELETE);
		item1.addActionListener(this); 
		cmenu.add(item1);

		return cmenu;
	}
	public JMenu detals()
	{
		JMenu amenu = new JMenu("Account");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_ACC_NEW);
		item1.addActionListener(this); 
		amenu.add(item1);
		
		amenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_ACC_DELETE);
		item1.addActionListener(this); 
		amenu.add(item1);

		return amenu;
	}
	public JMenu account()
	{
		JMenu dmenu = new JMenu("Detals");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_CLT_VIEW);
		item1.addActionListener(this); 
		dmenu.add(item1);
		
		dmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_ALLCLT_VIEW);
		item1.addActionListener(this); 
		dmenu.add(item1);
		
        dmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_ACC_VIEW);
		item1.addActionListener(this); 
		dmenu.add(item1);
		
		dmenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_ALLACC_VIEW);
		item1.addActionListener(this); 
		dmenu.add(item1);

		return dmenu;
	}
	public JMenu deposit()
	{
		JMenu demenu = new JMenu("Deposit");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_VIEW_DEP);
		item1.addActionListener(this); 
		demenu.add(item1);
		
		demenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_VIEW_ALLDEP);
		item1.addActionListener(this); 
		demenu.add(item1);

		return demenu;
	}
	public JMenu activity()
	{
		JMenu amenu = new JMenu("Activity");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_VIEW_ACT);
		item1.addActionListener(this); 
		amenu.add(item1);
		
		amenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_VIEW_ALLACT);
		item1.addActionListener(this); 
		amenu.add(item1);

		return amenu;
	}
	public JMenu sys()
	{
		JMenu amenu = new JMenu("System");
		
		JMenuItem item1=new JMenuItem(MENU_CMD_VIEW_SYS);
		item1.addActionListener(this); 
		amenu.add(item1);
		
		amenu.addSeparator();
		
		item1=new JMenuItem(MENU_CMD_UP_SYS);
		item1.addActionListener(this); 
		amenu.add(item1);

		return amenu;
	}
	
	public JDesktopPane getDesktop() {
		return desktop;
	}
	public MBank.core.ActionAdmin getAction() {
		return action;
	}
	public void setAction(MBank.core.ActionAdmin act)
	{
		action = act;
	}
	
	
	

}