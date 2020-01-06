package application;

import java.util.ArrayList;
/*
 * TODO FIGURE OUT GRADES HANDLING
 * TODO toString output format
 */

public class Student extends Person implements Comparable<Student> {

	private String unit;
	private int semester;
	private boolean active;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();

	public Student(int personId, String surname, String name, String secondName, String birthDate,
					String unit, int semester, ArrayList<Subject> subjects) {

			super(personId, surname, name, secondName, birthDate);
			this.unit = unit;
			this.semester = semester;
			this.subjects = subjects;

	}

	public Student(int personId, String surname, String name, String secondName, String birthDate,
			String unit, int semester) {

		this(personId, surname, name, secondName, birthDate, unit, semester, new ArrayList<>());
	}

	/*
	 * called by dataAnalyzer, so information - String[], contains 7 elements:
	 * Id, surname, name, second name, birth date, unit, semester
	 */
	public Student(String... inf) {

		this(Integer.parseInt(inf[0]), inf[1], inf[2], inf[3], inf[4], inf[5], Integer.parseInt(inf[6]));
	}

	@Override
	/**
	 * Compares two students lexicographically. This comparison is based on the comparations:
	 * surname (string), name (string), secondName(string)
	 * The result is zero if these fileds are equal; if first student < second student, compareTo returns -1.
	 */
	public int compareTo(Student other) {

		if (getSurname().compareTo(other.getSurname()) < 0 ||
			(getSurname().compareTo(other.getSurname()) == 0 && (getName().compareTo(other.getName()) < 0 ||
			(getName().compareTo(other.getName()) == 0 && getSecondName().compareTo(other.getSecondName()) < 0))))
			return -1;
		if (getSurname().compareTo(other.getSurname()) > 0 ||
			(getSurname().compareTo(other.getSurname()) == 0 && (getName().compareTo(other.getName()) > 0 ||
			(getName().compareTo(other.getName()) == 0 && getSecondName().compareTo(other.getSecondName()) > 0))))
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + unit + ";" + semester + ";";
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
