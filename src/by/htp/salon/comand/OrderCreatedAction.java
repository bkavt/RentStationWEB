package by.htp.salon.comand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;
import by.htp.salon.service.OrderService;
import by.htp.salon.service.OrderServiceImpl;
import static by.htp.salon.util.ConstantValue.*;

import java.sql.Date;
public class OrderCreatedAction implements CommandAction {

	private OrderService service;
	
	
	
	public OrderCreatedAction() {
		service = new OrderServiceImpl();
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_USER_MAIN;
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		String equipId = request.getParameter(REQUEST_PARAM_EQUIP_ID);
		String dataStart = request.getParameter(REQUEST_PARAM_DATA_START_ID);
		String dataEnd = request.getParameter(REQUEST_PARAM_DATA_END_ID);
		
		User user  = new User();
		user.setUserId(Long.valueOf(userId));
		Equip equip = new Equip();
		equip.setEuipId(Long.valueOf(equipId));
		
		Date start  = Date.valueOf(dataStart);
		Date end = Date.valueOf(dataEnd);
		
		service.makeOrder(user, equip, start, end);
		
		return page;
	}

}
