package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    /*
     * Initialize is the method that runs right when when window shows up. Sort of like a constructor.
     * (non-Javadoc)
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */

     public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }


	    public VBox vbox;

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
	    public ChoiceBox<?> studentFacultyChoiceBox;
	    public ChoiceBox<?> studentCourseChoiceBox;
	    public TextField studentSemesterLabel;

		    public void studentAddButtonAction() {

		    }


		    public void studentSearchButtonAction() {

		    }

	    /*
	     * EMPLOYEE
	     */

	    public TextField employeeCryteriumLabel;
	    public TextArea employeeTextArea;
	    public TextField employeeIdLabel;
	    public TextField employeeTitleLabel;
	    public TextField employeeSurnameLabel;
	    public TextField employeeNameLabel;
	    public TextField employeeBirthDate;

		    public void employeeAddButtonAction() {

		    }


		    public void employeeSearchButtonAction() {

		    }

	    /*
	     * SUBJECT
	     */

	    public TextField subjectCryteriumLabel;
	    public TextArea subjectTextArea;
	    public TextField subjectNameLabel;
	    public ChoiceBox<?> subjectFacultyChoiceBox;


		    public void subjectAddButtonAction() {

		    }


		    public void subjectSearchButtonAction() {

		    }

	    /*
	     * COURSE
	     */

	    public TextField courseCriteriumLabel;
	    public TextArea courseTextArea;
	    public TextField courseIdLabel;
	    public TextField courseNameLabel;
	    public ChoiceBox<String> courseFacultyChoiceBox;

		    public void courseAddButtonAction() {

		    	String faculty = courseFacultyChoiceBox.getValue();
		    	String id = courseIdLabel.getText();
		    	String name = courseNameLabel.getText();
		    	Main.loadCourse(id, name, faculty);
		    }


		    public void courseSearchButtonAction() {

		    }

	    /*
	     * FACULTY
	     */

	    public TextField facultyCriteriumLabel;
	    public TextArea facultyTextArea;
	    public TextField facultyIdLabel;
	    public TextField facultyNameLabel;



		    public void facultyAddButtonAction() {

		    	String id = facultyIdLabel.getText();
		        String name = facultyNameLabel.getText();
		        Main.loadFaculty(id, name);
		        courseFacultyChoiceBox.setItems(FXCollections.
		        					observableArrayList(Main.getAllFaculties()));
		    }


		    public void facultySearchButtonAction() {

		    }

}