//@author David Stachnik

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Welcome extends Application 
{
	Stage window;
	Scene scene;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Set the window equal to primaryStage for easy naming
		window = primaryStage;
		
		window.setTitle("Welcome to the Exam Builder");
		
		//Code that run when user clicks X button on welcome window
		window.setOnCloseRequest(e -> 
		{
			//Prevents Close Request from automatically running
			e.consume();
			//Run closeProgram class
			closeProgram();
		});
		//Text
		Label label1 = new Label("What would you like to do?");
		
		//New Course Button
		Button newCourseButtuon = new Button("Enter New Exam Info");
		newCourseButtuon.setOnAction(e -> 
		{
			
			
			System.out.println("New Course"); //DEBUG ONLY
			CourseInput.start();
		});
		
		//Close Button
		Button closeButton = new Button("Close");
		//Runs closeProgram Method when closeButton is pressed
		closeButton.setOnAction(e -> closeProgram());
		
		
		//Layout Setup
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, newCourseButtuon, closeButton);
		scene = new Scene(layout1,500,200);
		
		//Window setup
		window.setMinWidth(500);
		window.setMinHeight(200);
		window.setScene(scene);
		window.show();
		
		
		
		
		
	}
	
	//Class that should run before the program exits
	private void closeProgram()
	{
		System.out.println("Program Closing"); //DEBUG
		Platform.exit();
	}

}
