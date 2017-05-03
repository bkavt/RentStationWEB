package by.htp.salon.domain.utils;

public class Rollers extends Units {
	private int size;

	public Rollers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rollers(String title, double cost, double weight, int size) {
		super(title, cost, weight);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Rollers=" + size + "=" + weight + "=" + title + "=" + cost + "=" + id;
	}


	
}
