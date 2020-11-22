package MBank.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;


public class MyThread extends Thread{
	
	@Override
		public void run() {
			//Deposit deposit=new Deposit();
			ArrayList<Deposit> array= new ArrayList<>();
			array=MBankST.getInstance().getAction().allDeposits();
			Date date=new Date();
			
			Account account=new Account();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			for(Deposit deposit:array){
				System.out.println("dateFormat.format(date)");//test
				if(dateFormat.format(date)==dateFormat.format(date=deposit.getClose_date())){
					
					Activity act= new Activity();
					account=MBankST.getInstance().getAction().getAccount(deposit.getClient_id());
					
					SysProperties sys=new SysProperties();
					sys=MBankST.getInstance().getAction().getSys();
					
					double sum=account.getBalance()+deposit.getBalance();
					account.setBalance(sum);
					
					MBankST.getInstance().getAction().updateAccount(account);
					MBankST.getInstance().getAction().deleteDeposit(deposit);

					act.setActivity_date(date);
					act.setClient_id(deposit.getClient_id());
					act.setCommission((sys.getCommision_rate()));
					act.setDescription("Deposit out of Time");
					act.setAmount(account.getBalance());
					
					MBankST.getInstance().getAction().setActivity(act);
				}
			}
			try {
				Thread.sleep(60*60*24);//test 24H
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
