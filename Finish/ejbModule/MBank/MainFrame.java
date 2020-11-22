//package MBank;
//
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//import MBank.gui.AllClients;
//import MBank.gui.ClientFrame;
//import MBank.gui.DeleteClient;
//import MBank.gui.LoginDialog;
//import MBank.gui.UpdateClient;
//
//
//public class MainFrame extends JFrame implements ActionListener{
//	private JDesktopPane desktop;
//	private JPanel jp;
//	private final String MENU_CMD_CLT_NEW = "New Client";
//	private final String MENU_CMD_CLT_DELETE = "Delete Client";
//	private final String MENU_CMD_CLT_UPDATE = "Update Client";
//	private final String MENU_CMD_CLT_GET = "Client Details Retrieve";
//	private final String MENU_CMD_ABOUT="About this Application";
//	private final String MENU_CMD_EXIT="Exit Application";
//	private MBank.core.ActionAdmin action;
//	
//	public MainFrame()
//	{
//		desktop =new JDesktopPane();
//		JPanel jp;
//		this.getContentPane().add(desktop,BorderLayout.CENTER);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(750,700);
//		this.setLocation(200,200);
//		this.setTitle("Main window");
//		this.setJMenuBar(createMenuBar()); //< menu
//		
//		this.setVisible(true);
//		LoginDialog login = new LoginDialog(this);
//		login.setLocation(350,350);
//		login.setVisible(true);
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String cmd=e.getActionCommand();
//		JInternalFrame iframe=null;
//		if ( cmd.equals( MENU_CMD_CLT_NEW) ) {
//			iframe = new ClientFrame(this,MENU_CMD_CLT_NEW);
//			desktop.add(iframe);
//		}
//		if ( cmd.equals( MENU_CMD_CLT_UPDATE) ) {
//			iframe = new UpdateClient(this,MENU_CMD_CLT_UPDATE);
//			desktop.add(iframe);
//		}
//		if ( cmd.equals( MENU_CMD_CLT_DELETE) ) {
//			iframe = new DeleteClient(this,MENU_CMD_CLT_DELETE);
//			desktop.add(iframe);
//			
//		}
//		if ( cmd.equals( MENU_CMD_CLT_GET) ) {
//			AllClients all =new AllClients(this,MENU_CMD_CLT_GET);
//			desktop.add(all);
//		}
//		if ( cmd.equals( MENU_CMD_ABOUT) ) {
//			JOptionPane.showMessageDialog(this, "MBank Demo Appluication", "MBank Application", 1);
//		}
//		if ( cmd.equals( MENU_CMD_EXIT) ) {
//			JOptionPane.showMessageDialog(this, "Leaving Application", "MBank Application", 1);
//			System.exit(0);
//		}
//		
//	}
//	public void dealogDelete()
//	{
//		JLabel lb = new JLabel("Enter client ID");
//		String s=JOptionPane.showInputDialog(lb);
//	}
//	public JMenuBar createMenuBar()
//	{
//		JMenuBar bar =new JMenuBar();
//		bar.add(createMenuMain());
//		bar.add(createClient());
//		return bar;
//	}
//	public JMenu createMenuMain()
//	{
//		JMenu mmenu = new JMenu("Main");
//		
//		JMenuItem item1=new JMenuItem(MENU_CMD_ABOUT);
//		item1.addActionListener(this); 
//		mmenu.add(item1);
//		mmenu.addSeparator();
//		item1 = new JMenuItem(MENU_CMD_EXIT);
//		item1.addActionListener(this);
//		mmenu.add(item1);
//		return mmenu;
//	}
//	
//	public JMenu createClient()
//	{
//		JMenu cmenu = new JMenu("Claent");
//		
//		JMenuItem item1=new JMenuItem(MENU_CMD_CLT_NEW);
//		item1.addActionListener(this); 
//		cmenu.add(item1);
//		
//		cmenu.addSeparator();
//		
//		item1=new JMenuItem(MENU_CMD_CLT_UPDATE);
//		item1.addActionListener(this); 
//		cmenu.add(item1);
//		
//		cmenu.addSeparator();
//		
//		item1=new JMenuItem(MENU_CMD_CLT_DELETE);
//		item1.addActionListener(this); 
//		cmenu.add(item1);
//		
//		cmenu.addSeparator();
//		
//		item1 = new JMenuItem(MENU_CMD_CLT_GET);
//		item1.addActionListener(this);
//		cmenu.add(item1);
//		return cmenu;
//	}
//	
//	public JDesktopPane getDesktop() {
//		return desktop;
//	}
//	public MBank.core.ActionAdmin getAction() {
//		return action;
//	}
//	public void setAction(MBank.core.ActionAdmin act)
//	{
//		action = act;
//	}
//	
//	
//	
//
//}
