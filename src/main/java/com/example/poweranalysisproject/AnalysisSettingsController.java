package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AnalysisSettingsController extends Controller{

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

        Threshold threshold = ValidateSettingInput.validateSettings(cpuThreshold, memoryThreshold, diskThreshold);
        if (threshold != null)
        {
            ProjectStateSingleton.getInstance().setCustomThreshold(threshold);
            Main.navigateToNewPage("user-pool");
        }
    }



}



