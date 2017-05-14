package by.htp.salon.service;

import java.sql.Date;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.Order;
import by.htp.salon.entity.User;

public interface OrderService {
	
	public Order makeOrder(User user, Equip equip, Date start, Date End);

}
