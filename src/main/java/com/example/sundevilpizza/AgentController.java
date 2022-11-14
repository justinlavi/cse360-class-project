package com.example.sundevilpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AgentController {

    private Stage stage;
    private Scene scene;


    private void onLogoutButtonClick(ActionEvent event) throws IOException {
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
