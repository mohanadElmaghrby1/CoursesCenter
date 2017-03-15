package coursesCenter;

import dataBase.CreateDataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author mohanad-elmaghrby
 *
 */
public class MainApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainApp.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/style/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
