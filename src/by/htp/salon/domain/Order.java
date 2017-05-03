package by.htp.salon.domain;

public class Order {
	private Equipment equip;
	private Client client;
	private int dataRent;
	private int  id;
	private static int num;
	
	{
		num++;
		id=num;
	}
	
	
	public Equipment getEquip() {
		return equip;
	}
	public void setEquip(Equipment equip) {
		this.equip = equip;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [equip=" + equip + ", client=" + client + ", dataRent=" + dataRent + ", id=" + id + "]";
	}
	 
	
}
