package by.htp.salon.domain.accessory;

public class Helmet extends Accessory {

	public Helmet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Helmet(String title, double cost, double size) {
		super(title, cost, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Helmet=" + size + "=" + title + "=" + cost + "=" + id;
	}

	
	
	
}
