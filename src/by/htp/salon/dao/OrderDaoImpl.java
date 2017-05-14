package by.htp.salon.dao;


import static by.htp.salon.util.ConstantValue.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.salon.entity.Order;
import by.htp.salon.entity.User;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean createOrder(Order order) {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl = rb.getString("db.url");
		String dbLog = rb.getString("db.login");
		String dbPass = rb.getString("db.pass");
		String dbDriver = rb.getString("db.driver");
		//User user = new User();
		try {
			try {
				Class.forName(dbDriver);

				Connection conn = DriverManager.getConnection(dbUrl, dbLog, dbPass);
				/*Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SQL_STATMENT_SELECT_USER);*/
				PreparedStatement ps = conn.prepareStatement(SQL_STATMENT_ORDER_GREATE, PreparedStatement.RETURN_GENERATED_KEYS);
				//ps.setString(1, login);
				//ps.setString(2, password);
				ps.setLong(1, order.getUser().getUserId());
				ps.setLong(2, order.getEquipment().getEuipId());
				ps.setDate(3, order.getDateStart());
				ps.setDate(4, order.getDataEnd());
				
				ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Order> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
