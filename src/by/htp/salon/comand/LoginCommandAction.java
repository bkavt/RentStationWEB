package by.htp.salon.comand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import by.htp.salon.entity.User;

public class LoginCommandAction implements CommandAction {


	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String page="";
		
		if ("user".equals(login) && "user".equals(password)){
			page="/user.jsp";
			List<User> users = new ArrayList<User>();
			users.add(new User("user1","user1",true));
			users.add(new User("user2","user2",true));
			users.add(new User("user3","user3",true));
			//request.setAttribute("list", users);
			
			
								
			request.setAttribute("list",users);
			
			
			
			//список оборудования
		}
		else if ("admin".equals(login) && "admin".equals(password)){
			page="/admin.jsp";
			List<User> users = new ArrayList<User>();
			users.add(new User("uswwwer1","user1",true));
			users.add(new User("uswwwer2","user2",true));
			users.add(new User("uswwwer3","user3",true));
			
			request.setAttribute("list", users);
			
			// отчет за день
		}
		else{
			page = "/error.jsp";
		}
		
		return page;
	}
	
}
