package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Course.Course;
import Course.CreateCourse;
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

public class InsertInstructorController implements Initializable {
	
	
	@FXML
	private Button btnSubmit;
	
	@FXML
	private TextField idText , firstNameText , lastNameText , emailText, phoneText ,sallaryText;
	
	@FXML
	private TextArea addressText;
	
	@FXML
	private ComboBox<String> subjectCombo;
	
	@FXML
	private DatePicker createDate;
	
	@FXML //status label if the new course saved successfully it show message
	private Label statusLbl;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		subjectCombo.getItems().addAll("java" , "c++" , "python");
	}

	
	
	
	
	
	
	/**
	 * get info from gui and store it
	 * @param event
	 */
	@FXML
	public void submit(ActionEvent event){
		//connect to date base
		InsertInstructor newInstructor = new InsertInstructor();
		Instructor instructor = new Instructor();
		CreateDataBase createDB  = new CreateDataBase();
		createDB.createDataBase();
		
		System.out.println("submit");
		try{
			
		/***
		 * get inputs from texts and add it to insertInstructor object
		 */
			if (!check())
				return;
			instructor.setId(	Integer.parseInt(idText.getText()));
			instructor.settSubject(subjectCombo.getValue());
			instructor.setFirstName(firstNameText.getText());
			instructor.setLastName(lastNameText.getText());
			instructor.setEmail(emailText.getText());
			instructor.setPhone(phoneText.getText());
			instructor.setSallary(Integer.parseInt(sallaryText.getText()));
			instructor.setAddress(addressText.getText());
		
			//save instructor to data base
			newInstructor.saveInstructor(instructor , false);
		
		statusLbl.setText("instructor saved");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public boolean check(){
		//check id validation  
				try {
						Integer.parseInt(idText.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insert Correct Instructor Id");
						return false ;
			     }
						
			     Instructor inst = new Instructor().search(Integer.parseInt(idText.getText()));
		   		if (inst!=null){
						JOptionPane.showMessageDialog(null, "Invaild Instructor Id ( Instructor Not Found )");
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
				Integer.parseInt(sallaryText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Sallary ");
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
