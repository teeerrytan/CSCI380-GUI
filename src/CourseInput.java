//@author David Stachnik

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CourseInput 
{
	public static void start()
	{
        
		//Window setup
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Exam Information");
		window.setMinWidth(500);
		window.setMinHeight(500);
		
		//Text
		Label top = new Label();
		top.setText("Enter exam info into the fields below:");
		
		//Text Fields for Exam Information
		//-----------------------------------------------------------
		TextField collegeNameField = new TextField();
		collegeNameField.setPromptText("College Name");
		
		TextField schoolNameField = new TextField();
		schoolNameField.setPromptText("School Name");
		
		TextField departmentNameField = new TextField();
		departmentNameField.setPromptText("Department Name");
		
		TextField courseIDField = new TextField();
		courseIDField.setPromptText("Course ID");
		
		TextField courseNameField = new TextField();
		courseNameField.setPromptText("Course Name");
		
		TextField examNameField = new TextField();
		examNameField.setPromptText("Exam Name");
		
		TextField examDateField = new TextField();
		examDateField.setPromptText("Exam Date");
		
		TextField instructorNameField = new TextField();
		instructorNameField.setPromptText("Instructor Name");
		
		TextField instructorEmailField = new TextField();
		instructorEmailField.setPromptText("Instructor Email");
		
		TextField semesterField = new TextField();
		semesterField.setPromptText("Semester");
		
		TextField yearField = new TextField();
		yearField.setPromptText("Year");
		//-----------------------------------------------------------
	
		//Create course button
		Button createCourse = new Button("Create Exam");
		createCourse.setOnAction(e -> 
		{
			if(Empty(collegeNameField) || Empty(schoolNameField)) //TODO - Add other fields. Check other parameters?
			{
				System.out.println("A field is not filled, try again"); // DEBUG
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Invalid Fields");
	            alert.setHeaderText(null);
	            alert.setContentText("Please correct invalid fields, including empty fields.");

	            alert.showAndWait();
			}
			else
			{
				System.out.println("All fields look good"); // DEBUG
				Connection conn = null;
		        String sql;
		        // MySQL JDBC URL format£ºjdbc:mysql://hostaddress£ºport/database_name?parameter=value
		        // assign useUnicode and characterEncoding
		        
		        final String URL = "jdbc:mysql://216.189.155.175:3307/SE_Project";
		        final String USER = "test";
		        final String PASSWORD = "123456";
				
				//LOOK HERE MINGYAO!
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("MySQL Driver is running successfully");
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement stmt = conn.createStatement();
					
					sql = "insert into Exam_Info(College_Name, School_Name, Depart_Name, Course_ID, Course_Name, Exam_Name,"
		            		+ "Exam_Date, Instructor_Name, Instructor_Email, Semester, Year) values ('" + collegeNameField.getText() + "', '" + schoolNameField.getText() + "', '" + departmentNameField.getText() + "', '" + courseIDField.getText() + "', '"
		            		+ courseNameField.getText() + "', '" + examNameField.getText() + "', '" + examDateField.getText() + "', '" + instructorNameField.getText() + "', '" + instructorEmailField.getText() +"', '" + semesterField.getText() + "', '" + yearField.getText() + "')";
					
					int result = stmt.executeUpdate(sql);// if return -1 then it crashed
			           if (result != -1) {
			               System.out.println("Successful execution!");
			               Alert alert = new Alert(AlertType.INFORMATION);
			               alert.setTitle("Successful execution!");
			               alert.setHeaderText(null);
			               alert.setContentText("You have created one record successfully! You can continue to create exams or close the window.");

			               alert.showAndWait();
			           }
				} catch (SQLException e1) {
		            System.out.println("MySQL executed unsuccessfully.");
		            e1.printStackTrace();
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        } finally {
		        	try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
				
				
				
				//TODO - Send fields to Database	
			}
			
		});
		
		//Closes window
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());
		
		//Layout
		VBox layout = new VBox(10);
		layout.getChildren().addAll(
				top,collegeNameField, schoolNameField, departmentNameField, courseIDField,
				courseNameField, examNameField, examDateField, instructorNameField, instructorEmailField, 
				semesterField, yearField, createCourse, closeButton
				);
		layout.setAlignment(Pos.CENTER);
		
		//Scene setup
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	
	}
	
	// Returns true if text field is not empty, false if empty
	private static boolean Empty(TextField input)
	{
		if(input.getText().trim().isEmpty())
		{
			System.out.println("Empty"); //DEBUG
			return true;
		}
		else
		{
			System.out.println("Not Empty"); //DEBUG
			return false;
		}
	}
	
	
	
	
	

}