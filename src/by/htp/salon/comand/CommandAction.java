package by.htp.salon.comand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	public String execute (HttpServletRequest request, HttpServletResponse response);
}
