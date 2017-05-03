package by.htp.salon.domain;

import java.util.Arrays;

import by.htp.salon.domain.utils.Units;

public class OrderList {
	private Order[] order;
	private int size=10;
	private int index=0;
	
	
	{
		order=new Order[size];
	}
	
	public void newOrder(Equipment equip, Client client){
		Order ord=new Order();
		ord.setEquip(equip);
		ord.setClient(client);
		order[index]=ord;
		index++;
		if (index >= size) {
			size++;
			Order[]orderCopy = new Order[size];
			for (int i = 0; i < order.length; i++) {
				orderCopy[i] = order[i];
			}
			order = orderCopy;
		}
	}
	
	public int size(){
		int size=0;
		for (Order ord: order){
			if (ord!=null){
				size++;}
		}
		return size;
	}
	
	
	public Equipment[] findClienOrder(Client client){
		Equipment[] clientOrder=new Equipment[order.length];
		int i=0;
		for (Order ord: order){
			if (ord!=null&&client.equals(ord.getClient())){
				
				clientOrder[i]=ord.getEquip();
				i++;
			}
		}
		return clientOrder;
	}

	public int culcRentUnit(Client client){
		int i=0;
		for (Order ord: order){
			if (ord!=null&&ord.getEquip() instanceof Units&&client.equals(ord.getClient())){
				i++;
			}
		}
		return i;
	}
	
	
	
	public Order[] getOrder() {
		return order;
	}
	
	@Override
	public String toString() {
		return "OrderList [order=" + Arrays.toString(order) + "]";
	}
	
}
