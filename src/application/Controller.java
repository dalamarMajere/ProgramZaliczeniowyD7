package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class Controller implements Initializable {

	 /*
	 * Initialize is the method that runs right when when window shows up. Sort of like a constructor.
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */

	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("View is now loaded!");
		loadChoiceBox();
	}


	/*
	* STUDENT
	*/

	public TextField studentCryteriumLabel;
	public TextArea studentTextArea;
	public TextField studentIdLabel;
	public TextField studentSurnameLabel;
	public TextField studentNameLabel;
	public TextField studentSecondNameLabel;
	public TextField studentBirthDateLabel;
	public ChoiceBox<String> studentFacultyChoiceBox;
	public ChoiceBox<String> studentCourseChoiceBox;
	public TextField studentSemesterLabel;

	/*
	* ADD STUDENT
	*/
	public void studentAddButtonAction() throws IOException {
		String id = studentIdLabel.getText();
		String surname = studentSurnameLabel.getText();
		String name = studentNameLabel.getText();
		String secondName = studentSecondNameLabel.getText();
		String birthDate = studentBirthDateLabel.getText();
		String faculty = studentFacultyChoiceBox.getValue();
		String course = studentCourseChoiceBox.getValue();
		String semester = studentSemesterLabel.getText();

		if(checkString(surname,name,secondName)&&checkNumber(semester,id)&&checkDate(birthDate)&&checkChoiceBox(studentFacultyChoiceBox,studentCourseChoiceBox)){
			String formated[]=formatText(surname,name,secondName);
			Main.loadStudent(id, formated[0], formated[1], formated[2], birthDate,
						faculty, course, semester);

			resetValue(studentBirthDateLabel, studentIdLabel, studentSurnameLabel,
						studentNameLabel, studentSecondNameLabel, studentSemesterLabel);
			studentFacultyChoiceBox.setValue(null);
			studentCourseChoiceBox.setValue(null);
		}
	}

	public void studentFacultyChosen() {
		studentCourseChoiceBox.setItems(getCourse(
			studentFacultyChoiceBox.getValue()));
	 }

	/*
	* STUDENT SEARCH
	*/

	public void studentSearchButtonAction() throws IOException {
		ArrayList<String> filteredStudents = Main.searchStudent(studentCryteriumLabel.getText());

		for(int i = 0 ; i < filteredStudents.size() ; i++ ){
			String[] currentStudent = separate(filteredStudents.get(i));
			for(int j = 0; j < currentStudent.length ; j++ ){
				studentTextArea.insertText(studentTextArea.getLength(), currentStudent[j] + "|");
			}
			studentTextArea.insertText(studentTextArea.getLength(),"\n");
    	}
	}

	/*
	 * TEACHER
	*/

	public TextField employeeCryteriumLabel;
	public TextArea employeeTextArea;
	public TextField employeeIdLabel;
	public TextField employeeTitleLabel;
	public TextField employeeSurnameLabel;
	public TextField employeeNameLabel;
	public TextField employeeBirthDate;

	/*
	* ADD TEACHER
	*/

    public void employeeAddButtonAction() throws IOException {
    	String id = employeeIdLabel.getText();
    	String title = employeeTitleLabel.getText();
    	String surname = employeeSurnameLabel.getText();
    	String name = employeeNameLabel.getText();
    	String birth = employeeBirthDate.getText();

    	if(checkString(title,surname,name,birth)&&checkNumber(id)&&checkDate(birth)){
    		//load
    		resetValue(employeeIdLabel,employeeTitleLabel,employeeSurnameLabel
    				,employeeNameLabel,employeeBirthDate);
    	}
    }

	/*
	* SEARCH TEACHER
	*/

    public void employeeSearchButtonAction() throws IOException {
    	ArrayList<String> filteredTeachers = Main.searchTeacher(employeeCryteriumLabel.getText());

    	for(int i = 0 ; i < filteredTeachers.size() ; i++ ){
			String[] currentTeacher = separate(filteredTeachers.get(i));
			for(int j = 0; j < currentTeacher.length ; j++ ){
				employeeTextArea.insertText(employeeTextArea.getLength(), currentTeacher[j] + "|");
			}
			employeeTextArea.insertText(employeeTextArea.getLength(),"\n");
    	}
    }

	/*
	 * SUBJECT
	*/

	public TextField subjectCryteriumLabel;
	public TextArea subjectTextArea;
	public TextField subjectNameLabel;
	public ChoiceBox<String> subjectFacultyChoiceBox;
	public ChoiceBox<String> subjectCourseChoiceBox;

	/*
	 * ADD SUBJECT
	*/

    public void subjectAddButtonAction() throws IOException {
    	String name = subjectNameLabel.getText();
    	String faculty = subjectFacultyChoiceBox.getValue();
    	String course = subjectCourseChoiceBox.getValue();

    	if(checkString(name)&&checkChoiceBox(subjectCourseChoiceBox,subjectFacultyChoiceBox)){
        	Main.loadSubject(name, faculty, course);
        	resetValue(subjectNameLabel);
        	subjectFacultyChoiceBox.setValue(null);
        	subjectCourseChoiceBox.setValue(null);
    	}
    }

    /*
	 * SEARCH SUBJECT
	*/

    public void subjectSearchButtonAction() throws IOException {
    	ArrayList<String> filteredSubjects = Main.searchSubject(subjectCryteriumLabel.getText());

    	for(int i = 0 ; i < filteredSubjects.size() ; i++ ){
			String[] currentSubject = separate(filteredSubjects.get(i));
			for(int j = 0; j < currentSubject.length ; j++ ){
				subjectTextArea.insertText(subjectTextArea.getLength(), currentSubject[j] + "|");
			}
			subjectTextArea.insertText(subjectTextArea.getLength(),"\n");
    	}
    }

	/*
	* COURSE
	*/

    public TextField courseCriteriumLabel;
    public TextArea courseTextArea;
    public TextField courseIdLabel;
    public TextField courseNameLabel;
    public ChoiceBox<String> courseFacultyChoiceBox;

    /*
	 * ADD COURSE
	*/

    public void courseAddButtonAction() throws IOException {
    	String faculty = courseFacultyChoiceBox.getValue();
    	String id = courseIdLabel.getText();
    	String name = courseNameLabel.getText();
    	if(checkString(name)&&checkNumber(id)&&checkChoiceBox(courseFacultyChoiceBox)){
    		Main.loadCourse(id, name, faculty);
    		courseFacultyChoiceBox.setValue(null);
    		resetValue(courseIdLabel,courseNameLabel);
    		loadChoiceBox();
    	}
    }

    /*
	 * SEARCH COURSE
	*/

    public void courseSearchButtonAction() throws IOException {
    	ArrayList<String> filteredCourses = Main.searchCourse(courseCriteriumLabel.getText());

    	for(int i = 0 ; i < filteredCourses.size() ; i++ ){
			String[] currentCourse = separate(filteredCourses.get(i));
			for(int j = 0; j < currentCourse.length ; j++ ){
				courseTextArea.insertText(courseTextArea.getLength(), currentCourse[j] + "|");

			}
			courseTextArea.insertText(courseTextArea.getLength(),"\n");
    	}
    }

	/*
	* FACULTY
	*/

    public TextField facultyCriteriumLabel;
    public TextArea facultyTextArea;
    public TextField facultyIdLabel;
    public TextField facultyNameLabel;

    /*
	* ADD FACULTY
	*/

    public void facultyAddButtonAction() throws IOException {
    	String id = facultyIdLabel.getText();
        String name = facultyNameLabel.getText();

        if(checkNumber(id)&&checkString(name)){
        	 Main.loadFaculty(id, name);
        	 loadChoiceBox();
        	 resetValue(facultyNameLabel,facultyIdLabel);
        }

    }

    /*
	* SEARCH FACULTY
	*/

    public void facultySearchButtonAction() throws IOException {
    	ArrayList<String> filteredFaculties = Main.searchFaculty(facultyCriteriumLabel.getText());

    	for(int i = 0 ; i < filteredFaculties.size() ; i++ ){
			String[] currentFaculty = separate(filteredFaculties.get(i));
			for(int j = 0; j < currentFaculty.length ; j++ ){
				facultyTextArea.insertText(facultyTextArea.getLength(), currentFaculty[j] + "|");
			}
			facultyTextArea.insertText(facultyTextArea.getLength(),"\n");
    	}
    }

    /*
     * DATA CHECK METHODS
     */

    public boolean checkDate(String... input) throws IOException{
    	boolean check=true;
		Date date= new Date();
		for(int i=0;i<input.length;i++){
			try {
				date = new SimpleDateFormat("dd.MM.yyyy").parse(input[i]);

			} catch (ParseException e) {
				Main.showAlertBox("Blad Wprowadzania","Upewnij sie ze data jest w formacie (dd.mm.yyyy)");
				check=false;
				break;
			}
		}
		return check;
    }

    public boolean checkString(String... input) throws IOException{
    	boolean check=true;
    	for(int i = 0; i < input.length;i++){
    		if(input[i].isEmpty()){
    			Main.showAlertBox("Blad Wprowadzania","Wszystkie pola musz¹ byc uzupelnione!");
    			check=false;
    			break;
    		}
    	}
    	return check;
    }

    public boolean checkChoiceBox(ChoiceBox... input) throws IOException{
    	boolean check=true;
    	for(int i = 0; i < input.length;i++){
    		if(input[i].getValue()==null){
    			Main.showAlertBox("Blad Wprowadzania","Wszystkie pola wyboru musz¹ byc uzupelnione!");
    			check=false;
    			break;
    		}
    	}
    	return check;
    }

    public boolean checkNumber(String... input) throws IOException{
    	boolean check = true;
    	for(int i = 0 ; i < input.length ; i++){
    		if(checkString(input[i])){
    			try{
        			Integer.parseInt(input[i]);
        		}catch(Exception e){
        			check = false;
        			Main.showAlertBox("Blad Wprowadzania","Niektore pola musz¹ byc numerem !");
        			break;
        		}
    		}else{
    			check = false;
    			break;
    		}

    	}
    	return check;
    }
    /*
     * OTHER METHODS
     */

    public void resetValue(TextField... field){
    	for(int i = 0; i<field.length;i++){
    		field[i].setText("");
    	}
    }

    public String[] formatText(String... text){
    	String[] values = text;

    	for(int i=0; i<values.length;i++){
    		values[i].toLowerCase();
    		values[i]=values[i].substring(0,1).toUpperCase()+values[i].substring(1,values[i].length());
    	}

    	return values;
    }

    public String[] separate(String input){
    	String[] output = input.split(";");
    	return output;
    }

    private void loadChoiceBox() {
		ObservableList<String> list = getFaculty();

		studentFacultyChoiceBox.setItems(list);
		courseFacultyChoiceBox.setItems(list);
		subjectFacultyChoiceBox.setItems(list);

		studentFacultyChoiceBox.getSelectionModel().selectedItemProperty().
			addListener(new ChangeListener<String>() {
				public void changed(ObservableValue<? extends String> observable,
	                    String oldValue, String newValue) {
	                if (newValue != null) {
	                    studentCourseChoiceBox.setItems(
	                    		getCourse(studentFacultyChoiceBox.getValue()));
	                }
	            }
	        });

		subjectFacultyChoiceBox.getSelectionModel().selectedItemProperty().
			addListener(new ChangeListener<String>() {
				public void changed(ObservableValue<? extends String> observable,
	                    String oldValue, String newValue) {
	                if (newValue != null) {
	                    subjectCourseChoiceBox.setItems(
	                    		getCourse(subjectFacultyChoiceBox.getValue()));
	                }
	            }
        });
	}

    private ObservableList<String> getCourse(String faculty) {
		try {
				ArrayList<String> list = Main.getAllCourses(faculty);
				if (!list.isEmpty()) return FXCollections.observableList(list);
		}
		catch (IOException e) {e.printStackTrace();}
		return FXCollections.observableArrayList();
	 }

	private ObservableList<String> getFaculty() {
		try {
			ArrayList<String> list = Main.getAllFaculties();
			if (!list.isEmpty()) return FXCollections.observableList(list);
		}
		catch (IOException e) {e.printStackTrace();}
		return FXCollections.observableArrayList();
	 }
}