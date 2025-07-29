package com.example.antikythera;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AntikytheraApplication extends Application {

    public static void main(String[] args) {
        SqlExecutor.OpenDatabase("jdbc:sqlite:Data/antikythera.db");
        launch(args);
        SqlExecutor.CloseDatabase();
    }

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        ResultSet rs = SqlExecutor.RunQuery("", "SELECT * FROM SolarEclipses;");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        SceneSwapper.stage = primaryStage;

        String title = "Solar Eclipse Type: ";

        while (rs.next()) {
            title += rs.getString("Type");
        }

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();

        SceneController controller = SceneSwapper.GetController("main_menu.fxml", fxmlLoader);
        controller.Initialize(primaryStage);
    }
}
