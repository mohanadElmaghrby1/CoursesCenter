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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import list.CourseList;
import list.InstructorLis;

public class InstructorController implements Initializable {

	@FXML
	private Button filterBtn;
	
	@FXML
	private Button insertNewInstBtn;
	
	@FXML
	private ComboBox<String> subjectCombo;
	
	@FXML
	private TextField searchText;
	
	@FXML
	private Button searchBtn;
	
	@FXML
	private TableView<InstructorLis> instructorTable;
	
	@FXML
	private TableColumn<InstructorLis, Integer> idClm;
	
	@FXML
	private TableColumn<InstructorLis, String> subjectClm;
	
	@FXML
	private TableColumn<InstructorLis, String> firstNameClm;
	
	@FXML
	private TableColumn<InstructorLis, String> lastNameClm;
	
	@FXML
	private TableColumn<InstructorLis, String> emailClm;
	
	@FXML
	private TableColumn<InstructorLis, String> phoneClm;
	
	@FXML
	private TableColumn<InstructorLis, Integer> sallaryClm;
	
	@FXML
	private TableColumn<InstructorLis, String> addressClm;
	
	public ObservableList<InstructorLis> list;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		subjectCombo.getItems().addAll("java" , "c++" , "python");
		
		idClm.setCellValueFactory(new PropertyValueFactory<InstructorLis , Integer>("Id"));
		subjectClm.setCellValueFactory(new PropertyValueFactory<InstructorLis , String>("Subject"));
		firstNameClm.setCellValueFactory(new PropertyValueFactory<InstructorLis , String>("FirstName"));
		lastNameClm.setCellValueFactory(new PropertyValueFactory<InstructorLis , String >("LastName"));
		emailClm.setCellValueFactory(new PropertyValueFactory<InstructorLis , String>("Email"));
		phoneClm.setCellValueFactory(new PropertyValueFactory< InstructorLis , String>("Phone"));
		sallaryClm.setCellValueFactory(new PropertyValueFactory<InstructorLis , Integer>("Sallary"));
		addressClm.setCellValueFactory(new PropertyValueFactory<InstructorLis , String>("Address"));
		refresh(null);
	}
	
	@FXML
	public void insertNewInstructor(ActionEvent event){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/InsertInstructor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Insert New Instructor");
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@FXML
	public void filter (ActionEvent event){
		
		
		try {
			subjectCombo.getValue();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Select Subject For Filter ");
			return;
		}
		
		
		try {
			
			List<Instructor> filteredList = new Instructor().filter(subjectCombo.getValue());
			
			list = FXCollections.observableArrayList( new InstructorLis(filteredList.get(0)));
			
			System.out.println("list test========="+new InstructorLis(filteredList.get(0)).getFirstName());
				
		
		int i=1;
		while (i < filteredList.size()){
			InstructorLis inlist = new InstructorLis(filteredList.get(i));
			list.add(inlist);
			++i;
			
		}
		System.out.println(list.get(0).getSubject());
		instructorTable.setItems(list);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
	@FXML
	public void refresh(ActionEvent event){
		
		System.out.println("sssssssssssssssss <<< Refresh  >>>sssssssssss");
        try {
        	List <Instructor> allList = new Instructor().getAllInstructors();
			list = FXCollections.observableArrayList( new InstructorLis(allList.get(0)));
					
			int i=1;
			while (i < allList.size()){
				InstructorLis inlist = new InstructorLis(allList.get(i));
				list.add(inlist);
				++i;
			
			}
			System.out.println(list.get(0).getSubject());
			instructorTable.setItems(list);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	
	
	
	/**
	 * get id from text and pass it to instructro.java.search method
	 * search for instructor 
	 * and display data to table
	 * @param event
	 */
	@FXML
	public void search (ActionEvent event){
		
		System.out.println("search opened >>>>>>>>>>> ");

		try {
		
			Instructor searchedInst = new Instructor().search(Integer.parseInt(searchText.getText()));
			
			//check if not found 
			if (searchedInst==null){
				JOptionPane.showMessageDialog(null, "Instructor Id "+searchText.getText()+" Not Found");
				return;
			}
			System.out.println(searchedInst.getId());
			System.out.println();
			list = FXCollections.observableArrayList(new InstructorLis(searchedInst));
			instructorTable.setItems(list);
		
			System.out.println("searched closed >>>>>>>>>>> ");
			
		}catch (Exception e) {
			//id not correct
			JOptionPane.showMessageDialog(null, "Id Not Number");
		}
	}

	
	

	/**
	 * update instructor data 
	 * @param event
	 */
	@FXML
	public void update(ActionEvent event){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/UpdateInstructor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Update Instructor");
			stage.show();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void delete (ActionEvent event){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/DeleteInstructor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Delete Instructor");
			stage.show();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
