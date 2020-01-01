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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    /*
     * Initialize is the method that runs right when when window shows up. Sort of like a constructor.
     * (non-Javadoc)
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */

	@FXML
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }

    /*
     * STUDENT
     */

    private VBox vbox;
    public TextField studentCryteriumLabel;
    public ChoiceBox<String> studentChoicebox;
    public ChoiceBox<String> studentSubjectChoicebox;

	    public void studentSearchButtonAction(){
	    	String container = studentCryteriumLabel.getText();
	    	System.out.println("Searching for.. "+container);

	    	ObservableList<String> list = FXCollections.observableArrayList(container);

	    	studentChoicebox.setItems(list);
	    	studentChoicebox.setValue(list.get(0));

	    }

	    public void studentAddButtonAction(){
	    }


	public ToggleGroup studentActivityRadio;
	public RadioButton studentActiveRadio;
	public RadioButton studentNotActiveRadio;

	    public void studentActivityRadioAction(){

	    }


	public TextField studentIdLabel;
    public TextField studentSurnameLabel;
    public TextField studentNameLabel;
    public TextField studentSecondNameLabel;
    public TextField studentBirthDateLabel;
    public TextField studentUnitLabel;
    public TextField studentSemesterLabel;

	    public void studentInfoSaveButtonAction(){
	    	System.out.println(studentIdLabel.getText());
	    }

	    public void studentInfoAbortButtonAction(){

	    }

	public ToggleGroup studentSubjectActivityRadio;
	public RadioButton studentSubjectActiveRadio;
	public RadioButton studentSubjectNotActiveRadio;

	    public void studentSubjectActivityRadioAction(){

	    }

    private TextField studentGradesLabel;

	    public void studentGradeSaveButtonAction(){

	    }

	    public void studentGradeAbortButtonAction(){

	    }

    /*
     * EMPLOYEE
     */

	public TextField employeeCryteriumLabel;
    public ChoiceBox<?> employeeChoicebox;
    public ChoiceBox<?> employeeSubjectChoicebox;

	    public void employeeSearchButtonAction(){

	    }

	    public void employeeAddButtonAction(){

	    }

	    public ToggleGroup employeeActivityRadio;
	    public RadioButton employeeActiveRadio;
	    public RadioButton employeeNotActiveRadio;

	    public void employeeActivityRadioAction(){

	    }

	public TextField employeeIdLabel;
	public TextField employeeTitleLabel;
    public TextField employeeSurnameLabel;
    public TextField employeeNameLabel;
    public TextField employeeBirthDate;

	    public void employeeSaveButtonAction(){

	    }

	    public void employeeAbortButtonAction(){

	    }

	public RadioButton employeeSubjectActiveRadio;
    public ToggleGroup employeeSubjectActivityRadio;
    public RadioButton employeeSubjectNotActiveRadio;

	    public void employeeSubjectActivityRadioAction(){

	    }

	    public void employeeSubjectSaveButtonAction(){

	    }

	    public void employeeSubjectAbortButtonAction(){

	    }

    /*
     * UNIT
     */
	public TextField unitCriteriumLabel;
    public ChoiceBox<?> unitChoicebox;
    public ChoiceBox<?> unitSubjectChoicebox;

	    public void unitSearchButtonAction(){

	    }

	    public void unitAddButtonAction(){

	    }

	public RadioButton unitActiveRadio;
    public ToggleGroup unitActivityRadio;
    public RadioButton unitNotActiveRadio;

	    public void unitActivityRadioAction(){

	    }

	public TextField unitIdLabel;
	public TextField unitNameLabel;

	    public void unitSaveButtonAction(){

	    }

	    public void unitAbortButtonAction(){

	    }

	/*
	 * SUBJECT
	 */

	public TextField subjectCryteriumLabel;
	public ChoiceBox<?> subjectChoicebox;

	    public void subjectSearchButtonAction(){

	    }

	    public void subjectAddButtonAction(){

	    }

	public RadioButton subjectActiveRadio;
    public ToggleGroup subjectActivityRadio;
    public RadioButton subjectNotActiveRadio;

	    public void subjectActivityRadioAction(){

	    }

	public TextField subjectNameLabel;
	public ChoiceBox<?> subjectUnitChoiceBox;

	    public void subjectSaveButtonAction(){

	    }

	    public void subjectAbortButtonAction(){

	    }

}