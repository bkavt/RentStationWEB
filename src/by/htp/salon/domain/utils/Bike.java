package by.htp.salon.domain.utils;

public class Bike extends Units{
	public String frameType;

	

	public Bike() {
		super();
	}

	public Bike(String title, double cost, double weight, String frameType) {
		super(title, cost, weight);
	}


	public String getFrameType() {
		return frameType;
	}

	public void setFrameType(String frameType) {
		this.frameType = frameType;
	}
	@Override
	public String toString() {
		return "Bike=" + frameType + "=" + weight + "=" + title + "=" + cost + "="+ id;
	}
	
	
}
