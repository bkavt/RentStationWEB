package by.htp.salon.dao;

import java.util.List;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;

public interface UserDao  {
	
	 User fetchByCredentials(String login, String password);
	 List<User> getUserList();

}
