package application;

import java.io.*;
import java.util.*;

public class dataAnalyzer {

	private static Student splitStudentsInformation(String information) {

		return new Student(information.split(";"));
	}

	public static void rewrite(File file, int position, String text) throws IOException {

		System.out.println(position + " " + text);
		//read
		byte[] arr = new byte[(int)file.length()];
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.read(arr);

		//create string
		StringBuilder sb = new StringBuilder(new String(arr));
		System.out.println("BEFORE!" + sb.toString());
		sb.insert(position, text);
		System.out.println("AFTER!" + sb.toString());

		//rewrite file
		raf.seek(0);
		raf.write(sb.toString().getBytes());
		//add separator
		//raf.write(System.lineSeparator().getBytes());
		raf.close();
	}

	public static void loadStudent(File file, Student student) throws IOException {

		Scanner read = new Scanner(file);

		//offset
		int symbols = 0;
		Student currentStudent;
		String tmp;
		while (read.hasNextLine()) {

			tmp = read.nextLine();
			currentStudent = splitStudentsInformation(tmp);

			/*
			 * if student's surname (name, secondName) lex. greater than currentStudent's surname (name, sn)
			 * write student on a previous line before currentStudent
			 */
			if (student.compareTo(currentStudent) < 0) {
				rewrite(file, symbols + 1, student.toString());
				read.close();

				return;
			}
			//counts all passed symbols
			symbols += tmp.length();
		}
		//if this is a first student
		rewrite(file, (int)file.length(), student.toString());

		read.close();
	}
}
