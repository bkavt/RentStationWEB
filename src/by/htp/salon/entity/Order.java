package by.htp.salon.entity;

import java.sql.Date;

public class Order {
	
	private Long orderId;
	private User user;
	private Equip equipment;
	
	private Date dateStart;
	private Date dataEnd;
	public Order(Long orderId, User user, Equip equipment, Date dateStart, Date dataEnd) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.equipment = equipment;
		this.dateStart = dateStart;
		this.dataEnd = dataEnd;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Equip getEquipment() {
		return equipment;
	}
	public void setEquipment(Equip equipment) {
		this.equipment = equipment;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDataEnd() {
		return dataEnd;
	}
	public void setDataEnd(Date dataEnd) {
		this.dataEnd = dataEnd;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", equipment=" + equipment + ", dateStart=" + dateStart
				+ ", dataEnd=" + dataEnd + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEnd == null) ? 0 : dataEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (dataEnd == null) {
			if (other.dataEnd != null)
				return false;
		} else if (!dataEnd.equals(other.dataEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	

	
}
