package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import instructor.InsertInstructor;
import instructor.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateInstructorController implements Initializable {

	@FXML
	private Button saveBtn;
	
	@FXML
	private TextField idText2;
	
	@FXML
	private TextField firstNameText2;

	@FXML
	private TextField lastNameText2;
	
	@FXML
	private TextField emailText2;
	
	@FXML
	private TextField phoneText2;
	
	@FXML
	private TextField sallaryText2;
	
	@FXML
	private TextArea addressText2;
	
	@FXML
	private ComboBox<String> subjectCombo2;
	
	@FXML
	private Label statusLbl2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	@FXML
	public void search (ActionEvent event){
		
		int id;
		try {
			
			id=Integer.parseInt(idText2.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please Correct Id");
			return;
		}
		
		Instructor instructor = new Instructor().search((Integer.parseInt(idText2.getText())));
		
		if (instructor==null){
			JOptionPane.showMessageDialog(null, "Instructor Id Not Found ");
			return;
		}
		
		
		idText2.setEditable(false);
		
		firstNameText2.setText(instructor.getFirstName());
		lastNameText2.setText(instructor.getLastName());
		emailText2.setText(instructor.getEmail());
		phoneText2.setText(instructor.getPhone());
		sallaryText2.setText(Integer.toString(instructor.getSallary()));
		addressText2.setText(instructor.getAddress());
		subjectCombo2.getItems().addAll("java" , "c++" , "python");
		
	
	}
	
	@FXML
	public void save (ActionEvent event){
		Instructor instructor = new Instructor();
		instructor.setId(Integer.parseInt(idText2.getText()));
		instructor.setFirstName(firstNameText2.getText());
		instructor.setLastName(lastNameText2.getText());
		instructor.setEmail(emailText2.getText());
		instructor.setPhone(phoneText2.getText());
		instructor.setSallary(Integer.parseInt(sallaryText2.getText()));
		instructor.setAddress(addressText2.getText());
		instructor.settSubject(subjectCombo2.getValue());
		
		new InsertInstructor().saveInstructor(instructor , true);
		
		statusLbl2.setText("successfully updated");
	}
	

}
