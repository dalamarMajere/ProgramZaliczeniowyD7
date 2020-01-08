package application;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
		public ChoiceBox<String> studentChoicebox;
		public ChoiceBox<String> studentSubjectChoicebox;
	    public TextField studentIdLabel;
	    public TextField studentSurnameLabel;
	    public TextField studentNameLabel;
	    public TextField studentSecondNameLabel;
	    public TextField studentBirthDateLabel;
	    public ChoiceBox<String> studentFacultyChoiceBox;
	    public TextField studentSemesterLabel;
	    public TextField studentGradesLabel;

		    public void studentAddButtonAction() {

		    	String container = studentCryteriumLabel.getText();
		    	System.out.println("Searching for.. "+container);
		    	ObservableList<String> list = FXCollections.observableArrayList(container);
		    	studentChoicebox.setItems(list);
		    	studentChoicebox.setValue(list.get(0));

		    }

		    public void studentSearchButtonAction() {

		    }

		    public void studentInfoAbortButtonAction() {

		    }


		    public void studentInfoSaveButtonAction() {

		    }


		    public void studentGradeAbortButtonAction() {

		    }

		    public void studentGradeSaveButtonAction() {

		    }

	    /*
		 * TEACHER
		 */
		public TextField employeeCryteriumLabel;
	    public ChoiceBox<?> employeeChoicebox;
	    public ChoiceBox<?> employeeSubjectChoicebox;
	    public TextField employeeIdLabel;
	    public TextField employeeTitleLabel;
	    public TextField employeeSurnameLabel;
	    public TextField employeeNameLabel;
	    public TextField employeeBirthDate;

			public void employeeAbortButtonAction() {

		    }


		    public void employeeAddButtonAction() {

		    }


		    public void employeeSaveButtonAction() {

		    }


		    public void employeeSearchButtonAction() {

		    }


		    public void employeeSubjectAbortButtonAction() {

		    }


		    public void employeeSubjectSaveButtonAction() {

		    }

	    /*
	     * SUBJECT
	     */
	    public TextField subjectCryteriumLabel;
	    public ChoiceBox<?> subjectChoicebox;
	    public TextField subjectNameLabel;
	    public ChoiceBox<?> subjectUnitChoiceBox;

		    public void subjectSearchButtonAction() {

		    }

		    public void subjectAddButtonAction() {

		    }

		    public void subjectAbortButtonAction() {

		    }

		    public void subjectSaveButtonAction() {

		    }

	    /*
	     * COURSE
	     */

	    public TextField courseCriteriumLabel;
	    public ChoiceBox<?> courseChoicebox;
	    public ChoiceBox<?> courseSubjectChoicebox;
	    public TextField courseIdLabel;
	    public TextField courseNameLabel;

		    public void courseSearchButtonAction() {

		    }

		    public void courseAddButtonAction() {

		    }

		    public void courseAbortButtonAction() {

		    }

		    public void courseSaveButtonAction() {

		    }

	    /*
	     * FACULTY
	     */

	    public TextField facultyCriteriumLabel;
	    public ChoiceBox<?> facultyChoicebox;
	    public ChoiceBox<?> facultyCourseChoicebox;
	    public TextField facultyIdLabel;
	    public TextField facultyNameLabel;

	    	public void facultySearchButtonAction() {

	    	}

		    public void facultyAddButtonAction() {

		    }

		    public void facultyAbortButtonAction() {

		    }

		    public void facultySaveButtonAction() {

		    }





}