package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DefaultSettingsController extends Controller{

    @FXML
    private TextField cpuThreshold;

    @FXML
    private TextField diskThreshold;

    @FXML
    private TextField memoryThreshold;

    @FXML
    protected void goToHomePage() throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void logOut() throws IOException {
        Main.navigateToNewPage("log-in");
    }

    @FXML
    protected void goToReportViewer() throws IOException {
        Main.navigateToNewPage("reports-viewer");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }

    @FXML
    protected void saveThresholds() throws IOException {

        Threshold threshold = ValidateSettingInput.validateSettings(cpuThreshold, memoryThreshold, diskThreshold);
        if (threshold != null)
        {
            ProjectStateSingleton.getInstance().setDefaultThreshold(threshold);
        }
    }

    public void enableAnalysis() {
        ProjectStateSingleton.getInstance().setEnabled();
    }

    public void disableAnalysis() {
        ProjectStateSingleton.getInstance().setDisabled();
    }

}
