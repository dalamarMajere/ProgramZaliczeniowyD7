package application;

public class Faculty {

	private String id;
	private String name;

	public Faculty(String... information) {

		this(information[0], information[1]);
	}

	public Faculty(String id, String name){

		this.id=id;
		this.name=name;
	}

	@Override
	public String toString() {
		return id + ";" + name + ";";
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}
}
