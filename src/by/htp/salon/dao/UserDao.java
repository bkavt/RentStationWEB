package by.htp.salon.dao;

import by.htp.salon.entity.User;

public interface UserDao  {
	
	 User fetchByCredentials(String login, String password);
	

}
