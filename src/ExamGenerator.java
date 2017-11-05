import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ExamGenerator extends Application 
{
	Stage window;
	Scene welcome, courseInput;
	
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Set the window equal to primaryStage for easy naming
		window = primaryStage;
		window.setTitle("Welcome to the Exam Builder");
		
		Button courseInputButton = new Button("New Course");
		courseInputButton.setOnAction(e -> 
		{
			System.out.println("TEST");
			window.setScene(courseInput);
		});
		
		StackPane layout1 = new StackPane();
		layout1.getChildren().addAll(courseInputButton);
		welcome = new Scene(layout1,400,200);
		window.setScene(welcome);
		window.show();
		
		
		
		
		
		Button button2 = new Button("Go back");
		button2.setOnAction(e -> window.setScene(welcome));
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		courseInput = new Scene(layout2,500,500);
		
		
		
		
	}

}
