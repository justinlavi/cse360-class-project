module com.example.sundevilpizza {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    requires org.controlsfx.controls;

    opens com.example.sundevilpizza to javafx.fxml;
    exports com.example.sundevilpizza;
}