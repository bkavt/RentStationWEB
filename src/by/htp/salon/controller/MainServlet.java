package by.htp.salon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.comand.CommandAction;
import by.htp.salon.comand.CommandChoser;


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
		processRequest(request, response);
		System.out.println("doPost");
	}
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		String page=null;
		if (action!=null){
			CommandAction currentAction= CommandChoser.chooseAction(action);
			page= currentAction.execute(request, response);
			
			RequestDispatcher disp=request.getRequestDispatcher(page);
			disp.forward(request, response);
			
		}
	}
}
