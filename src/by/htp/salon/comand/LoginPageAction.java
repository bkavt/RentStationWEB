package by.htp.salon.comand;

import static by.htp.salon.util.ConstantValue.*;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.salon.entity.Equip;
import by.htp.salon.service.EquipServiceImpl;
import by.htp.salon.service.EquipServise;

public class LoginPageAction implements CommandAction {
	private EquipServise equipService;

	public LoginPageAction() {
		equipService = new EquipServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		List<Equip> equipment = equipService.list();
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		return PAGE_LOGIN;
	}
}
