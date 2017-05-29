package by.htp.salon.comand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.htp.salon.util.ConstantValue.*;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;
import by.htp.salon.service.EquipServiceImpl;
import by.htp.salon.service.EquipServise;
import by.htp.salon.service.ServiceNoSuchUserException;
import by.htp.salon.service.UserService;
import by.htp.salon.service.UserServiceImpl;

public class LoginCommandAction implements CommandAction {
	private UserService userService;
	private EquipServise equipService;

	public LoginCommandAction() {
		userService = new UserServiceImpl();
		equipService = new EquipServiceImpl();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);
		String page = PAGE_ERROR;

		User user;
		try {
			user = userService.authotise(login, password);

			if (user.getRole()==1) {
				page = PAGE_USER_MAIN;
				List<Equip> equipment = equipService.list();
				request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);

				// request.setAttribute("list",users);

				// список оборудования
			} else if (user.getRole()==2) {
				page = PAGE_ADMIN_MAIN;
				
				// отчет за день
			}

		} catch (ServiceNoSuchUserException e) {
			page= PAGE_ERROR;
			request.setAttribute(REQUEST_PARAM_ERROR_MSG,e.getMessage());
			//e.printStackTrace();
		}
		
		return page;
	}

}
