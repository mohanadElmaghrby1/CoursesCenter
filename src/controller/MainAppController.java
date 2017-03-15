package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class MainAppController implements Initializable {

	//the courses button in the main app
	@FXML 
	private Button coursesBtn;
	
	//the instructor button 
	@FXML
	private Button instructorBtn;
	
	@FXML
	private Button studentBtn;
	
	//the pane which change after click any button from menu 
	@FXML
	private StackPane contentAnchorPane;
	
	@FXML
	private ImageView homeImv;
	
	@FXML
	private StackPane stackImv;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)  {
		
		homeContent(null);
		System.out.println("done");
		
	}
	
	/**
	 * display the courses content to the contentAnchorPane 
	 * @param event :coursesBtn
	 * @throws IOException 
	 */
	@FXML
	public void coursesContent(ActionEvent event) throws IOException{
		
		try {
		
		//load courses FXML file to acPane
		FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/Courses.fxml").openStream());
        AnchorPane coursePane = fXMLLoader.getRoot();
        
        //clear the contentAnchorPane and set it to be courses.FXML Content 
        contentAnchorPane.getChildren().clear();
        contentAnchorPane.getChildren().add(coursePane);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
	    }
		
	}
	
	
	/**
	 * display the APP home content 
	 * @param event : homeBtn
	 */
	@FXML
	public void homeContent(ActionEvent event){
		
		try {
			
			
			//load courses FXML file to contentAnchorPane
			FXMLLoader fXMLLoader = new FXMLLoader();
			
	        fXMLLoader.load(getClass().getResource("/view/Home.fxml").openStream());
	        AnchorPane homePane = fXMLLoader.getRoot();
	        
	        //clear the contentAnchorPane and set it to be courses.FXML Content 
	        contentAnchorPane.getChildren().clear();
	        
	        //add courses.jpg image to home pane i hash it because it thro exception 
//	        Image img = new Image(getClass().getResourceAsStream("courses.jpg"));
//	        homeImv.setImage(img);
	        
	        
	        contentAnchorPane.getChildren().add(homePane);
		
	        System.out.println(" disply home content");
				
			} catch (Exception e) {
				e.printStackTrace();
			
		    }
		
	}
	
	@FXML
	public void instructorContent(ActionEvent event){
		
         try {
			
			//load courses FXML file to contentAnchorPane
			FXMLLoader fXMLLoader = new FXMLLoader();
			
	        fXMLLoader.load(getClass().getResource("/view/Instructor.fxml").openStream());
	        AnchorPane homePane = fXMLLoader.getRoot();
	        
	        //clear the contentAnchorPane and set it to be courses.FXML Content 
	        contentAnchorPane.getChildren().clear();
	        contentAnchorPane.getChildren().add(homePane);
				
	        System.out.println("disply instructo content");
				
			} catch (Exception e) {
				e.printStackTrace();
			
		    }
	}
	
	/**
	 * disply student button content
	 * @param event
	 */
	@FXML
	public void studentContent(ActionEvent event){
		
         try {
			
			//load courses FXML file to contentAnchorPane
			FXMLLoader fXMLLoader = new FXMLLoader();
			
	        fXMLLoader.load(getClass().getResource("/view/Student.fxml").openStream());
	        AnchorPane homePane = fXMLLoader.getRoot();
	        
	        //clear the contentAnchorPane and set it to be courses.FXML Content 
	        contentAnchorPane.getChildren().clear();
	        contentAnchorPane.getChildren().add(homePane);
				
	        System.out.println("disply student content");
				
			} catch (Exception e) {
				e.printStackTrace();
			
		    }
	}
	
	@FXML
	public void aboutContent (ActionEvent event){
		
		
		  try {
				
				//load courses FXML file to contentAnchorPane
				FXMLLoader fXMLLoader = new FXMLLoader();
				
		        fXMLLoader.load(getClass().getResource("/view/About.fxml").openStream());
		        AnchorPane homePane = fXMLLoader.getRoot();
		        
		        //clear the contentAnchorPane and set it to be courses.FXML Content 
		        contentAnchorPane.getChildren().clear();
		        contentAnchorPane.getChildren().add(homePane);
					
		        System.out.println("disply student content");
					
				} catch (Exception e) {
					e.printStackTrace();
				
			    }
		
		
		
	}
}
