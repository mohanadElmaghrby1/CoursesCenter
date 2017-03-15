package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import list.*;
import Course.Course;
import instructor.Instructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * 
 * @author mohanad-elmaghrby
 *
 */
public class CoursesController implements Initializable {

	
	@FXML
	private Button createNewCourse;
	
	@FXML
	private TextField courseIdSearchText;
	
	
	@FXML
	private TableView<CourseList> courseTable;
	
	@FXML
	private TableColumn<CourseList, Integer> id;
	
	@FXML
	private TableColumn<CourseList, String> instructorId;

	@FXML
	private TableColumn<CourseList, Integer> numberOfStudents;
	
	@FXML
	private TableColumn<CourseList, Integer> hours;
	
	@FXML
	private TableColumn<CourseList, Integer> freeSpaces;
	
	@FXML
	private TableColumn<CourseList, Integer> lap;
	
	@FXML
	private TableColumn<CourseList, Integer> price;
	
	@FXML
	private TableColumn<CourseList, String> subject;
	
	@FXML
	private TableColumn<CourseList, String> createDate;
	
	@FXML
	private TableColumn<CourseList, String> startDate;
	
	public ObservableList<CourseList> list;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		id.setCellValueFactory(new PropertyValueFactory<CourseList , Integer>("id"));
		subject.setCellValueFactory(new PropertyValueFactory<CourseList , String>("subject"));
		instructorId.setCellValueFactory(new PropertyValueFactory<CourseList , String>("instructorId"));
		createDate.setCellValueFactory(new PropertyValueFactory<CourseList , String >("createDate"));
		hours.setCellValueFactory(new PropertyValueFactory<CourseList , Integer>("hours"));
		price.setCellValueFactory(new PropertyValueFactory< CourseList , Integer>("price"));
		freeSpaces.setCellValueFactory(new PropertyValueFactory<CourseList , Integer>("freeSpaces"));
		numberOfStudents.setCellValueFactory(new PropertyValueFactory<CourseList , Integer>("numberOfStudents"));
		startDate.setCellValueFactory(new PropertyValueFactory<CourseList , String>("startDate"));
		lap.setCellValueFactory(new PropertyValueFactory<CourseList , Integer>("lap"));
		refresh(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FXML
	public void createNewCourse(ActionEvent event) throws IOException{
		
		//create new stage for adding new course 
		Stage stage = new Stage();
		
		//load fxml file 
		Parent root=FXMLLoader.load(getClass().getResource("/view/CreateCourse.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Create New Course");
		stage.setScene(scene);
		stage.show();
		
		
		System.out.println("create new ");
	}
	
	@FXML
	public void update(ActionEvent event) throws IOException{
		
		//create new stage for adding new course 
		Stage stage = new Stage();
		
		//load fxml file 
		Parent root=FXMLLoader.load(getClass().getResource("/view/UpdateCourse.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Update  Course");
		stage.setScene(scene);
		stage.show();
		
		
		System.out.println("Update Course ");
	}
	
	
	@FXML
	public void delete(ActionEvent event) throws IOException{
		
		//create new stage for Deleting new course 
		Stage stage = new Stage();
		
		//load fxml file 
		Parent root=FXMLLoader.load(getClass().getResource("/view/DeleteCourse.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Delete  Course");
		stage.setScene(scene);
		stage.show();
		
		
		System.out.println("Delete Course ");
	}
	
	/**
	 * search for a course
	 * @param event
	 */
	@FXML
	public void search (ActionEvent event){
		
		try {
			Integer.parseInt(courseIdSearchText.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insert Correct Id");
			return;
		}
		
		try {
			Course course = new Course().search(Integer.parseInt(courseIdSearchText.getText()));
			
			CourseList l = new CourseList(course);
			
//			list=FXCollections.observableArrayList(new CourseList( course.getCourseId() ,course.getInstructorId(), 
//					 course.getCourseSubject(), course.getCourseCapacity(), 
//					course.getCourseHours(),
//					course.getCourseFreeSpaces(), course.getCourseLap(), "0", "0", 0, course.getCoursePrice()));
			list = FXCollections.observableArrayList(new CourseList(course));

			
			courseTable.setItems(list);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Course Not Found");
		}
	}



	
	@FXML
	public void refresh(ActionEvent event){
		
		System.out.println("sssssssssssssssss <<< Refresh  >>>sssssssssss");
        try {
        	List <Course> allList = new Course().getAllCourses();
        	
			list = FXCollections.observableArrayList( new CourseList(allList.get(0)));
					
			int i=1;
			while (i < allList.size()){
				CourseList inlist = new CourseList(allList.get(i));
				list.add(inlist);
				++i;
			
			}
			System.out.println(list.get(0).getSubject());
			courseTable.setItems(list);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	
	
	
	
	
	
}
