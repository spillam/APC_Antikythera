package com.example.antikythera;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class EclipsePredictController extends SceneController {

    @FXML
    TableView eclipseView;

    @Override
    public void Initialize(Stage stage)
    {
        eclipseView.setEditable(true);
        TableColumn firstNameCol = new TableColumn("Saros");
        firstNameCol.setMinWidth(50);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<SolarEclipse, String>("Saros"));


        TableColumn secondNameCol = new TableColumn("Magnitude");
        secondNameCol.setMinWidth(75);
        secondNameCol.setCellValueFactory(new PropertyValueFactory<SolarEclipse, String>("Magnitude"));

        TableColumn thirdNameCol = new TableColumn("Date");
        thirdNameCol.setMinWidth(75);
        thirdNameCol.setCellValueFactory(new PropertyValueFactory<SolarEclipse, String>("Time"));


        EclipseFinder ef = new EclipseFinder();
        List<SolarEclipse> solarEclipses = ef.GetSolarEclipses();

        eclipseView.setItems(FXCollections.observableArrayList(solarEclipses));

        eclipseView.getColumns().add(firstNameCol);
        eclipseView.getColumns().add(secondNameCol);
        eclipseView.getColumns().add(thirdNameCol);
    }

    @FXML
    protected void openEclipseSelect() {
        SceneSwapper.SwapScene("eclipse_select.fxml");
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
