package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class PowerAnalysisPortalController extends Controller{
    @FXML
    protected void goToAnalysisSettings() throws IOException {
        if (!ProjectStateSingleton.getInstance().getEnabled()) {
            Alert fail = new Alert(Alert.AlertType.ERROR);
            fail.setHeaderText("Start Power Analysis Failed");
            fail.setContentText("You cannot start a power analysis because they are currently disabled");
            fail.showAndWait();
        } else {
            Main.navigateToNewPage("analysis-settings");
        }
    }

    @FXML
    protected void goToActivePowerAnalysis() throws IOException {

        if (!ProjectStateSingleton.getInstance().getEnabled()) {
            Alert fail = new Alert(Alert.AlertType.ERROR);
            fail.setHeaderText("Start Power Analysis Failed");
            fail.setContentText("You cannot start a power analysis because they are currently disabled");
            fail.showAndWait();
        } else {
            ProjectStateSingleton.getInstance().setDefaultAnalysis(true);
            Main.navigateToNewPage("power-analysis-active");
        }
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }

    @FXML
    protected void logOut() throws IOException {
        Main.navigateToNewPage("log-in");
    }
}
