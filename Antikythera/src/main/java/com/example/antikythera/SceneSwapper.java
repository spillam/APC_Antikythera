package com.example.antikythera;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwapper {
    public static Stage stage;

    public static SceneController GetController(String sceneUrl, FXMLLoader loader)
    {
        switch (sceneUrl)
        {
            case "main_menu.fxml":
            {
                return loader.<TitleController>getController();
            }

            case "body_select.fxml":
            {
                return loader.<BodySelectController>getController();
            }

            case "eclipse_prediction.fxml":
            {
                return loader.<EclipsePredictController>getController();
            }

            case "eclipse_select.fxml":
            {
                return loader.<EclipseSelectController>getController();
            }
        }

        return null;
    }

    public static void SwapScene(String sceneUrl)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneUrl));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            SceneController controller = GetController(sceneUrl, fxmlLoader);
            controller.Initialize(stage);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
