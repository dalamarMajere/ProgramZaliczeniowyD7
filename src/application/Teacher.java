package application;

import java.util.ArrayList;

public class Teacher extends Person {

	private ArrayList<Subject> subjects;

	public Teacher(int personId, String surname, String name, String secondName, String birthDate, ArrayList<Subject> subjects) {

		super(personId, surname, name, secondName, birthDate);

		this.subjects = subjects;
	}

	public ArrayList<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
}
