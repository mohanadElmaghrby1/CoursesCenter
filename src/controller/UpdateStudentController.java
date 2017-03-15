package controller;

import javax.swing.JOptionPane;

import instructor.InsertInstructor;
import instructor.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import student.InsertStudent;
import student.Student;

public class UpdateStudentController {

	
	
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
	private TextField paymentsText2;
	
	@FXML
	private TextArea addressText2;
	
	
	@FXML
	private Label statusLbl2;
	
	
	
	@FXML
	public void search (ActionEvent event){
		
		int id;
		try {
			
			id=Integer.parseInt(idText2.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please Correct Id");
			return;
		}
		
		Student student = new Student().search(Integer.parseInt(idText2.getText()));
		
		idText2.setEditable(false);
		
		firstNameText2.setText(student.getFirstName());
		lastNameText2.setText(student.getLastName());
		emailText2.setText(student.getEmail());
		phoneText2.setText(student.getPhone());
		paymentsText2.setText(Integer.toString(student.getPayments()));
		addressText2.setText(student.getAddress());
		
	
	}
	
	@FXML
	public void save (ActionEvent event){
		Student student = new Student();
		student.setId(Integer.parseInt(idText2.getText()));
		student.setFirstName(firstNameText2.getText());
		student.setLastName(lastNameText2.getText());
		student.setEmail(emailText2.getText());
		student.setPhone(phoneText2.getText());
		student.setPayments(Integer.parseInt(paymentsText2.getText()));
		student.setAddress(addressText2.getText());
		
		System.out.println(student.getPayments());
		
		new InsertStudent().saveStudent(student, true);
		
		statusLbl2.setText("successfully updated");
	}
	

}
