package by.htp.salon.domain;


public class Client {
	private String name;
	private String soname;
	private String document;
	private int id;
	private static int num;
	
	{
		num++;
		id=num;
		//document="Pasport N:"+(1000000+num);
		
	}
	
	public Client(String name, String soname, String document) {
		super();
		this.name = name;
		this.soname = soname;
		this.document = document;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSoname() {
		return soname;
	}
	public void setSoname(String soname) {
		this.soname = soname;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Client [name=" + name + ", soname=" + soname + ", document=" + document + ", id=" + id + "]";
	}
	

		
}
