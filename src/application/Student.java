package application;

import java.util.ArrayList;
/*
 * TODO FIGURE OUT GRADES HANDLING
 * TODO toString output format
 */

public class Student extends Person {

	private String yearOfStudy;
	private int semester;
	private boolean active;
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
		return super.toString() + ";" + "Student\n";
	}

	public String getYearOfStudy() {
		return this.yearOfStudy;
	}

	public boolean setYearOfStudy(String yearOfStudy) {
		if (checkYearOfStudy(yearOfStudy)) {
			this.yearOfStudy = yearOfStudy;
			return true;
		}
		return false;
	}

	private boolean checkYearOfStudy(String year) {

		//yyyy-yyyy => 8 symbols
		if (year.length() != 8) return false;
		for (int i = 0; i < 8; i++) {
			if (i != 4 && !Character.isDigit(year.charAt(i)))
				return false;
			else if (year.charAt(i) != '-')
					return false;
		}
		return true;
	}

	public int getSemester() {
		return this.semester;
	}

	// TODO: change 10 to variable (depends on degree course)
	public boolean setSemester(int semester) {
		if (semester > 0 && semester < 10) {
			this.semester = semester;
			return true;
		}
		return false;
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

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
