package com.example.sundevilpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
    // Strings which hold css elements to easily re-use in the application
    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");
    
    @FXML
    private Label lblLoginStatus;
    @FXML
    private TextField tfLoginPrompt;
    
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        if (tfLoginPrompt.getText().isBlank()) {
        	lblLoginStatus.setText("Login field is empty!");
        	lblLoginStatus.setStyle(errorMessage);
        	tfLoginPrompt.setStyle(errorStyle);

            
        } else if (tfLoginPrompt.getText().equals("customer")) {
        	// use filesystem to read from valid ASURITE ids
        	loadScene(event, "Customer.fxml");
        }  else if (tfLoginPrompt.getText().equals("agent")) {
        	// what should the op agent's login be?
        	loadScene(event, "Agent.fxml");
        }  else if (tfLoginPrompt.getText().equals("chef")) {
        	// what should the chef's login be?
        	loadScene(event, "Chef.fxml");
        } else {
        	lblLoginStatus.setText("Invalid UserID");
        	lblLoginStatus.setStyle(errorMessage);
        }
	}
    
    public void onLogoutButtonClick(ActionEvent event) throws IOException {
    	loadScene(event, "Login.fxml");
    }
    
	public void loadScene(ActionEvent event, String sceneFile) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(sceneFile));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

