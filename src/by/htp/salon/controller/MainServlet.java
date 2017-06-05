package by.htp.salon.controller;

import java.io.IOException;
import static by.htp.salon.util.ConstantValue.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.comand.CommandAction;
import by.htp.salon.comand.CommandChoser;
import by.htp.salon.dao.UserDao;
import by.htp.salon.dao.UserDaoImpl;

import static by.htp.salon.util.ConstantValue.*;

public class MainServlet extends HttpServlet {
    
	private static final long serialVersionUID = 2318321201221871240L;

	
    public MainServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
		System.out.println("doGet");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//processRequest(request, response);
		
//UserDao dao =new UserDaoImpl();
//		dao.fetchByCredentials("", "");
		processRequest(request, response);
		System.out.println("doPost");
		//System.out.println("comand  "+request.getParameter("action"));
	}
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		System.out.println("comand "+ action);
		String page=PAGE_ERROR;
		if (action!=null){
			CommandAction currentAction= CommandChoser.chooseAction(action);
			page= currentAction.execute(request, response);
			
			/*RequestDispatcher disp=request.getRequestDispatcher(page);
			disp.forward(request, response);*/
			System.out.println(page);
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(page);
			dispatcher.forward( request, response );
		}
	}
}
