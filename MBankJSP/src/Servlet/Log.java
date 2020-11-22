package Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.jasper.compiler.Node.ForwardAction;


import MBank.core.*;

@WebServlet("/Log.java")

public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Log() {
        super();
        //System.out.println("Test1");
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String pass=request.getParameter("pass");
		//System.out.println(request.getParameter("admin"));
		if((MBankST.getInstance().login(name, pass))!=null && request.getParameter("admin")==null){
			MBank.core.Client client=MBankST.getInstance().client;
			//request.removeAttribute("pass");
			HttpSession session=request.getSession();
			session.setAttribute("client", client);
			//System.out.println(request.getAttribute("admin"));
			
			request.getRequestDispatcher("/Controler").forward(request, response);
	}//else{System.out.println("@@@@@@@@@@@@@@ERROR:User name or password");response.sendRedirect("index.html");}
//		if((MBankST.getInstance().login(name, pass))!=null && request.getParameter("admin").endsWith("true")){
//			MBankST.getInstance().loginAdmin(name, pass);
//			request.getRequestDispatcher("/Controler").forward(request, response);
//		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}