package by.htp.salon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static by.htp.salon.util.ConstantValue.*;
import by.htp.salon.entity.Equip;

public class EquipDaoImpl implements EquipDao {
	ResourceBundle rb = ResourceBundle.getBundle("config");
	String dbUrl = rb.getString("db.url");
	String dbLog = rb.getString("db.login");
	String dbPass = rb.getString("db.pass");
	String dbDriver = rb.getString("db.driver");
	
	@Override
	public List<Equip> getFreeEquipList() {
		List<Equip> list = new ArrayList();
		try {
			try {
				Class.forName(dbDriver);

				Connection conn = DriverManager.getConnection(dbUrl, dbLog, dbPass);
				
				PreparedStatement ps = conn.prepareStatement(SQL_STATMENT_FREE_EQUIP_LIST);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					Long id = rs.getLong(1) ;
					String title = rs.getString(2);
					double price = rs.getDouble(3);
					Equip equip = new  Equip(id, title, price);
					list.add(equip);	
					
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
		return list;
	}

	@Override
	public boolean changeEquipStatus(Long equipId, int status) {

		try {
			try {
				Class.forName(dbDriver);

				Connection conn = DriverManager.getConnection(dbUrl, dbLog, dbPass);
				/*Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SQL_STATMENT_SELECT_USER);*/
				PreparedStatement ps = conn.prepareStatement(SQL_STATMENT_CHANGE_STATUS_EQUIP);
				
				ps.setInt(1, status);
				ps.setLong(2, equipId);
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
	public List<Equip> getRentEquipList() {
		List<Equip> list = new ArrayList();
		try {
			try {
				Class.forName(dbDriver);

				Connection conn = DriverManager.getConnection(dbUrl, dbLog, dbPass);
				
				PreparedStatement ps = conn.prepareStatement(SQL_STATMENT_RENT_EQUIP_LIST);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					Long id = rs.getLong(1) ;
					String title = rs.getString(2);
					double price = rs.getDouble(3);
					Equip equip = new  Equip(id, title, price);
					list.add(equip);	
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return list;
	}

}
