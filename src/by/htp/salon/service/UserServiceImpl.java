package by.htp.salon.service;

import java.util.List;

import by.htp.salon.dao.UserDao;
import by.htp.salon.dao.UserDaoImpl;
import by.htp.salon.entity.Equip;
import by.htp.salon.entity.User;

public class UserServiceImpl implements UserService {

private UserDao dao;

public  UserServiceImpl() {
	dao=new UserDaoImpl(); 
}
	@Override
	public User authotise(String login, String password) throws  ServiceNoSuchUserException{
		User user = dao.fetchByCredentials(login, password);
		if (user == null){
			throw new ServiceNoSuchUserException("Invalid credentials");
		}
		
		/*User user=null;
		if("user".equals(login)&&"user".equals(password))
		{
			user = new User ("user1","user1",false);
		}else if ("admin".equals(login)&&"admin".equals(password)){
			user = new User ("admin1","admin1",true);
		}else {
			throw new ServiceNoSuchUserException("Invalid credetials");
		}
		*/
		
		return user;
	}

	@Override
	public boolean logOut(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<User> list() {
		
		return dao.getUserList();
	}
	
	
	

}
