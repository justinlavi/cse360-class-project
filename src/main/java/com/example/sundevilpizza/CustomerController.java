package com.example.sundevilpizza;

import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class CustomerController {

	private Stage stage;
	private Scene scene;

	@FXML
	private RadioButton rbPepperoni;
	@FXML
	private RadioButton rbVeggie;
	@FXML
	private RadioButton rbCheese;
	@FXML
	private CheckBox cbExtraCheese;
	@FXML
	private CheckBox cbBacon;
	@FXML
	private CheckBox cbMushroom;
	@FXML
	private Label lblTotal;
	@FXML
	private Button btnOrder;
	@FXML
	private Label lblOrderID;
	@FXML
	private Label lblOrderStatus;

	private int orderID;
	private String customerID;
	private double orderTotal;
	private String pizzaType;
	private String pizzaToppings;
	private String orderStatus;

	@FXML
	public void calculateTotal() {
		double price = 0.0;
		StringBuilder sb = new StringBuilder();

		// Pizza Type
		if (rbCheese.isSelected()) {
			pizzaType = "Cheese";
			price = 10.00;
		} else if (rbPepperoni.isSelected()) {
			pizzaType = "Pepperoni";
			price = 12.00;
		} else if (rbVeggie.isSelected()) {
			pizzaType = "Veggie";
			price = 15.00;
		}

		// Pizza Toppings
		if (cbExtraCheese.isSelected()) {
			sb.append("+ExtraCheese");
			price += 1.50;
		}
		if (cbBacon.isSelected()) {
			sb.append("+Bacon");
			price += 1.50; }
		if (cbMushroom.isSelected()) {
			sb.append("+Mushroom");
			price += 1.50;
		}

		lblTotal.setText("$" + String.format("%.2f", price));
		orderTotal = price;
		pizzaToppings = String.valueOf(sb);
	}

	@FXML
	private void onRefreshButtonClick(ActionEvent event) throws IOException {

		OrderStatusController status = new OrderStatusController();
		try {
			HashMap<String, String> orderStatus = status.getOrderStatus();
			lblOrderID.setText(orderStatus.get("OrderID"));
			lblOrderStatus.setText(orderStatus.get("Status"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@FXML
	private void onOrderButtonClick(ActionEvent event) throws IOException {
		// store order into string
		orderID = 1;
		customerID = "";
		pizzaType = "";
		pizzaToppings = "";
		orderStatus = "Submitted";
		calculateTotal();
		String orderIDStr = Integer.toString(orderID);
		String order = "";
		order = orderID + "," +
				customerID + "," +
				orderTotal + "," +
				pizzaType + "," +
				pizzaToppings + "," +
				orderStatus;

		// write order to file
		Filesystem filesystem = new Filesystem();
		filesystem.writeToFile(order);
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
