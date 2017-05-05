package by.htp.salon.service;

import by.htp.salon.entity.User;

public interface UserService {

	User authotise(String login,String password) throws ServiceNoSuchUserException;
	boolean logOut(User user);
	
	
	
	
	
}
