package by.htp.salon.domain.utils;

import by.htp.salon.domain.Equipment;

public abstract class Units extends Equipment{
	protected  double weight;

	
	public Units() {
		super();
	}

	public Units(String title, double cost, double weight) {
		super(title, cost);
		this.weight = weight;
	
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Units [weight=" + weight + ", title=" + title + ", cost=" + cost + ", id=" + id + "]";
	}

	
	
	
}
