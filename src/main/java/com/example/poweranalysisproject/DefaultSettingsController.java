package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DefaultSettingsController extends Controller{
    private int verifiedCPUThreshold;
    private int verifiedMemThreshold;
    private int verifiedDiskThreshold;

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

        int cpuValid = ValidateSettingInput.validateCPUThreshold(cpuThreshold);
        int memValid = ValidateSettingInput.validateMemThreshold(memoryThreshold);
        int diskValid = ValidateSettingInput.validateDiskThreshold(diskThreshold);

        if (cpuValid > 0 && memValid > 0 && diskValid > 0) {
            verifiedDiskThreshold = diskValid;
            verifiedMemThreshold = memValid;
            verifiedCPUThreshold = cpuValid;

            Threshold threshold = new Threshold(verifiedCPUThreshold, verifiedDiskThreshold, verifiedMemThreshold);
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
