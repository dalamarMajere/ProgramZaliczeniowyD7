package application;

import java.io.*;
import java.util.*;

public class dataAnalyzer {

	private static final String DataPerson = "../Data/Persons.txt";

	/**
	 * Read information about Person from file in the directory
	 * Data/Person.txt. Transformed all data to String[] and
	 * give it to Student's or Teacher's static method load
	 * @throws IOException
	 */
	public static void readDataPerson() throws IOException {
		Scanner in = new Scanner(new FileReader(DataPerson));

		String[] data;

		while (in.hasNextLine()) {
			data = in.nextLine().split(";");
			switch (data[data.length - 1]) {
				case "Student":
					System.out.println("Student");
					//Student.loadSudent(data);
					break;
				case "Teacher":
					System.out.println("Teacher");
					//Professor.loadProfessor(data);
					break;
			}
		}

		in.close();
	}

	// #TODO:   1. Letter L in the word "Wydzialy";
	//			2. How to find subject?
    //			3. Is it possible to short the way to write path?
	//			4. Add all these methods and fields to class Student
	public static void readDataSubject(Student student) {
		/*File file = new File("../Data/Wydzialy/"
				+ student.getFaculty() + "/"
				+ student.getStacjonarneCzyNie() + "/"
				+ student.getStopien() + "/"
				+ student.getRok());*/

		// reading data from file in folders
		// and calling to student.addSubject
	}

	public static void main(String[] args) throws IOException {
		//readDataPerson();
		Person p = new Person(1, "A", "A", "B", "01.01.2000");
		System.out.println(p.toString());
		Student s = new Student(p, "2019/2020", 6);
		System.out.println(s.toString());
	}
}
