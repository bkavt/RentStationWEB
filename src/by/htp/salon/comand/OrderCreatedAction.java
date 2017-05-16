package by.htp.salon.comand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;
import by.htp.salon.service.EquipServiceImpl;
import by.htp.salon.service.EquipServise;
import by.htp.salon.service.OrderService;
import by.htp.salon.service.OrderServiceImpl;
import by.htp.salon.service.UserService;
import by.htp.salon.service.UserServiceImpl;

import static by.htp.salon.util.ConstantValue.*;

import java.sql.Date;
import java.util.List;
public class OrderCreatedAction implements CommandAction {

	private OrderService service;
	private UserService userService;
	private EquipServise equipService;
	
	
	public OrderCreatedAction() {
		service = new OrderServiceImpl();
		equipService = new EquipServiceImpl();
		userService = new UserServiceImpl();
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_ORDER_CREATE;
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		String equipId = request.getParameter(REQUEST_PARAM_EQUIP_ID);
		String dataStart = request.getParameter(REQUEST_PARAM_DATA_START_ID);
		String dataEnd = request.getParameter(REQUEST_PARAM_DATA_END_ID);
		
		if(!"".equals(dataStart)&&!"".equals(dataEnd)){
		User user  = new User();
		user.setUserId(Long.valueOf(userId));
		Equip equip = new Equip();
		equip.setEuipId(Long.valueOf(equipId));
		
		Date start  = Date.valueOf(dataStart);
		Date end = Date.valueOf(dataEnd);
		service.makeOrder(user, equip, start, end);
		}
		List<Equip> equipment = equipService.list();
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		List<User> user = userService.list();
		request.setAttribute(REQUEST_PARAM_LIST_USER, user);
		
		
		return page;
	}

}
