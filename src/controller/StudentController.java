package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import instructor.Instructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import list.InstructorLis;
import list.StudentList;
import student.Student;

public class StudentController implements Initializable {

	@FXML
	private TableView<StudentList> studentTable;
	
	@FXML
	private TableColumn<StudentList, Integer> idClm;
	
	@FXML
	private TableColumn<StudentList, String> firstNameClm;
	
	@FXML
	private TableColumn<StudentList, String> lastNameClm;
	
	@FXML
	private TableColumn<StudentList, String> emailClm;
	
	@FXML
	private TableColumn<StudentList, String> phoneClm;
	
	@FXML
	private TableColumn<StudentList, Integer> paymentsClm;
	
	@FXML
	private TableColumn<StudentList, String> addressClm;
	
	@FXML
	public ObservableList<StudentList> list;
	
	@FXML
	private TextField searchText;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		idClm.setCellValueFactory(new PropertyValueFactory<StudentList , Integer>("Id"));
		firstNameClm.setCellValueFactory(new PropertyValueFactory<StudentList , String>("FirstName"));
		lastNameClm.setCellValueFactory(new PropertyValueFactory<StudentList , String >("LastName"));
		emailClm.setCellValueFactory(new PropertyValueFactory<StudentList , String>("Email"));
		phoneClm.setCellValueFactory(new PropertyValueFactory< StudentList , String>("Phone"));
		paymentsClm.setCellValueFactory(new PropertyValueFactory<StudentList , Integer>("Payments"));
		addressClm.setCellValueFactory(new PropertyValueFactory<StudentList , String>("Address"));
		refresh(null);
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	public void refresh (ActionEvent event){
		System.out.println("sssssssssssssssss <<< Refresh  >>>sssssssssss");
        try {
        	//get all student object and save it to allList
        	List <Student> allList = new Student().getAllStudents();
        	
        	//if data base empty return 
        	if (allList==null){
        		System.out.println("nulllllllllllllllll");
        		return;
        	}
        		
        	//convert students objects to StudentList 
			list = FXCollections.observableArrayList( new StudentList(allList.get(0)));
					
			int i=1;
			while (i < allList.size()){
				StudentList inlist = new StudentList(allList.get(i));
				list.add(inlist);
				++i;
			
			}
			studentTable.setItems(list);
			System.out.println("set items ....................");
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
	
	
	@FXML
	public void insertNewStudent(ActionEvent event){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/InsertStudent.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Insert New Student");
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//deleteStudent
	@FXML
	public void updateNewStudent(ActionEvent event){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/UpdateStudent.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Update Student");
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@FXML
	public void deleteStudent(ActionEvent event){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/DeleteStudent.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Delete Student");
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * get id from text and pass it to student.java.search method
	 * search for student 
	 * and display data to table
	 * @param event
	 */
	@FXML
	public void search (ActionEvent event){
		
		System.out.println("search opened >>>>>>>>>>> ");

		try {
		
			Student searchedStudent = new Student().search(Integer.parseInt(searchText.getText()));
			
			//check if not found 
			if (searchedStudent==null){
				JOptionPane.showMessageDialog(null, "Student Id "+searchText.getText()+" Not Found");
				return;
			}
			System.out.println(searchedStudent.getId());
			//convert student object to studentList to display into table
			list = FXCollections.observableArrayList(new StudentList(searchedStudent));
			studentTable.setItems(list);
		
			System.out.println("searched closed >>>>>>>>>>> ");
			
		}catch (Exception e) {
			//id not correct
			JOptionPane.showMessageDialog(null, "Id Not Number");
		}
	}
	
	
	
}
