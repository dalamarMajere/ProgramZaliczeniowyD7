package application;

import java.util.ArrayList;

public class Teacher extends Person {

	String title;
	
	public Teacher(String... inf) {
		this(Integer.parseInt(inf[0]), inf[1], inf[2], inf[3], inf[4]);
	}
	
	public Teacher(int personId, String title, String surname, String name, String birthDate) {

		super(personId, surname, name, birthDate);
		this.title = title;
	}
	
	public String toString() {
		return super.toString() + ";" + title;
	}
}
