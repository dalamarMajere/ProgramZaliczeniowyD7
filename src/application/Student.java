package application;

import java.util.ArrayList;
/*
 * TODO FIGURE OUT GRADES HANDLING
 * TODO toString output format
 */

public class Student extends Person {

	private String yearOfStudy;
	private int semester;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();

	public Student(Person p, String yearOfStudy, int semester, ArrayList<Subject> subjects) {

		super(p.getPersonId(), p.getSurname(), p.getName(), p.getSecondName(), p.getBirthDate());
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
		this.subjects = subjects;
	}

public Student(Person p, String yearOfStudy, int semester) {

		this(p, yearOfStudy, semester, new ArrayList<>());
	}

	public Student(int personId, String surname, String name, String secondName, String birthDate,
					String yearOfStudy, int semester) {

		this(personId, surname, name, secondName, birthDate, yearOfStudy, semester, new ArrayList<>());
	}

	public Student(int personId, String surname, String name, String secondName, String birthDate,
					String yearOfStudy, int semester, ArrayList<Subject> subjects) {

			super(personId, surname, name, secondName, birthDate);
			this.yearOfStudy = yearOfStudy;
			this.semester = semester;
			this.subjects = subjects;

	}

	@Override
	public String toString() {
		return super.toString() + ";" + "Student#";
	}

	public String getYearOfStudy() {
		return this.yearOfStudy;
	}

	public void setYearOfStudy(String yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public int getSemester() {
		return this.semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
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
