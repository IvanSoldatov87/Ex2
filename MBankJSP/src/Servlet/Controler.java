package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import MBank.core.*;

@WebServlet("/Controler")
public class Controler extends HttpServlet {
	Client client;
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuRequest=new String();
		menuRequest=request.getParameter("m");
		client=(Client)request.getSession().getAttribute("client");
		
		if(menuRequest==null||menuRequest.equals("")||menuRequest.equals("6")){
			request.setAttribute("nextPage","Welcom.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}else if(menuRequest.equals("10")){	
			SysProperties sysp=MBankST.getInstance().getActionClient().getSysProperty();
			request.setAttribute("sysp",sysp);
			request.setAttribute("nextPage","ViewSys.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}else if(menuRequest.equals("9")){	
			request.setAttribute("nextPage","ViewClientActivity.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}else if(menuRequest.equals("8")){
			request.setAttribute("nextPage","ViewClientDeposit.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}else if(menuRequest.equals("7")){	
			request.setAttribute("nextPage","ViewAccountDetals.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);
		}else if(menuRequest.equals("5")){
			request.setAttribute("nextPage","PreOpenDeposit.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}else if(menuRequest.equals("4")){
			request.setAttribute("nextPage","CreateNewDeposit.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);
		}else if(menuRequest.equals("3")){	
			request.setAttribute("nextPage","DepositToAccount.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);
		}else if(menuRequest.equals("2")){
			request.setAttribute("nextPage","Withdraw.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}else if(menuRequest.equals("1")){
			request.setAttribute("nextPage","UpdateClient.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("newAddress")!=null&&request.getParameter("newName")!=null){
			client.setUsername(request.getParameter("newName"));
			client.setPassword(request.getParameter("newPass"));
			client.setAddress(request.getParameter("newAddress"));
			client.setPhone(request.getParameter("newPhone"));
			client.setEmail(request.getParameter("newEmail"));	
			MBankST.getInstance().getActionClient().updateClient(client);
			request.setAttribute("nextPage","Welcom.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}
		if(request.getParameter("withdraw")!=null){
			double mony=Double.valueOf(request.getParameter("withdraw"));
			Account account=MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
			MBankST.getInstance().getActionClient().withdrawAcc(mony, account);
			request.setAttribute("nextPage","Withdraw.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}
		if(request.getParameter("depositTo")!=null){
			Deposit mony=new Deposit();
			mony.setBalance(Double.valueOf(request.getParameter("depositTo")));
			Account account=MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
			try {
				MBankST.getInstance().getActionClient().depositToAccount(mony, account);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("nextPage","DepositToAccount.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}
		if(request.getParameter("deposit")!=null&&!request.getParameter("deposit").equals("")){
			Deposit deposit=new Deposit();
			Date op_date = new Date();
			Account account=MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
			Date clo_date = new Date();
			Calendar cal= Calendar.getInstance();
			cal.add(Calendar.YEAR, Integer.valueOf(request.getParameter("years")));
			cal.add(Calendar.MONTH, Integer.valueOf(request.getParameter("monus")));
			clo_date= cal.getTime();
			deposit.setBalance(Double.valueOf(request.getParameter("deposit")));
			deposit.setClient_id(client.getClient_id());
			deposit.setOpen_date(op_date);
			deposit.setClose_date(clo_date);
				try {
					MBankST.getInstance().getActionClient().withdrawAcc(deposit.getBalance(),account);
					MBankST.getInstance().getActionClient().newDeposit(deposit, account, client);
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			request.setAttribute("nextPage","ViewClientDeposit.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}
		if(request.getParameter("preOpen")!=null){
			Deposit preOpen=new Deposit();
			preOpen=MBankST.getInstance().getActionClient().clientDeposits(Long.valueOf(request.getParameter("preOpen")));
			//Account account=MBankST.getInstance().getActionClient().getAccount(client.getClient_id());
			try {
				MBankST.getInstance().getActionClient().pre_openDeposit(preOpen,(Client)request.getSession().getAttribute("client"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("nextPage","ViewClientDeposit.jsp");
			request.getRequestDispatcher("/Tem.jsp").forward(request, response);	
		}
	}
}
