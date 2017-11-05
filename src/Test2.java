import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Button with action

public class Test2 extends Application
{

	Button button;
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("Window Title");
		
		button = new Button();
		
		button.setText("My first button");
		
		button.setOnAction(e -> {
			System.out.println("Opening alert box");
			AlertBox.display("The title from para", "Look at my message");
		});
		
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout,500,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	
	
	
	
}