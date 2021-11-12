package com.example.poweranalysisproject;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AnalysisSettingsController extends Controller{
    @FXML
    private TextField cpuTreshold;

    @FXML
    private TextField diskTreshold;

    @FXML
    private TextField memoryTreshold;

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


}



