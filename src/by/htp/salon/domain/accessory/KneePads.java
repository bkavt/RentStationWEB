package by.htp.salon.domain.accessory;

public class KneePads extends Accessory {

	public KneePads() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KneePads(String title, double cost, double size) {
		super(title, cost, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KneePads=" + size + "=" + title + "=" + cost + "=" + id;
	}

	


}
