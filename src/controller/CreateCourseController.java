package controller;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javax.crypto.CipherInputStream;
import javax.swing.JOptionPane;

import Course.Course;
import Course.CreateCourse;
import dataBase.CreateDataBase;
import instructor.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 
 * @author mohanad-elmaghrby
 *
 */
public class CreateCourseController implements Initializable {

	
	@FXML
	private Button btnSubmit;
	
	@FXML
	private TextField courseIdText , instructorIdText , courseCapacityText , courseHoursText ,coursePriceText , courseLapText;
	
	@FXML
	private ComboBox<String> subjectCombo;
	
	@FXML
	private DatePicker courseStartDate;
	
	@FXML //status label if the new course saved successfully it show message
	private Label statusLbl;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		subjectCombo.getItems().addAll("java" , "c++" , "paython");
		
	}
	
	/**
	 * get info from gui and store it
	 * @param event
	 */
	@FXML
	public void submit(ActionEvent event){
		//connect to date base
		CreateCourse newCourse = new CreateCourse();
		Course course = new Course();
		CreateDataBase createDB  = new CreateDataBase();
		createDB.createDataBase();
		
		System.out.println("submit");
		try{
			
		/***
		 * get inputs from texts and add it to CreateCourse object
		 */
			
		if (!check(null))
			return;
		course.setCourseId(	Integer.parseInt(courseIdText.getText()));	
		course.setInstructorId(instructorIdText.getText());
		course.setCourseCapacity(Integer.parseInt(courseCapacityText.getText()));
		course.setCourseHours(Integer.parseInt(courseHoursText.getText()));
		course.setCourseLap(Integer.parseInt(courseLapText.getText()));
		course.setCoursePrice(Integer.parseInt(coursePriceText.getText()));
		course.setCourseSubject(subjectCombo.getValue());
		//when u create a course it will be free  
		course.setCourseFreeSpaces(course.getCourseCapacity());
		
//		//set course date 
//		LocalDate localDate = courseStartDate.getValue();
//		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
//		Date date = (Date) Date.from(instant);
//		
		//course.setCourseStartDate(courseStartDate);
		
		
//		
		if (check(course)){
		
			newCourse.saveCourse(course);
			statusLbl.setText("course saved");
		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * check validation if new course inputs
	 * @param course : course for check validation
	 * @return true if correct , false if not correct
	 */
	public boolean check (Course course){
		
		//check id validation  
		try {
			Integer.parseInt(courseIdText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
			return false ;
		}
		
		Course cour = new Course().search(Integer.parseInt(courseIdText.getText()));
		if (cour!=null){
			JOptionPane.showMessageDialog(null, "Invaild Course Id ( Id Alresdy Exists )");
			return false ;
		}
		
		//check instructor id validation
		try {
			Integer.parseInt(instructorIdText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Instructor Id");
			return false;
		}
		
		Instructor inst = new Instructor().search(Integer.parseInt(instructorIdText.getText()));
		if (inst==null){
			JOptionPane.showMessageDialog(null, "Invaild Instructor Id ( Instructor Not Found )");
			return false ;
		}
		
		
		//check capacity validation
		try {
			Integer.parseInt(courseCapacityText.getText());
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insert Correct Capacity");
				return false ;
		}
		
		
		//check hours validation
		try {
			Integer.parseInt(courseHoursText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Hours");
			return false ;
		}
		
		//check price Validation
		try {
			Integer.parseInt(coursePriceText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Price");
			return false ;
		}
		
		//check lap validation 
		try {
			Integer.parseInt(courseLapText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Lap");
			return false ;
		}
		
		return true;
		
	}

}
