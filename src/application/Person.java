package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

	private int personId;
	private String name, surname, secondName;
	private Date birthDate;

	//constructors
	public Person(int personId, String surname, String name) {
		this(personId, surname, name, "");
	}

	public Person(int personId, String surname, String name, String secondName,
					String birthDate) {

		this(personId, surname, name, secondName);
		try {
			this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(birthDate);
		} catch (ParseException e) {
			System.err.print("Date or its format are wrong !");
		}
	}

	public Person(int personId, String surname, String name, String secondName) {
		this(personId, surname, name, secondName, new Date());
	}

	public Person(int personId, String surname, String name, String secondName,
			Date birthDate) {

		this.personId = personId;
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return Integer.toString(personId) + ";" + surname + ";" +
				name + ";" + secondName + ";" +
				new SimpleDateFormat("dd.MM.yyyy").format(birthDate);
	}

	/*
	 * Getters and Setters
	 */
	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setBirthDate(String birthDate) {
		try {
			this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(birthDate);
		} catch (ParseException e) {
			System.err.print("Date or its format are wrong !");
		}
	}
}

