package by.htp.salon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import static by.htp.salon.util.ConstantValue.*;
import by.htp.salon.entity.User;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User fetchByCredentials(String login, String password) {

		ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl = rb.getString("db.url");
		String dbLog = rb.getString("db.login");
		String dbPass = rb.getString("db.pass");
		String dbDriver = rb.getString("db.driver");
		User user = new User();
		try {
			try {
				Class.forName(dbDriver);

				Connection conn = DriverManager.getConnection(dbUrl, dbLog, dbPass);
				/*Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SQL_STATMENT_SELECT_USER);*/
				PreparedStatement ps = conn.prepareStatement(SQL_STATMENT_SELECT_USER);
				ps.setString(1, login);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					String log = rs.getString(2);
					String pass = rs.getString(3);
					boolean role = rs.getBoolean(5);
					
						
					user.setLogin(log);
					user.setPassword(pass);
					user.setRole(role);
				}
				/*while (rs.next()) {
					String log = rs.getString(2);
					String pass = rs.getString(3);

					System.out.println(log + " " + pass);
				}*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
