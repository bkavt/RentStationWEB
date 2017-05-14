package by.htp.salon.service;

import java.sql.Date;

import by.htp.salon.dao.OrderDao;
import by.htp.salon.dao.OrderDaoImpl;
import by.htp.salon.entity.Equip;
import by.htp.salon.entity.Order;
import by.htp.salon.entity.User;

public class OrderServiceImpl implements OrderService{

	private OrderDao dao;
	public OrderServiceImpl(){
		dao=new OrderDaoImpl();
	}
	
	
	@Override
	public Order makeOrder(User user, Equip equip, Date start, Date End) {
		
		Order order = new Order();
		order.setUser(user);
		order.setEquipment(equip);
		order.setDateStart(start);
		order.setDataEnd(End);
		
		dao.createOrder(order);
///STUB!!!		
		return null;
	}

}
