package com.example.sundevilpizza;

import com.example.sundevilpizza.CustomerController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sun Devil Pizza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //do your stuff here...
                CustomerController customer = new CustomerController();
                //customer.calculateTotal();
                //System.out.println("HELLO");
            }
        }, 0, 1000);

        launch();

        timer.cancel();
    }
}