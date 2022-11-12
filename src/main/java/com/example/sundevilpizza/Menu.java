package com.example.sundevilpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class Menu {

	@FXML
	private RadioButton rbCheese;
	@FXML
	private RadioButton rbPepperoni;
	@FXML
	private RadioButton rbVeggie;
	@FXML
	private CheckBox cbExtraCheese;
	@FXML
	private CheckBox cbBacon;
	@FXML
	private CheckBox cbMushroom;
	@FXML
	private Label lblPrice;
	
	@FXML
	private void handleCalculateButton(ActionEvent event) {
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
		
		lblPrice.setText("$" + String.format("%.2f", price));
	}
}
