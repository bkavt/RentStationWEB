package by.htp.salon.domain.accessory;

import by.htp.salon.domain.Equipment;

public class Accessory extends Equipment {
	protected double size;
	
	


	
	public Accessory(String title, double cost, double size) {
		super(title, cost);
		this.size = size;
	}
	public Accessory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Accessory [size=" + size + ", title=" + title + ", cost=" + cost + ", id=" + id + "]";
	}
	
	
	


	
}
