package by.htp.salon.dao;

import java.sql.Date;
import java.util.List;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.Order;
import by.htp.salon.entity.User;

public interface OrderDao {
	
	//boolean createOrder(User user, Equip equipment, Date start, Date end);
	boolean createOrder(Order order);
	List<Order> fetchAll(); 
}
