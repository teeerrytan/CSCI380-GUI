import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

//Switching Scenes

public class Test3 extends Application 
{
	
	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		
		Label label1 = new Label("Welcome to first scene, this is a label");
		Button button1 = new Button("Go to scene 2.");
		button1.setOnAction(e -> window.setScene(scene2));
		
		//VBox is a layout that stacks object on top of each other, passed par is distance between
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1,200,200);
		
		Button button2 = new Button("Go back to scene 1.");
		button2.setOnAction(e -> window.setScene(scene1));
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2,600,300);
		
		window.setScene(scene1);
		window.setTitle("Look at my title!");
		window.show();
		
	}

}
