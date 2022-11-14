package com.example.sundevilpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ChefController {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label lblOrderNumber;
    @FXML
    private Label lblAccountNumber;
    @FXML
    private Label lblOrderTotal;
    @FXML
    private Label lblPizzaType;
    @FXML
    private TextArea lblPizzaToppings;
    @FXML
    private Label lblOrderID;
    @FXML
    private Label lblOrderStatus;

    @FXML
    private void onCookingButtonClick(ActionEvent event) {
        OrderStatusController.setOrderStatus("Cooking");
    }

    @FXML
    private void OnReadyButtonClick(ActionEvent event) {
        OrderStatusController.setOrderStatus("Ready");
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
