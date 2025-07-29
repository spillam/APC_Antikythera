module com.example.antikythera {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.antikythera to javafx.fxml;
    exports com.example.antikythera;
}