package com.example.sundevilpizza;

import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class CustomerController {

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

	private double orderTotal;

	@FXML
	public void calculateTotal() {
		double price = 0.0;

		// Pizza Type
		if (rbCheese.isSelected()) {
			price = 10.00;
		} else if (rbPepperoni.isSelected()) {
			price = 12.00;
		} else if (rbVeggie.isSelected()) {
			price = 15.00;
		}

		// Pizza Toppings
		if (cbExtraCheese.isSelected()) { price += 1.50; }
		if (cbBacon.isSelected()) { price += 1.50; }
		if (cbMushroom.isSelected()) { price += 1.50; }

		lblTotal.setText("$" + String.format("%.2f", price));
		orderTotal = price;
	}

	@FXML
	private void handleOrderButton(ActionEvent event) {
		calculateTotal();
	}


}
