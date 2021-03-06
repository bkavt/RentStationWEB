package by.htp.salon.comand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;
import by.htp.salon.service.EquipServiceImpl;
import by.htp.salon.service.EquipServise;
import by.htp.salon.service.UserService;
import by.htp.salon.service.UserServiceImpl;

import static by.htp.salon.util.ConstantValue.*;

import java.util.List;


public class MakeOrderAction implements CommandAction{
	private UserService userService;
	private EquipServise equipService;
	
	public MakeOrderAction() {
		userService = new UserServiceImpl();
		equipService = new EquipServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Equip> equipment = equipService.list();
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		List<User> user = userService.list();
		request.setAttribute(REQUEST_PARAM_LIST_USER, user);
		
		
		
		return PAGE_ORDER_CREATE;
	}

}
