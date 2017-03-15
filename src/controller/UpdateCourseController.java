package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Course.Course;
import Course.CreateCourse;
import dataBase.CreateDataBase;
import dataBase.DBConnection;
import instructor.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

public class UpdateCourseController implements Initializable {

	@FXML
	private TextField idText;
	
	@FXML
	private TextField instructorIdText;
	
	@FXML
	private TextField capacityText;
	
	@FXML
	private TextField freeSpacesText;
	
	@FXML
	private TextField priceText;
	
	@FXML
	private TextField hoursText;
	
	@FXML
	private TextField lapText;
	
	@FXML
	private ComboBox<String> subjectCombo;
	
	@FXML
	private DatePicker startDate;
	
	@FXML
	private Label statusLbl;
	
	@FXML
	public void search (ActionEvent event){
		
		try {
			Integer.parseInt(idText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct number");
			return;
		}
		
		try {
			Course course = new Course().search(Integer.parseInt(idText.getText()));
			if (course==null)
				throw new Exception();
			
			
			instructorIdText.setText(course.getInstructorId());
			idText.setEditable(false);
			capacityText.setText(Integer.toString(course.getCourseCapacity()));
			freeSpacesText.setText(Integer.toString(course.getCourseFreeSpaces()));
			priceText.setText(Integer.toString(course.getCourseHours()));
			hoursText.setText(Integer.toString(course.getCourseHours()));
			lapText.setText(Integer.toString(course.getCourseLap()));
			subjectCombo.setValue(course.getCourseSubject());
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Course Not Found");
			return;
		}
		
		
		
		
		
	}

	@FXML
	public void save (ActionEvent event){
		
		//connect to date base
				CreateCourse newCourse = new CreateCourse();
				Course course = new Course();
				CreateDataBase createDB  = new CreateDataBase();
				createDB.createDataBase();
				
				System.out.println("save");
				try{
					
				Connection con = 	new DBConnection().mkConnection();
				PreparedStatement pst = con.prepareStatement("use CoursesCenter");	
				pst.executeUpdate();
				
				pst = con.prepareStatement("delete from course where id =?");
				pst.setInt(1, Integer.parseInt(idText.getText()));
				pst.executeUpdate();
				
				/***
				 * get inputs from texts and add it to CreateCourse object
				 */
				
				if (!check())
					return;
				course.setCourseId(	Integer.parseInt(idText.getText()));	
				course.setInstructorId(instructorIdText.getText());
				course.setCourseCapacity(Integer.parseInt(capacityText.getText()));
				course.setCourseHours(Integer.parseInt(hoursText.getText()));
				course.setCourseLap(Integer.parseInt(lapText.getText()));
				course.setCoursePrice(Integer.parseInt(priceText.getText()));
				course.setCourseSubject(subjectCombo.getValue());
				//when u create a course it will be free  
				course.setCourseFreeSpaces(course.getCourseCapacity());
				
//				//set course date 
//				LocalDate localDate = courseStartDate.getValue();
//				Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
//				Date date = (Date) Date.from(instant);
//				
				//course.setCourseStartDate(courseStartDate);
				
				
//				
				newCourse.saveCourse(course);
				
				statusLbl.setText("Course Updated");
				
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		subjectCombo.getItems().addAll("java" , "c++" , "python");
		
	}
	
	@FXML
	public void delete ( ActionEvent event ){
		
		System.out.println("delllllllllllllllllllteeeeeeeeeeeeeee");
		//connect to date base
		CreateCourse newCourse = new CreateCourse();
		Course course = new Course();
		CreateDataBase createDB  = new CreateDataBase();
		createDB.createDataBase();
		
		
		try{
			
		Connection con = 	new DBConnection().mkConnection();
		PreparedStatement pst = con.prepareStatement("use CoursesCenter");	
		pst.executeUpdate();
		
		pst = con.prepareStatement("delete from course where id =?");
		pst.setInt(1, Integer.parseInt(idText.getText()));
		pst.executeUpdate();
		statusLbl.setText("Course Deleted");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
		}
		
	}
	
	/**
	 * check validation
	 */
	public boolean check (){
		


		
		//check id validation  
		try {
				Integer.parseInt(instructorIdText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Instructor Id");
				return false ;
	     }
				
	     Instructor inst = new Instructor().search(Integer.parseInt(instructorIdText.getText()));
   		if (inst==null){
				JOptionPane.showMessageDialog(null, "Invaild Instructor Id ( Instructor Not Found )");
					return false ;
		}
				
   		try {
			Integer.parseInt(capacityText.getText());
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insert Correct Capacity");
				return false ;
		}
		
		
		//check hours validation
		try {
			Integer.parseInt(hoursText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Hours");
			return false ;
		}
		
		//check price Validation
		try {
			Integer.parseInt(priceText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Price");
			return false ;
		}
		
		//check lap validation 
		try {
			Integer.parseInt(lapText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Lap");
			return false ;
		}
		return true;
	}
	
}
