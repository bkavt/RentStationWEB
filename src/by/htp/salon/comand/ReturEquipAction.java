package by.htp.salon.comand;

import static by.htp.salon.util.ConstantValue.*;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;
import by.htp.salon.service.EquipServiceImpl;
import by.htp.salon.service.EquipServise;
import by.htp.salon.service.OrderServiceImpl;

public class ReturEquipAction implements CommandAction {
private EquipServise equipService;
	
	
	public ReturEquipAction() {
		
		equipService = new EquipServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = PAGE_USER_MAIN;
		
		String equipId = request.getParameter(REQUEST_PARAM_EQUIP_ID);
		if(equipId!=null){
		equipService.changeEquipStatus(Long.valueOf(equipId), STATUS_FREE );}
		
		
		
		List<Equip> equipment = equipService.list();
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		
		return page;
		
	}

}
