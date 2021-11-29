package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AnalysisSettingsController extends Controller{

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
    private DatePicker textFieldEndDate;

    @FXML
    private DatePicker textFieldStartDate;

    @FXML
    private CheckBox currTimeCheckBox;

    @FXML
    protected void clickButtonScheduleAnalysis() throws IOException {
        // Before it navigates, do error checking for the Dates, etc...
        // Set
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }

    @FXML
    protected void goBack() throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void logOut() throws IOException {
        Main.navigateToNewPage("log-in");
    }

    @FXML
    protected void goToUserPool() throws IOException {

        int cpuValid = ValidateSettingInput.validateCPUThreshold(cpuThreshold);
        int memValid = ValidateSettingInput.validateMemThreshold(memoryThreshold);
        int diskValid = ValidateSettingInput.validateDiskThreshold(diskThreshold);

        if (cpuValid > 0 && memValid > 0 && diskValid > 0) {
            verifiedDiskThreshold = diskValid;
            verifiedMemThreshold = memValid;
            verifiedCPUThreshold = cpuValid;

            Threshold threshold = new Threshold(verifiedCPUThreshold, verifiedDiskThreshold, verifiedMemThreshold);
            ProjectStateSingleton.getInstance().setCustomThreshold(threshold);
            Main.navigateToNewPage("user-pool");
        }
    }


}



