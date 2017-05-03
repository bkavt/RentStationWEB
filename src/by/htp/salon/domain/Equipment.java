package by.htp.salon.domain;

public abstract class Equipment {
 
	protected String title;
	protected double cost;
	protected int id;
	private static int num;
	
	{
		num++;
		id=num;
		
	}
	public Equipment() {
			super();
			// TODO Auto-generated constructor stub
		}
	
	public Equipment(String title, double cost) {
		super();
		this.title = title;
		this.cost = cost;
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
		Equipment other = (Equipment) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Equipment [title=" + title + ", cost=" + cost + ", id=" + id + "]";
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 


}

