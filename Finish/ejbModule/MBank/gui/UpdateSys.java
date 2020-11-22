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
import MBank.core.SysProperties;

public class UpdateSys extends JInternalFrame implements ActionListener{
	private JButton btSave;
	
	private JLabel lbRD_rate;
	private JLabel lbGD_rate;
	private JLabel lbPD_rate;
	private JLabel lbRD_commission;
	private JLabel lbGD_commission;
	private JLabel lbPD_commission;
	private JLabel lbRD_limit;
	private JLabel lbGD_limit;
	private JLabel lbPD_limit;
	private JLabel lbComm_rate;
	private JLabel lbRD_interest;
	private JLabel lbGD_interest;
	private JLabel lbPD_interest;
	private JLabel lbP_open;
	private JLabel lbA_username;
	private JLabel lbA_password;
	
	
	private JTextField txtRD_rate;
	private JTextField txtGD_rate;
	private JTextField txtPD_rate;
	private JTextField txtRD_commission;
	private JTextField txtGD_commission;
	private JTextField txtPD_commission;
	private JTextField txtRD_limit;
	private JTextField txtGD_limit;
	private JTextField txtPD_limit;
	private JTextField txtComm_rate;
	private JTextField txtRD_interest;
	private JTextField txtGD_interest;
	private JTextField txtPD_interest;
	private JTextField txtP_open;
	private JTextField txtA_username;
	private JTextField txtA_password;
	
	private AdminFrame parentFrame;
	
	SysProperties sys=new SysProperties();
	
	public UpdateSys(AdminFrame parentFrame, String title)
	{
		super(title, true, true, true, true);
		this.parentFrame = parentFrame;
		
		JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();

        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        p5.setLayout(new FlowLayout());
        p6.setLayout(new FlowLayout());

        //line1
        lbRD_rate = new JLabel("Regular deposit rate");
        txtRD_rate = new JTextField(10);
        lbGD_rate = new JLabel("Gold deposit rate");
        txtGD_rate = new JTextField(10);
        lbPD_rate = new JLabel("Platinum deposit rate");
        txtPD_rate = new JTextField(10);
        p1.add(lbRD_rate);
		p1.add(txtRD_rate);
		p1.add(lbGD_rate);
		p1.add(txtGD_rate);
		p1.add(lbPD_rate);
		p1.add(txtPD_rate);
		//line2
		lbRD_commission = new JLabel("Regular deposit commission");
        txtRD_commission = new JTextField(10);
        lbGD_commission = new JLabel("Gpld deposit commission");
        txtGD_commission = new JTextField(10);
        lbPD_commission = new JLabel("Platinum deposit commission");
        txtPD_commission = new JTextField(10);
        p2.add(lbRD_commission);
		p2.add(txtRD_commission);
		p2.add(lbGD_commission);
		p2.add(txtGD_commission);
		p2.add(lbPD_commission);
		p2.add(txtPD_commission);
		//line3
		lbRD_limit = new JLabel("Regular cedit limit");
        txtRD_limit = new JTextField(10);
        lbGD_limit = new JLabel("Regular credit limit");
        txtGD_limit = new JTextField(10);
        lbPD_limit = new JLabel("Regular credit limit");
        txtPD_limit = new JTextField(10);
        p3.add(lbRD_limit);
		p3.add(txtRD_limit);
		p3.add(lbGD_limit);
		p3.add(txtGD_limit);
		p3.add(lbPD_limit);
		p3.add(txtPD_limit);
		//line4
		lbRD_interest = new JLabel("Regular deposit interest");
        txtRD_interest = new JTextField(10);
        lbGD_interest = new JLabel("Regular deposit interest");
        txtGD_interest = new JTextField(10);
        lbPD_interest = new JLabel("Regular deposit interest");
        txtPD_interest = new JTextField(10);
        p4.add(lbRD_interest);
		p4.add(txtRD_interest);
		p4.add(lbGD_interest);
		p4.add(txtGD_interest);
		p4.add(lbPD_interest);
		p4.add(txtPD_interest);
		//line5
		lbComm_rate = new JLabel("Commision rate");
		txtComm_rate = new JTextField(10);
		lbP_open = new JLabel("Pre open free");
		txtP_open = new JTextField(10);
		p5.add(lbComm_rate);
		p5.add(txtComm_rate);
		p5.add(lbP_open);
		p5.add(txtP_open);
		//line6
		lbA_username = new JLabel("Admin username");
		txtA_username = new JTextField(10);
		lbA_password = new JLabel("Admin password");
		txtA_password = new JTextField(10);
		p6.add(lbA_username);
		p6.add(txtA_username);
		p6.add(lbA_password);
		p6.add(txtA_password);
		//button line
		JPanel bp = new JPanel();
		bp.setLayout(new FlowLayout());
		JButton button = new JButton("Save");
		button.addActionListener(this);
		bp.add(button);
		
		
		this.setLayout(new GridLayout(7,2));
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(bp);
		this.setVisible(true);
		this.setSize(660, 300);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		sys.setRegular_deposit_rate(Integer.parseInt(txtRD_rate.getText()));
		sys.setGold_deposit_rate(Integer.parseInt(txtGD_rate.getText()));
		sys.setPlatinum_deposit_rate(Integer.parseInt(txtPD_rate.getText()));
		sys.setRegular_deposit_commission(Double.parseDouble(txtRD_commission.getText()));
		sys.setGold_deposit_commission(Double.parseDouble(txtGD_commission.getText()));
		sys.setPlatinum_deposit_commission(Double.parseDouble(txtPD_commission.getText()));
		sys.setRegular_credit_limit(Integer.parseInt(txtRD_limit.getText()));
		sys.setGold_credit_limit(Integer.parseInt(txtGD_limit.getText()));
		sys.setPlatinum_credit_limit(Integer.parseInt(txtPD_limit.getText()));
		sys.setRegular_daily_interest(txtRD_interest.getText());
		sys.setGold_daily_interest(txtGD_interest.getText());
		sys.setPlatinum_daily_interest(txtPD_interest.getText());
		sys.setCommision_rate(Double.parseDouble(txtComm_rate.getText()));
		sys.setPre_open_free(Double.parseDouble(txtP_open.getText()));
		sys.setAdminUsername(txtA_username.getText());
		sys.setAdminPassword(txtA_password.getText());
		MBankST.getInstance().getAction().updateSysProperty(sys);
		
		
	}
	
	
	
}
