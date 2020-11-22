package MBank.core;


public class MBankST {
	private static MBankST bank;
	private ActionAdmin action;
	private ActionClient cAction;
	public Client client= new Client();
	private MBankST(){
		
		
	}//CTOR
	
	public static 	MBankST getInstance(){
		if ( bank == null ){
			bank = new MBankST();	
		}
		return bank;
	}

	public ActionAdmin loginAdmin(String user, String pass){
		ActionAdmin admin = new ActionAdmin();
		if (admin.login(user, pass))
		{
		    this.action = new ActionAdmin();
		    MyThread myThread=new MyThread();
		    myThread.start();
		}
		else return null;
		return (ActionAdmin) this.action;
	}
	public ActionClient login(String user, String pass){
		ActionClient aClient = new ActionClient();
		if (aClient.login(user, pass)!=null)
		{
			this.client =(Client)aClient.login(user, pass);
		    this.cAction = new ActionClient(this.client);
		}
		else return null;
		return (ActionClient) this.cAction;
	}

	public ActionAdmin getAction() {
		return action;
	}

	public void setActionAdmin(ActionAdmin action) {
		this.action = action;
	}
	public ActionClient getActionClient() {
		return cAction;
	}

	public void setActionClient(ActionClient cAction) {
		this.cAction = cAction;
	}
	public Client getMClient()
	{
		return this.client;
		
	}

}
