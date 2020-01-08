package application;

import java.io.*;
import java.util.*;

public class dataAnalyzer {

	 public static String readFile(File file) throws IOException{
		RandomAccessFile raf= new RandomAccessFile(file,"rw");
		byte output[] = new byte[(int) file.length()];
		raf.read(output);
		return new String(output);
	 }

	public static void loadFaculty(File file, String[] toWrite) throws IOException {

		Scanner read = new Scanner(file);

		StringBuilder sb = new StringBuilder();
		String tmp;
		boolean write = false;

		while (read.hasNextLine()) {

			tmp = read.nextLine();
			if (!write)
				if (toWrite[1].compareTo(tmp.split(";")[1]) < 0)
				{
					write = true;
					appendToSB(sb, toWrite[0] + ";" + toWrite[1] + ";");
				}
			appendToSB(sb, tmp);
		}
		//if this is a first object
		if (!write)
			appendToSB(sb, toWrite[0] + ";" + toWrite[1] + ";");
		rewrite(file, sb.toString());

		read.close();
	}

	public static String filterFile(File file, String criterium) throws IOException{

		StringBuilder sb = new StringBuilder();
		String textOutput = readFile(file);
		String objects[] = textOutput.split( "\r\n" );

		for(int i = 0 ; i < objects.length ; i++){
			if( objects[i].contains( criterium )){
				appendToSB( sb , objects[i] );
			}
		}

		return sb.toString();

	}

	public static void loadObject(File file, String object) throws IOException {

		Scanner read = new Scanner(file);

		StringBuilder sb = new StringBuilder();
		String tmp;
		boolean write = false;

		while (read.hasNextLine()) {

			tmp = read.nextLine();
			if (!write)
				if (myCompareTo(object, tmp) < 0)
				{
					write = true;
					appendToSB(sb, object);
				}
			appendToSB(sb, tmp);
		}
		//if this is a first object
		if (!write)
			appendToSB(sb, object);
		rewrite(file, sb.toString());

		read.close();
	}

	private static int myCompareTo(String one, String two) {

		String[] ones = one.split(";");
		String[] twos = two.split(";");

		//surname, name, secondName, birhtDate
		for (int i = 1; i < 4; i++) {
			if (ones[i].compareTo(twos[i]) < 0)
				return -1;
			if (ones[i].compareTo(twos[i]) > 0)
				return 1;
		}
		return 0;
	}

	private static void rewrite(File file, String sb) throws IOException {

		//System.out.print(sb);
		PrintWriter out = new PrintWriter(file);
		out.print(sb);
		out.close();
	}

	private static void appendToSB(StringBuilder sb, String add) {
		sb.append(add).append(System.lineSeparator());
	}
}
