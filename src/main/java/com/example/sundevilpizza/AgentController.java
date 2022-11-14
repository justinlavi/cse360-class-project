package com.example.sundevilpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class AgentController {

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
    private Label lblPizzaToppings;
    @FXML
    private Label lblOrderID;
    @FXML
    private Label lblOrderStatus;

    @FXML
    private void onRefreshButtonClick(ActionEvent event) throws IOException {

        OrderStatusController status = new OrderStatusController();
        try {
            HashMap<String, String> orderStatus = status.getOrderDetails();
            lblOrderNumber.setText(orderStatus.get("OrderID"));
            lblAccountNumber.setText(orderStatus.get("Account"));
            lblOrderTotal.setText("$" + orderStatus.get("Total"));
            lblPizzaType.setText(orderStatus.get("Type"));
            lblPizzaToppings.setText(orderStatus.get("Toppings"));
            lblOrderID.setText(orderStatus.get("OrderID"));
            lblOrderStatus.setText(OrderStatusController.getOrderStatus());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onAcceptedButtonClick(ActionEvent event) throws IOException {

        OrderStatusController.setOrderStatus("Accepted");
    }

    @FXML
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
