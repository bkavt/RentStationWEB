package by.htp.salon.service;

import java.util.List;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;

public interface UserService {

	User authotise(String login,String password) throws ServiceNoSuchUserException;
	boolean logOut(User user);
	List<User> list();
	
	
	
	
	
	
}
