package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import instructor.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DeleteInstructorController implements Initializable {

	
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
	private TextField subjectText2;
	
	@FXML
	private Label statusLbl2;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
		firstNameText2.setEditable(false);
		lastNameText2.setText(instructor.getLastName());
		lastNameText2.setEditable(false);
		emailText2.setText(instructor.getEmail());
		emailText2.setEditable(false);
		phoneText2.setText(instructor.getPhone());
		phoneText2.setEditable(false);
		sallaryText2.setText(Integer.toString(instructor.getSallary()));
		sallaryText2.setEditable(false);
		addressText2.setText(instructor.getAddress());
		addressText2.setEditable(false);
		subjectText2.setText(instructor.getSubject());
		subjectText2.setEditable(false);
		
	
	}
	
	@FXML
	public void delete (ActionEvent event){
		
		try {
			int id = Integer.parseInt(idText2.getText());
			if (! new Instructor().delete(id))
				JOptionPane.showMessageDialog(null, "Id Not Found");
			statusLbl2.setText("Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
