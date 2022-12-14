package com.example.sundevilpizza;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.HashMap;

public class OrderStatusController {

    @FXML
    private Label lblOrderID;
    @FXML
    private Label lblOrderStatus;

    HashMap<String, String> currentOrder;
    private static String orderStatus;

    public HashMap<String, String> getOrderDetails() throws IOException {
        Filesystem filesystem = new Filesystem();
        currentOrder = filesystem.readFromFile(filesystem.currentOrderDir + "/" + "output.txt");
        return currentOrder;
    }

    public static String getOrderStatus() {
        return orderStatus;
    }
    public static void setOrderStatus(String str) {
        orderStatus = str;
    }


}
