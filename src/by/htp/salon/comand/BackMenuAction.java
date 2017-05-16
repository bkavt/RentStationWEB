package by.htp.salon.comand;

import static by.htp.salon.util.ConstantValue.PAGE_USER_MAIN;
import static by.htp.salon.util.ConstantValue.REQUEST_PARAM_DATA_END_ID;
import static by.htp.salon.util.ConstantValue.REQUEST_PARAM_DATA_START_ID;
import static by.htp.salon.util.ConstantValue.REQUEST_PARAM_EQUIP_ID;
import static by.htp.salon.util.ConstantValue.REQUEST_PARAM_LIST_EQ;
import static by.htp.salon.util.ConstantValue.REQUEST_PARAM_USER_ID;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;
import by.htp.salon.service.EquipServiceImpl;
import by.htp.salon.service.EquipServise;
import by.htp.salon.service.OrderService;
import by.htp.salon.service.OrderServiceImpl;
import by.htp.salon.service.UserService;

public class BackMenuAction implements CommandAction {



	private EquipServise equipService;
	
	
	public BackMenuAction() {
	
		equipService = new EquipServiceImpl();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		List<Equip> equipment = equipService.list();
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		return PAGE_USER_MAIN;
	}

}
