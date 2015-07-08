package emulationOrg;

//The class of functional responsibilities, as well as jobs that are performed using

public class Function {
	private int id;
	private String name;
	private int time; //Time task
	
	public Function(int id, String name, int time){
		this.id = id;
		this.name = name;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTime() {
		return time;
	}
}
