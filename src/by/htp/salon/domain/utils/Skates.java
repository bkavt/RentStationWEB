package by.htp.salon.domain.utils;

public class Skates extends Units {
	private int size;


	public Skates() {
		super();
	}

	public Skates(String title, double cost, double weight, int size) {
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
		return "Skates=" + size + "=" + weight + "=" + title + "=" + cost + "=" + id
				+ "]";
	}

	private static final String ID = "id";
	
	
}
