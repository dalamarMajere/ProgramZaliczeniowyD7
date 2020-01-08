package application;

import java.io.*;
import java.util.*;

public class dataAnalyzer {

	public static void loadObject(File file, String object) throws IOException {

		Scanner read = new Scanner(file);

		StringBuilder sb = new StringBuilder();
		String tmp;
		boolean write = false;

		System.out.println("New");
		while (read.hasNextLine()) {

			tmp = read.nextLine();
			System.out.print(tmp);
			if (!write)
				if (object.compareTo(tmp) < 0)
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
