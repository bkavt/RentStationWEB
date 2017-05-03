package by.htp.salon.domain.accessory;

public class ElbowPads extends Accessory{



	public ElbowPads() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElbowPads(String title, double cost, double size) {
		super(title, cost, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
			return "ElbowPads=" + size + "=" + title + "=" + cost + "=" + id;
	}

	
	
}
 