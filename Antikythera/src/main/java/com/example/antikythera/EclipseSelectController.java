package com.example.antikythera;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EclipseSelectController extends SceneController {

    @FXML
    protected void openTitleScene() {
        SceneSwapper.SwapScene("main_menu.fxml");
    }

    @FXML
    protected void openSolarEclipsePredictions() {
        SceneSwapper.SwapScene("eclipse_prediction.fxml");
    }

    @FXML
    protected void openLunarEclipsePredictions() {
        SceneSwapper.SwapScene("eclipse_prediction.fxml");
    }
}
