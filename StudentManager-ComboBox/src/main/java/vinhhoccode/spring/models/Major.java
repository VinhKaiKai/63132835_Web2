package vinhhoccode.spring.models;

public class Major {
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Major(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Major() {
		
	}
	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName()
				;
	}
	
	

}
