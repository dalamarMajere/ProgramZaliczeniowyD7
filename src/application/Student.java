package application;

import java.util.ArrayList;
/*
 * TODO FIGURE OUT GRADES HANDLING
 */

public class Student extends Person {

	private String faculty;
	private String course;
	private int semester;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();

	public Student(int personId, String surname, String name, String secondName, String birthDate,
			String faculty, String course, int semester) {

		super(personId, surname, name, secondName, birthDate);
		this.faculty = faculty;
		this.semester = semester;
		this.course = course;
	}

	/*
	 * called by dataAnalyzer, so information - String[], contains 7 elements:
	 * Id, surname, name, second name, birth date, faculty, course, semester
	 */
	public Student(String... inf) {

		this(Integer.parseInt(inf[0]), inf[1], inf[2], inf[3], inf[4], inf[5], inf[6], Integer.parseInt(inf[7]));
	}

	@Override
	public String toString() {
		return super.toString() + ";" + faculty + ";" + course + ";" + semester + ";";
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String unit) {
		this.faculty = unit;
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
}
