package com.example.antikythera;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TitleController extends SceneController {
    @FXML
    private Label timeLabel;

    @FXML
    private Label dateLabel;

    public void SetTimeLabel()
    {
        UniversalTime now = new UniversalTime(ZonedDateTime.now(ZoneId.of("GMT")));
        String hourString = (now.getHours() < 10 ? "0" : "") + now.getHours();
        String minuteString = (now.getMinutes() < 10 ? "0" : "") + now.getMinutes();
        timeLabel.setText(hourString + ":" + minuteString + " GMT");
        dateLabel.setText(now.getDays() + "/" + now.getMonth() + "/" + now.getYear() + " Universal Time");
    }

    @Override
    public void Initialize(Stage stage) {
        SetTimeLabel();
    }

    @FXML
    protected void openAlignmentsToday() {
        SceneSwapper.SwapScene("body_select.fxml");
    }

    @FXML
    protected void openEclipseSelect() {
        SceneSwapper.SwapScene("eclipse_select.fxml");
    }

    @FXML
    protected void openBodySelect() {
        SceneSwapper.SwapScene("body_select.fxml");
    }
}