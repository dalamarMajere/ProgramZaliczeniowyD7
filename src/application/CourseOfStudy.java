package application;

public class CourseOfStudy {

	private String id;
	private String name;
	private String type;

	public CourseOfStudy(String... inf) {

		//		id, 	name
		this(inf[0], inf[1]);
	}

	public CourseOfStudy(String id, String name){

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

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		if(type=="zaoczny" || type=="dzienny"){
			this.type=type;
		}
	}


}
