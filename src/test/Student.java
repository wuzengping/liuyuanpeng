package test;

public class Student {

	private int id;
	private String name;
	private  int stuid;
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
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public Student(int id, String name, int stuid) {
		super();
		this.id = id;
		this.name = name;
		this.stuid = stuid;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
