package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import dataBase.CreateDataBase;
import instructor.InsertInstructor;
import instructor.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import student.InsertStudent;
import student.Student;

public class InsertStudentController implements Initializable {

	
	

	@FXML
	private Button btnSubmit;
	
	@FXML
	private TextField idText , firstNameText , lastNameText , emailText, phoneText ;
	
	@FXML
	private TextArea addressText;
	
	
	@FXML //status label if the new student saved successfully it show message
	private Label statusLbl;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * get info from gui and store it
	 * @param event
	 */
	@FXML
	public void submit(ActionEvent event){
		//connect to date base
		InsertStudent newStudent = new InsertStudent();
		Student student = new Student();
		CreateDataBase createDB  = new CreateDataBase();
		createDB.createDataBase();
		
		System.out.println("submit");
		try{
			
			//check validation
			if (!check())
				return;
		/***
		 * get inputs from texts and add it to insertStudent object
		 */
			student.setId(	Integer.parseInt(idText.getText()));
			student.setFirstName(firstNameText.getText());
			student.setLastName(lastNameText.getText());
			student.setEmail(emailText.getText());
			student.setPhone(phoneText.getText());
			student.setPayments(0);
			student.setAddress(addressText.getText());
		
			//save instructor to data base
			newStudent.saveStudent(student, false);
		
		statusLbl.setText("student saved");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean check(){
		//check id validation  
				try {
						Integer.parseInt(idText.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insert Correct Student Id");
						return false ;
			     }
						
			     Student inst = new Student().search(Integer.parseInt(idText.getText()));
		   		if (inst!=null){
						JOptionPane.showMessageDialog(null, "Invaild Student Id ( Student Not Found )");
							return false ;
				}
		   		
		//check name validation
		 String name =firstNameText.getText()+lastNameText.getText();
		 name = name.toLowerCase();
		 
		 System.out.println("=================="+name+name.split("[a-z]").length);
		 if (name.split("[a-z]").length>0){
			 JOptionPane.showMessageDialog(null, "Please Insert Correct Name ");
			 return false;
		 }
		 
		 try {
				if (phoneText.getText().length()!=11 || phoneText.getText().split("[0-9]").length>0){
					throw new Exception();
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Phone Number");
				return false ;
	     } 
		   		
		 try {
	
			 String mail=emailText.getText();
			 if (mail.length()<6 || !mail.substring(mail.length()-4, mail.length()).equals(".com")){
				 throw new Exception();
			 }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct  Email");
			return false ;
		}
		 
		 try {
				if(addressText.getText().length()<2){
					throw new Exception();
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Sallary ");
				return false ;
	     }
		
		return true;
	}
	
	
}
